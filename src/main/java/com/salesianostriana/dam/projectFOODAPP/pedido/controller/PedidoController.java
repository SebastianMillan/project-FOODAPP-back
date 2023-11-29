package com.salesianostriana.dam.projectFOODAPP.pedido.controller;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoDetallesDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.exception.PedidoNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.ClienteService;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.EditEstadoPedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetDetallePedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoEnCocinero;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;

    @GetMapping("/pedido/")
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener lista de Pedidos del cocinero", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetPedidoEnCocinero.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "content": [
                                                    {
                                                        "id": "ac1b0662-8c10-134a-818c-10e355b1000a",
                                                        "fecha": "2023-11-27T14:06:23.280957",
                                                        "estadoPedido": "EN_PREPARACION",
                                                        "lineasPedido": [
                                                            {
                                                                "producto": "Patatas Bravas",
                                                                "cantidad": 1
                                                            }
                                                        ]
                                                    },
                                                    {
                                                        "id": "ac1b0662-8c10-134a-818c-10e355b5000c",
                                                        "fecha": "2023-11-27T14:06:23.280957",
                                                        "estadoPedido": "CONFIRMADO",
                                                        "lineasPedido": [
                                                            {
                                                                "producto": "Plato de Jamón Ibérico",
                                                                "cantidad": 1
                                                            }
                                                        ]
                                                    }
                                                ],
                                                "pageable": {
                                                    "pageNumber": 0,
                                                    "pageSize": 4,
                                                    "sort": {
                                                        "empty": true,
                                                        "unsorted": true,
                                                        "sorted": false
                                                    },
                                                    "offset": 0,
                                                    "paged": true,
                                                    "unpaged": false
                                                },
                                                "last": true,
                                                "totalPages": 1,
                                                "totalElements": 2,
                                                "size": 4,
                                                "number": 0,
                                                "sort": {
                                                    "empty": true,
                                                    "unsorted": true,
                                                    "sorted": false
                                                },
                                                "first": true,
                                                "numberOfElements": 2,
                                                "empty": false
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "500", description = "Lista de clientes vacia", content = @Content)
    })
    @Operation(summary = "getAllPedidosDelCocinero", description = "Obtener lista de Pedidos del cocinero")
    @GetMapping("/cocinero/pedido")
    public Page<GetPedidoEnCocinero> getAllPedidosDelCocinero(@PageableDefault(page=0, size =4)Pageable pageable, @AuthenticationPrincipal Trabajador cocinero){
        return pedidoService.getAllPedidosDelCocinero(pageable, cocinero.getId().toString());
    }



    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modificar el estado del pedido", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetPedidoEnCocinero.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "ac1b0662-8c10-19e6-818c-10d9f0ab000a",
                                                "fecha": "2023-11-27T13:56:07.595091",
                                                "estadoPedido": "CONFIRMADO"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "500", description = "Pedido no encontrado", content = @Content)
    })
    @Operation(summary = "changeEstadoPedidoCocinero", description = "Modificar el estado del pedido")
    @PutMapping("/cocinero/pedido/{id}")
    public GetPedidoEnCocinero changeEstadoPedidoCocinero(@PathVariable String id, @Valid @RequestBody EditEstadoPedidoDto editEstadoPedidoDto){
        return GetPedidoEnCocinero.of(pedidoService.changeEstadoPedidoCocinero(id, editEstadoPedidoDto));
    }

    @GetMapping("/pedido/{idPedido}")
    public GetDetallePedidoDto getDetallesDeUnPedido(@PathVariable UUID idPedido){

        return pedidoService.getPedidoDetailsDto(idPedido);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Añadir producto al carrito", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetPedidoEnCocinero.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a84001-8c1a-1778-818c-1a47b92a0011",
                                                "direccion": "c/Evangelista, 3",
                                                "telefono": "334665121",
                                                "estadoPedido": "ABIERTO",
                                                "horaLlegada": "29-11-2023 09:52",
                                                "lineasPedido": [
                                                    {
                                                        "nombreProducto": "Patatas Bravas",
                                                        "cantidadProductos": 2,
                                                        "precioUnit": 2.3,
                                                        "subtotal": 4.6
                                                    },
                                                    {
                                                        "nombreProducto": "Tarta de queso",
                                                        "cantidadProductos": 6,
                                                        "precioUnit": 4.3,
                                                        "subtotal": 25.799999999999997
                                                    },
                                                    {
                                                        "nombreProducto": "Hamburguesa Queso",
                                                        "cantidadProductos": 3,
                                                        "precioUnit": 3.55,
                                                        "subtotal": 10.649999999999999
                                                    }
                                                ],
                                                "total": 41.05
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "500", description = "Producto no encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Trabajador para asignar no encontrado", content = @Content)
    })
    @Operation(summary = "addProductoToPedidoAbierto", description = "Añadir producto al carrito")
    @PostMapping("/pedido/addProducto/{id}")
    public GetDetallePedidoDto addProductoToPedidoAbierto(@PathVariable String id, @AuthenticationPrincipal Cliente c){
        return pedidoService.getPedidoDetailsDto(pedidoService.addProductoToPedidoOpen(id, c).getId());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener el Pedido abierto (carrito)", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetPedidoEnCocinero.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a84001-8c1a-1778-818c-1a47b92a0011",
                                                "direccion": "c/Evangelista, 3",
                                                "telefono": "334665121",
                                                "estadoPedido": "ABIERTO",
                                                "horaLlegada": "29-11-2023 09:52",
                                                "lineasPedido": [
                                                    {
                                                        "nombreProducto": "Patatas Bravas",
                                                        "cantidadProductos": 2,
                                                        "precioUnit": 2.3,
                                                        "subtotal": 4.6
                                                    },
                                                    {
                                                        "nombreProducto": "Tarta de queso",
                                                        "cantidadProductos": 6,
                                                        "precioUnit": 4.3,
                                                        "subtotal": 25.799999999999997
                                                    },
                                                    {
                                                        "nombreProducto": "Hamburguesa Queso",
                                                        "cantidadProductos": 3,
                                                        "precioUnit": 3.55,
                                                        "subtotal": 10.649999999999999
                                                    }
                                                ],
                                                "total": 41.05
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "500", description = "Obtener el Pedido abierto (carrito)", content = @Content),
    })
    @Operation(summary = "getOpenPedido", description = "Añadir producto al carrito")
    @GetMapping("/pedido/carrito")
    public GetDetallePedidoDto getOpenPedido(@AuthenticationPrincipal Cliente c){
        return pedidoService.getPedidoDetailsDto(pedidoService.getOpenPedido(c).getId());
    }

}
