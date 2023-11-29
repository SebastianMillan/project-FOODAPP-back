package com.salesianostriana.dam.projectFOODAPP.usuario.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.projectFOODAPP.View.MenuProductosView;
import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaProductsDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.service.CategoriaService;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetClienteDtoDetail;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetDtoCliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.ClienteService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final CategoriaService categoriaService;

    @GetMapping("/cliente/")
    public List<Cliente> getAllClientes() {
        return clienteService.getAll();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener lista de Clientes", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetDtoCliente.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                 {
                                                     "id": "c0a801c6-8c02-1570-818c-02b57ee60002",
                                                     "username": "sebastian",
                                                     "nombre": "Sebastián Millán",
                                                     "puntos": 50,
                                                     "numPedidos": 1
                                                 },
                                                 {
                                                     "id": "c0a801c6-8c02-1570-818c-02b57ef60003",
                                                     "username": "fran",
                                                     "nombre": "Francisco Claro",
                                                     "puntos": 100,
                                                     "numPedidos": 1
                                                 }
                                             ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404", description = "Lista de clientes vacia", content = @Content)
    })
    @Operation(summary = "getAllClientsByAdmin", description = "Obtener una lista de Clientes")
    @GetMapping("/admin/client/")
    public Page<GetDtoCliente> getAllClientsByAdmin(@PageableDefault(page = 0, size = 4) Pageable pageable) {
        return clienteService.getAllDtoCliente(pageable);
    }

    @Operation(summary = "Menú de un restaurante")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Menú del Restaurante",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                                                       [
                                                {
                                                    "nombre": "Tapas",
                                                    "productos": [
                                                        {
                                                            "nombre": "Patatas Bravas",
                                                            "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Patatas_bravas_madrid.jpg/640px-Patatas_bravas_madrid.jpg",
                                                            "descripcion": "Patatas fritas acompañadas con una salsa picante de tomate Goya.",
                                                            "precio": 2.3,
                                                            "tags": [
                                                                "patatas",
                                                                "bravas"
                                                            ]
                                                        },
                                                        {
                                                            "nombre": "Plato de Jamón Ibérico",
                                                            "imagen": "https://phantom-expansion.unidadeditorial.es/4a18f7865539ab348461b2ff7fc87fe4/crop/0x455/1197x1253/f/jpg/assets/multimedia/imagenes/2022/02/24/16457011092381.jpg",
                                                            "descripcion": "Plato de Jamón 100% Ibérico y curado",
                                                            "precio": 6.3,
                                                            "tags": [
                                                                "Jamón",
                                                                "Ibérico",
                                                                "De Bellota"
                                                            ]
                                                        },
                                                        {
                                                            "nombre": "Hamburguesa Queso",
                                                            "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                            "descripcion": "Hamburguesa de Buey con queso de cabra",
                                                            "precio": 2.4,
                                                            "tags": [
                                                                "Queso",
                                                                "Hamburguesa",
                                                                "Buey"
                                                            ]
                                                        }
                                                    ]
                                                },
                                                {
                                                    "nombre": "Postres",
                                                    "productos": [
                                                        {
                                                            "nombre": "Tarta de queso",
                                                            "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                            "descripcion": "Tarta de queso philadelphia super cremosa.",
                                                            "precio": 3.0,
                                                            "tags": [
                                                                "Tarta",
                                                                "Queso",
                                                                "Cremosa"
                                                            ]
                                                        }
                                                    ]
                                                }
                                            ]
                                                                                        """
                            )}
                    )}),

            @ApiResponse(responseCode = "500",
                    description = "Error al cargar el menú",
                    content = @Content)
    })
    @JsonView(MenuProductosView.menu.class)
    @GetMapping("/menu")
    public List<GetCategoriaProductsDto> categoriaProductsDtoList() {

        return categoriaService.categoryWithProductsV2();

    }

}
