package com.salesianostriana.dam.projectFOODAPP.pedido.controller;

import com.salesianostriana.dam.projectFOODAPP.pedido.dto.EditEstadoPedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetDetallePedidoDto;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetPedidoEnCocinero;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/pedido/")
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }


    /*
    @GetMapping("/historial/{cliente}")
    public List<GetHistorialDTO> getHistorialPedidosDeUnCliente(@AuthenticationPrincipal Cliente cliente){

        return pedidoService.getHistorialCliente(cliente.getId().toString());

    }
    */

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
    @Operation(summary = "getAllPedidosDelCocinero", description = "Modificar el estado del pedido")
    @PutMapping("/cocinero/pedido/{id}")
    public GetPedidoEnCocinero changeEstadoPedidoCocinero(@PathVariable String id, @Valid @RequestBody EditEstadoPedidoDto editEstadoPedidoDto){
        return GetPedidoEnCocinero.of(pedidoService.changeEstadoPedidoCocinero(id, editEstadoPedidoDto));
    }

    @GetMapping("/pedido/{idPedido}")
    public GetDetallePedidoDto getHistorialPedidosDeUnCliente(@Valid @PathVariable UUID idPedido){

        Pedido pedido = pedidoService.getPedidoDetails(idPedido);

        return GetDetallePedidoDto.of(pedido, )
    }

}
