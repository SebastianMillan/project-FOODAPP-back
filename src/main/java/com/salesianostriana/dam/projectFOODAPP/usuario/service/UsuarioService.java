package com.salesianostriana.dam.projectFOODAPP.usuario.service;

import com.salesianostriana.dam.projectFOODAPP.usuario.dto.CreateUserRequest;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.RolUsuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository userRepository;

    public Usuario createUser(CreateUserRequest createUserRequest, EnumSet<RolUsuario> roles) {

        if (userRepository.existsByUsernameIgnoreCase(createUserRequest.getUsername()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");

        Usuario user =  Usuario.builder()
                .username(createUserRequest.getUsername())
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .nombre((createUserRequest.getFullName()))
                .roles(roles)
                .build();

        return userRepository.save(user);
    }

    public Usuario createUserWithUserRole(CreateUserRequest createUserRequest) {
        return createUser(createUserRequest, EnumSet.of(RolUsuario.CLIENTE));
    }

    public Usuario createUserWithAdminRole(CreateUserRequest createUserRequest) {
        return createUser(createUserRequest, EnumSet.of(RolUsuario.ADMIN));
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

}
