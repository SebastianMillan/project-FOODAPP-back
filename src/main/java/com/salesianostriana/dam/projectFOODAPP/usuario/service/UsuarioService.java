package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.dto.CreateClientDto;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.CreateUserRequest;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetUserDtoDetail;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.PasswordNotValidException;
import com.salesianostriana.dam.projectFOODAPP.usuario.exception.TrabajadoresListEmptyException;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.RolUsuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.ClienteRepository;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository userRepository;
    private final ClienteRepository clienteRepository;

    public Cliente createUser(CreateClientDto created, EnumSet<RolUsuario> roles) {

        if (userRepository.existsByUsernameIgnoreCase(created.username()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");

        if(!created.password().equalsIgnoreCase(created.verifyPassword())){
            throw new PasswordNotValidException();
        }

        Cliente c = Cliente.builder()
                .username(created.username())
                .password(passwordEncoder.encode(created.password()))
                .avatar(created.avatar())
                .nombre(created.nombre())
                .email(created.email())
                .roles(Set.of(RolUsuario.CLIENTE))
                .build();

        return clienteRepository.save(c);
    }

    public Cliente createUserWithUserRole(CreateClientDto created) {
        return createUser(created, EnumSet.of(RolUsuario.CLIENTE));
    }

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Optional<Usuario> findById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<Usuario> findByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public Optional<Usuario> edit(Usuario user) {

        // El username no se puede editar
        // La contraseña se edita en otro método

        return userRepository.findById(user.getId())
                .map(u -> {
                    u.setAvatar(user.getAvatar());
                    u.setNombre(user.getNombre());
                    return userRepository.save(u);
                }).or(() -> Optional.empty());

    }

    public Optional<Usuario> editPassword(UUID userId, String newPassword) {

        // Aquí no se realizan comprobaciones de seguridad. Tan solo se modifica

        return userRepository.findById(userId)
                .map(u -> {
                    u.setPassword(passwordEncoder.encode(newPassword));
                    return userRepository.save(u);
                });

    }

    public void delete(Usuario user) {
        deleteById(user.getId());
    }

    public void deleteById(UUID id) {
        // Prevenimos errores al intentar borrar algo que no existe
        if (userRepository.existsById(id))
            userRepository.deleteById(id);
    }

    public boolean passwordMatch(Usuario user, String clearPassword) {
        return passwordEncoder.matches(clearPassword, user.getPassword());
    }

    public Page<GetUserDtoDetail> listadoUsiariosDtoExmanen(Pageable pageable){
        Page<GetUserDtoDetail> user = userRepository.allUsuarios(pageable);
        if(user.isEmpty()){
            throw new TrabajadoresListEmptyException();
        }
        return user;
    }


    //Cambiar La contraseña
    public void changePassword(Usuario user, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        user.setPasswordChangedTime(new Date());

        userRepository.save(user);
    }



}
