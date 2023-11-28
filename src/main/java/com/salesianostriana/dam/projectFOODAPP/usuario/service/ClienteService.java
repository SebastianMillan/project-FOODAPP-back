package com.salesianostriana.dam.projectFOODAPP.usuario.service;
import com.salesianostriana.dam.projectFOODAPP.pedido.model.Pedido;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.EditLoggedUserDto;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetDtoCliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.ClienteNotFoundException;
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

    public List<Cliente> getAll () {

        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId (String idCliente){

        return clienteRepository.buscarClientePorIdString(idCliente)
                .orElseThrow(() -> new ClienteNotFoundException(idCliente));
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

    public Page<GetDtoCliente> getAllDtoCliente(Pageable pageable){
        Page<GetDtoCliente> result= clienteRepository.getAllDtoCliente(pageable);
        if(result.isEmpty()){
            throw new EmptyClienteListException();
        }
        return result;
    }

    public Cliente editLoggedUser(EditLoggedUserDto edicion, Cliente c){
        Cliente editado = Cliente.builder()
                .id(c.getId())
                .nombre(edicion.nombre())
                .email(edicion.email())
                .telefono(edicion.telefono())
                .avatar(edicion.avatar())
                .direccion(edicion.direccion())
                .codPostal(edicion.codPostal())
                .poblacion(edicion.poblacion())
                .username(c.getUsername())
                .password(c.getPassword())
                .roles(c.getRoles())
                .puntos(c.getPuntos())
                .pin(c.getPin())
                .build();
        return clienteRepository.save(editado);
    }
}
