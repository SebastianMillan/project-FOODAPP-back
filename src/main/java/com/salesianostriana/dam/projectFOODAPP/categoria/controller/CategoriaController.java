package com.salesianostriana.dam.projectFOODAPP.categoria.controller;

import com.salesianostriana.dam.projectFOODAPP.categoria.dto.EditCategoriaDTO;
import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetDtoCategoriaConCantProductos;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
                            array = @ArraySchema(schema = @Schema(implementation = GetDtoCategoriaConCantProductos.class)),
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
    public List<GetDtoCategoriaConCantProductos> getAllCategoriasByAdmin(){

        List<Categoria> categorias = categoriaService.getAllCategorias();

        List<GetDtoCategoriaConCantProductos> categoriasDTO = new ArrayList<>();
        for(Categoria categoria: categorias){
            categoriasDTO.add(GetDtoCategoriaConCantProductos.of
                    (categoria,
                            categoriaService.contarCantidadProductosDeUnaCategoria(categoria.getId()))
                    );
        }

        return categoriasDTO;
    }


    public ResponseEntity<EditCategoriaDTO> createCategoria (@RequestBody EditCategoriaDTO nuevaCategoria){
        Categoria cat = categoriaService.createCategoria(nuevaCategoria);

        return ResponseEntity.status(201).body()
    }
}
