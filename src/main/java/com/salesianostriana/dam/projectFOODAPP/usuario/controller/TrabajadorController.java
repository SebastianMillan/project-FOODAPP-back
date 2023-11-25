package com.salesianostriana.dam.projectFOODAPP.usuario.controller;


import com.salesianostriana.dam.projectFOODAPP.categoria.service.CategoriaService;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.EditProductDto;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetDtoProducto;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.producto.service.ProductoService;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetTrabajadorDto;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.TrabajadorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class TrabajadorController {

    private final CategoriaService categoriaService;
    private final TrabajadorService trabajadorService;
    private final ProductoService productoService;

    @Operation(summary = "Muestra una lista de los productos de una categoría")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Lista de productos de una categoría",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": "ac1ce001-8c00-1ae5-818c-005aedc20004",
                                                    "nombre": "Patatas Bravas",
                                                    "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Patatas_bravas_madrid.jpg/640px-Patatas_bravas_madrid.jpg",
                                                    "descripcion": "Patatas fritas acompañadas con una salsa picante de tomate Goya.",
                                                    "precio": 2.3
                                                },
                                                {
                                                    "id": "ac1ce001-8c00-1ae5-818c-005aedc30005",
                                                    "nombre": "Plato de Jamón Ibérico",
                                                    "imagen": "https://phantom-expansion.unidadeditorial.es/4a18f7865539ab348461b2ff7fc87fe4/crop/0x455/1197x1253/f/jpg/assets/multimedia/imagenes/2022/02/24/16457011092381.jpg",
                                                    "descripcion": "Plato de Jamón 100% Ibérico y curado",
                                                    "precio": 6.3
                                                },
                                                {
                                                    "id": "ac1ce001-8c00-1ae5-818c-005aedc30007",
                                                    "nombre": "Hamburguesa Queso",
                                                    "imagen": "https://i.blogs.es/75907e/tarta_queso_philadelphia-min/1366_2000.jpeg",
                                                    "descripcion": "Hamburguesa de Buey con queso de cabra",
                                                    "precio": 2.4
                                                }
                                            ]
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = @Content)
    })
    @GetMapping("/admin/producto/{nombreCategoria}")
    public List<GetProductShortDto> getProductoCategory(@PathVariable String nombreCategoria) {

        List<Producto> productos = categoriaService.getProductsCategory(nombreCategoria);

        return productos.stream()
                .map(GetProductShortDto::of)
                .toList();
    }
    @Operation(summary = "Obtiene una lista de trabajadores")
    @ApiResponses(value = {
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
    @GetMapping("/admin/trabajador")
    public Page<GetTrabajadorDto> getAllTrabajadores (@PageableDefault(page = 0, size = 5) Pageable pageable){
        Page<Trabajador> trabajadorList = trabajadorService.findAllTrabajadores(pageable);
        return trabajadorList.map(GetTrabajadorDto::of);

    }

    @Operation(summary = "Añades un un producto a una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Creación del producto",
                    content = { @Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                      "id": "ac19c001-8c06-178e-818c-0687df90000e",
                                                      "nombre": "Picos",
                                                      "imagen": "https://st.depositphotos.com/2078351/2100/i/450/depositphotos_21008703-stock-photo-a-bread-peaks-over-white.jpg",
                                                      "descripcion": "picos",
                                                      "precio": 0.13,
                                                      "tags": [
                                                          "pan",
                                                          "integral"
                                                      ],
                                                      "categoria": {
                                                          "nombre": "Tapas"
                                                      }
                                                  }
                                            ]
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "400",
                    description = "Error al crear un producto",
                    content = @Content)
    })
    @PostMapping("/admin/add/producto")
    public ResponseEntity<GetDtoProducto> addProduct (@Valid @RequestBody EditProductDto newProduct){
        Producto p = productoService.save(newProduct);

        return ResponseEntity
                .status(201)
                .body(GetDtoProducto.of(p));
    }

}