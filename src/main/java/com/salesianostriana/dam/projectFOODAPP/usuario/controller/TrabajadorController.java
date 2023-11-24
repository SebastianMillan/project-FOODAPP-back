package com.salesianostriana.dam.projectFOODAPP.usuario.controller;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetTrabajadorDto;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.TrabajadorRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.TrabajadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/trabajador")
@RestController
@RequiredArgsConstructor
public class TrabajadorController {

private final TrabajadorService trabajadorService;



    @Operation(summary = "Obtiene una lista de trabajadores")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
            description = "Se han encontrado trabajadores",
            content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = Categoria.class)),
            examples = {@ExampleObject(
                    value = """
                            [
                            {
                            "nombe":"Pedro",
                            "puesto":"Cocinero"
                            }
                            {
                            "nombre":"Francisco",
                            "puesto":"Repartidor"
                            }
                            ]
                            """
            )}
            )}),
            @ApiResponse(responseCode = "404",
            description = "La lista esta vacía",
            content = @Content),
    })
    @GetMapping("/")
    public Page<GetTrabajadorDto> getAllTrabajadores(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Trabajador> trabajadorList = trabajadorService.findAllTrabajadores(pageable);
        return trabajadorList.map(GetTrabajadorDto::of);
    }

    @PostMapping("/admin/")
    public ResponseEntity<PostDtoTrabajador> nuevoTrabajador (@RequestBody PostDtoTrabajador trabajadorNuevo){

    }
}
