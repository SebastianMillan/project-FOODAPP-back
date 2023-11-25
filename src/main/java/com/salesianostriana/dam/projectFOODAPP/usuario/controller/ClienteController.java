package com.salesianostriana.dam.projectFOODAPP.usuario.controller;
import com.salesianostriana.dam.projectFOODAPP.pedido.dto.GetHistorialDTO;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.pedido.service.PedidoService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    private final PedidoService pedidoService;

    @GetMapping("/cliente/")
    public List<Cliente> getAllClientes(){

        return clienteService.getAllClientes();
    }

    @GetMapping("/historial/{id}")
    public List<GetHistorialDTO> getHistorialPedidosDeUnCliente (@PathVariable String id){

        List<Pedido> pedidos = clienteService.buscarPedidosByClienteId(id);

        List<GetHistorialDTO> pedidosClienteDTO = new ArrayList<>();
        for(Pedido pedido: pedidos){
            pedidosClienteDTO.add(GetHistorialDTO.of(pedido,
                    pedidoService.calcularImporteTotal(pedido)));
        }

        return pedidosClienteDTO;
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
    public Page<GetDtoCliente> getAllClientsByAdmin(@PageableDefault(page = 0, size = 4) Pageable pageable){
        return clienteService.getAllDtoCliente(pageable);
    }


}
