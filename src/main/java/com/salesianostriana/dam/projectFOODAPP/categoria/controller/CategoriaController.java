package com.salesianostriana.dam.projectFOODAPP.categoria.controller;

import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetDtoCategoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.categoria.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener Categorías", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetDtoCategoria.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "nombre": "Tapas",
                                                "cantProductos": "3"
                                                
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada", content = @Content)
    })
    @Operation(summary = "getAllCategorias", description = "Obtener una lista de categorías")
    @GetMapping("/admin/categoria/")
    public List<GetDtoCategoria> getAllCategoriasByAdmin(){

        List<Categoria> categorias = categoriaService.getAllCategorias();

        List<GetDtoCategoria> categoriasDTO = new ArrayList<>();
        for(Categoria categoria: categorias){
            categoriasDTO.add(GetDtoCategoria.of
                    (categoria,
                            categoriaService.contarCantidadProductosDeUnaCategoria(categoria.getId()))
                    );
        }

        return categoriasDTO;
    }
}
