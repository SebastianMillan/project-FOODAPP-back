package com.salesianostriana.dam.projectFOODAPP.producto.controller;

import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.service.ProductoService;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetClienteDtoDetail;
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

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener Producto del mes", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetProductShortDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a84001-8c00-1bd2-818c-007bdc400007",
                                                "nombre": "Tarta de Queso",
                                                "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                "descripcion": "Tarta de Queso Philadephia con arandanos",
                                                "precio": 2.4
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @Operation(summary = "getMonthProduct", description = "Obtener el Producto del mes")
    @GetMapping("/month_product")
    public GetProductShortDto getMonthProduct(){
        return GetProductShortDto.of(productoService.getMonthProduct());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener productos en oferta", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetProductShortDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": "c0a84001-8c00-1bd2-818c-007bdc400006",
                                                    "nombre": "Tarta de queso",
                                                    "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                    "descripcion": "Tarta de queso philadelphia super cremosa.",
                                                    "precio": 3.0
                                                },
                                                {
                                                    "id": "c0a84001-8c00-1bd2-818c-007bdc400007",
                                                    "nombre": "Hamburguesa Queso",
                                                    "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                    "descripcion": "Hamburguesa de Buey con queso de cabra",
                                                    "precio": 2.4
                                                }
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404", description = "Listado de Producto vacio", content = @Content)
    })
    @Operation(summary = "getProductOnOffer", description = "Obtener productos en oferta")
    @GetMapping("/offer_product")
    public List<GetProductShortDto> getProductOnOffer(){
        return productoService.getProductsOnOffer().stream()
                .map(GetProductShortDto::of)
                .toList();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener productos en novedad", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetProductShortDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": "c0a84001-8c00-1bd2-818c-007bdc400006",
                                                    "nombre": "Tarta de queso",
                                                    "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                    "descripcion": "Tarta de queso philadelphia super cremosa.",
                                                    "precio": 3.0
                                                },
                                                {
                                                    "id": "c0a84001-8c00-1bd2-818c-007bdc400007",
                                                    "nombre": "Hamburguesa Queso",
                                                    "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                    "descripcion": "Hamburguesa de Buey con queso de cabra",
                                                    "precio": 2.4
                                                }
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404", description = "Listado de Producto vacio", content = @Content)
    })
    @Operation(summary = "getProductNews", description = "Obtener productos en novedad")
    @GetMapping("/new_product")
    public List<GetProductShortDto> getProductNews(){
        return productoService.getProductNews().stream()
                .map(GetProductShortDto::of)
                .toList();
    }
}
