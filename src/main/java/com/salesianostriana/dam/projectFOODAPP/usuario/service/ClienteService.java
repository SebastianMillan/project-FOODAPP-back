package com.salesianostriana.dam.projectFOODAPP.usuario.service;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetDtoCliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.EmptyClientOrdersException;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.EmptyClientsException;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.EmptyClienteListException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes () {

        List<Cliente> clientes = clienteRepository.findAll();

        if (clientes.isEmpty())
            throw new EmptyClientsException();

        return clientes;
    }

    public Cliente buscarClienteDetail(String id){
        Optional<Cliente> result = clienteRepository.buscarClienteDetail(UUID.fromString(id));
        if(result.isEmpty()){
            throw new ClienteNotFoundException(id);
        }
        return result.get();
    }

    public List<Pedido> buscarPedidosByClienteId(String id){
        List<Pedido> pedidos = clienteRepository.buscarPedidosByClienteId(id);

        if(pedidos.isEmpty())
            throw new EmptyClientOrdersException();

        return pedidos;
    }

    public Page<GetDtoCliente> getAllDtoCliente(Pageable pageable){
        Page<GetDtoCliente> result= clienteRepository.getAllDtoCliente(pageable);
        if(result.isEmpty()){
            throw new EmptyClienteListException();
        }
        return result;
    }
}
