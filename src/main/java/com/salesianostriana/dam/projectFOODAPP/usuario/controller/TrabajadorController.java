package com.salesianostriana.dam.projectFOODAPP.usuario.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.projectFOODAPP.View.MenuProductosView;
import com.salesianostriana.dam.projectFOODAPP.View.ProductView;

import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaProductsDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.service.CategoriaService;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetDetallePedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetLineaPedidoClienteDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetLineaPedidoEnPedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.LineaPedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.repository.PedidoRepository;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.EditProductDto;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetDtoProducto;
import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;

import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;

import com.salesianostriana.dam.projectFOODAPP.producto.repository.ProductoRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.*;

import com.salesianostriana.dam.projectFOODAPP.producto.service.ProductoService;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
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


import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TrabajadorController {

    private final CategoriaService categoriaService;
    private final TrabajadorService trabajadorService;
    private final ProductoService productoService;
    private final PedidoService pedidoService;
    private final ProductoRepository productoRepository;


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
    public Page<GetProductShortDto> getProductoCategory(@Valid @PathVariable String nombreCategoria, @PageableDefault(page = 0, size = 4) Pageable pageable) {

        Page<Producto> productos = categoriaService.getProductsCategory(nombreCategoria.toLowerCase(), pageable);

        return productos.map(GetProductShortDto::of);

    }


    @Operation(summary = "Obtiene una lista de trabajadores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado trabajadores",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Categoria.class)),
                            examples = {@ExampleObject(
                                    value = """
                                                {
                                                    "content": [
                                                        {
                                                            "id": "c0a8000b-8c0a-1df7-818c-0aae00f80008",
                                                            "nombre": "Pedro Franch",
                                                            "puesto": "REPARTIDOR"
                                                        },
                                                        {
                                                            "id": "c0a8000b-8c0a-1df7-818c-0aae00f80009",
                                                            "nombre": "Fernando Claro",
                                                            "puesto": "COCINERO"
                                                        }
                                                    ],
                                                    "pageable": {
                                                        "pageNumber": 0,
                                                        "pageSize": 5,
                                                        "sort": {
                                                            "empty": true,
                                                            "sorted": false,
                                                            "unsorted": true
                                                        },
                                                        "offset": 0,
                                                        "unpaged": false,
                                                        "paged": true
                                                    },
                                                    "last": true,
                                                    "totalPages": 1,
                                                    "totalElements": 2,
                                                    "size": 5,
                                                    "number": 0,
                                                    "sort": {
                                                        "empty": true,
                                                        "sorted": false,
                                                        "unsorted": true
                                                    },
                                                    "first": true,
                                                    "numberOfElements": 2,
                                                    "empty": false
                                                }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "La lista esta vacía",
                    content = @Content),
    })
    @GetMapping("/admin/trabajador")
    public Page<GetTrabajadorDto> getAllTrabajadores(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Trabajador> trabajadorList = trabajadorService.findAllTrabajadores(pageable);
        return trabajadorList.map(GetTrabajadorDto::of);

    }

    @Operation(summary = "Añades un un producto a una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Creación del producto",
                    content = {@Content(mediaType = "aplication/json",
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
    public ResponseEntity<GetDtoProducto> addProduct(@Valid @RequestBody EditProductDto newProduct) {
        Producto p = productoService.save(newProduct);

        return ResponseEntity
                .status(201)
                .body(GetDtoProducto.of(p));
    }

    @Operation(summary = "Borra un producto por su id")
    @ApiResponse(responseCode = "204 No Content",
            description = "Borrado con éxito",
            content = @Content)
    @DeleteMapping("/admin/delete/producto/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Borrar un trabajador")
    @ApiResponse(responseCode = "204 No Content",
            description = "Borrado correctamente",
            content = @Content)
    @DeleteMapping("/admin/delete/trabajador/{id}")
    public ResponseEntity<?> deleteTranajador(@PathVariable String id) {
        trabajadorService.eliminarTrabajador(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Añadeir un un trabajador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Alta del trabajador",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Trabajador.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                 "id": "c0a8000b-8c0a-1df7-818c-0ab12744000e",
                                                 "nombre": "pedrola",
                                                 "puesto": "COCINERO"
                                             }
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "400",
                    description = "Error al dal de alta un trabajador",
                    content = @Content)
    })
    @PostMapping("/admin/trabajador")
    public ResponseEntity<GetTrabajadorDto> nuevoTrabajador(@Valid @RequestBody AltaTrabajadorDto trabajadorNuevo) {
        Trabajador trabajador = trabajadorService.save(trabajadorNuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(GetTrabajadorDto.of(trabajador));
    }

    @Operation(summary = "Editar producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Editar un producto",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "nombre": "Ensaladilla",
                                                "imagen": "https://upload.jpg",
                                                "descripcion": "Una buena ensaladilla para los dolores de rodilla",
                                                "precio": 1.3,
                                                "tags": [
                                                    "sano",
                                                    "rico"
                                                ]
                                            }
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "500",
                    description = "Error al encontrar el producto para editar",
                    content = @Content)
    })
    @JsonView(ProductView.editProduct.class)
    @PutMapping("/admin/edit/product/{id}")
    public GetDtoProducto edit(@Valid @PathVariable String id, @RequestBody EditProductDto editProduct) {

        Producto p = productoService.edit(editProduct, id);

        return GetDtoProducto.of(p);

    }

    @Operation(summary = "Detalles producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Detalles un producto",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "ac19c001-8c11-176c-818c-11a777a80004",
                                                "nombre": "Patatas Bravas",
                                                "imagen": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Patatas_bravas_madrid.jpg/640px-Patatas_bravas_madrid.jpg",
                                                "descripcion": "Patatas fritas acompañadas con una salsa picante de tomate Goya.",
                                                "precio": 2.3,
                                                "tags": [
                                                    "patatas",
                                                    "bravas"
                                                ],
                                                "categoria": {
                                                    "nombre": "Tapas"
                                                }
                                            }
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "500",
                    description = "Error al encontrar el producto para mostrar los detalles",
                    content = @Content)
    })
    @GetMapping("/admin/product/details/{id}")
    public GetDtoProducto details(@Valid @PathVariable String id) {

        Producto p = productoService.details(id);

        return GetDtoProducto.of(p);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trabajador editado correctamente", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetTrabajadorDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a8000b-8c0a-1df7-818c-0ab12744000e",
                                                "nombre": "pedrola",
                                                "puesto": "COCINERO"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "400", description = "Error en los datos", content = @Content),
            @ApiResponse(responseCode = "500", description = "El trabajador con id {id} no ha sido encontrado", content = @Content)
    })
    @PutMapping("/admin/trabajador/{id}")
    public ResponseEntity<GetTrabajadorDto> editarTrabajador(@PathVariable String id, @RequestBody PutTrabajadorDto trabajadorDto) {
        return ResponseEntity.ok(GetTrabajadorDto.of(trabajadorService.edit(id, trabajadorDto)));
    }





    @Operation(summary = "Obtiene un trabajador por su UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Trabajdor",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a8000b-8c1c-1f4b-818c-1c5f56400008",
                                                "nombre": "Pedro Franch",
                                                "email": "pedro@gmail.com",
                                                "telefono": "545656767",
                                                "username": "pedro",
                                                "password": "{bcrypt}$2a$10$hEWDj3xWwKuFu4htt1omeecHjgPM.KGLAXwHwCWzwQJuQaqt0YTe2",
                                                "puesto": "REPARTIDOR",
                                                "fechaNacimiento": "2000-07-26"
                                            }
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = @Content)
    })
    @GetMapping("/admin/trabajador/{id}")
    public GetTrabajadorDto obtenerTrabajador(@PathVariable String id) {
        Trabajador t = trabajadorService.bucarUIID(id);
        return GetTrabajadorDto.of(t);
    }


    @Operation(summary = "Todos los pedido")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Todos los pedido",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Pedido.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                   {
                                                       "id": "ac1ce001-8c1a-1090-818c-1a409af7000a",
                                                       "fecha": "29/11/2023 09:44",
                                                       "cliente": "Sebastián Millán",
                                                       "estadoPedido": "EN_PREPARACION",
                                                       "importe": 2.3
                                                   },
                                                   {
                                                       "id": "ac1ce001-8c1a-1090-818c-1a409afc000c",
                                                       "fecha": "29/11/2023 09:44",
                                                       "cliente": "Francisco Claro",
                                                       "estadoPedido": "CONFIRMADO",
                                                       "importe": 10.9
                                                   },
                                                   {
                                                       "id": "ac1ce001-8c1a-1090-818c-1a409afd000f",
                                                       "fecha": "29/11/2023 09:44",
                                                       "cliente": "Francisco Claro",
                                                       "estadoPedido": "CONFIRMADO",
                                                       "importe": 12.6
                                                   }
                                               ]
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "500",
                    description = "Error al encontrar el pedido para mostrar la lista",
                    content = @Content)
    })
    @GetMapping("/admin/pedido")
    public Page<GetPedidoDto> getPedidos(@PageableDefault(page = 0, size = 5) Pageable pageable) {

        return pedidoService.getAllPedidosv2(pageable);
    }

    @Operation(summary = "Detalle de un pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Detalle de un pedido",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Pedido.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                        "id": "ac19c001-8c1c-16c9-818c-1c36d7a4000a",
                                                        "direccion": "c/Condes de Bustillo, 17",
                                                        "telefono": "987654111",
                                                        "estadoPedido": "EN_PREPARACION",
                                                        "horaLlegada": "29-11-2023 18:53",
                                                        "lineasPedido": [
                                                        {
                                                        "nombreProducto": "Patatas Bravas",
                                                        "cantidadProductos": 1,
                                                        "precioUnit": 2.3,
                                                        "subtotal": 2.3
                                                        }
                                                        ],
                                                        "total": 2.3
                                                        }
                                                
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "500",
                    description = "Error al encontrar el pedido para mostrar la lista",
                    content = @Content)
    })
    @GetMapping("/admin/pedido/{idPedido}")
    public GetDetallePedidoDto getDetallesDeUnPedido(@PathVariable UUID idPedido) {

        return pedidoService.getPedidoDetailsDto(idPedido);
    }

    @Operation(summary = "Devueve el trabajador logueado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Trabajdor",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a8000b-8c1b-11da-818c-1b91e44b0009",
                                                "nombre": "Fernando Claro",
                                                "email": "fer@gmail.com",
                                                "telefono": "121232888",
                                                "username": "fer",
                                                "puesto": "COCINERO",
                                                "rol": "[ADMIN, TRABAJADOR]",
                                                "fechaNacimiento": "2002-11-13" 
                                            }
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = @Content)
    })
    @GetMapping("/trabajador/profile")
    public TrabajadorLoggedDto getLoggedUser(@AuthenticationPrincipal Trabajador trabajador) {
        return TrabajadorLoggedDto.of(trabajador);
    }


    @Operation(summary = "Devueve el puesto de un trabajador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Trabajdor",
                    content = {@Content(mediaType = "aplication/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a8000b-8c1b-1ba7-818c-1b9bafe40008",
                                                "puesto": "REPARTIDOR"
                                            }
                                            """
                            )}
                    )}),

            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = @Content)
    })
    @GetMapping("/trabajador/puesto/{id}")
    public PuestoTrabajador obtenerPuesto(@PathVariable String id){
        Trabajador t = trabajadorService.bucarUIID(id);
        return PuestoTrabajador.of(t);
    }
}






