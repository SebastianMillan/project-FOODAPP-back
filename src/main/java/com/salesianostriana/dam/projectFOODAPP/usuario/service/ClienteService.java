package com.salesianostriana.dam.projectFOODAPP.usuario.service;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetDtoCliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.EmptyClienteListException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> getAll () {

        return clienteRepository.findAll();
    }

    public Cliente buscarClienteDetail(String id){
        Optional<Cliente> result = clienteRepository.buscarClienteDetail(UUID.fromString(id));
        if(result.isEmpty()){
            throw new ClienteNotFoundException(id);
        }
        return result.get();
    }

    public List<Pedido> buscarPedidosByClienteId(String id){
        return clienteRepository.buscarPedidosByClienteId(id);

    }

    public List<GetDtoCliente> getAllDtoCliente(){
        List<GetDtoCliente> result= clienteRepository.getAllDtoCliente();
        if(result.isEmpty()){
            throw new EmptyClienteListException();
        }
        return result;
    }
}
