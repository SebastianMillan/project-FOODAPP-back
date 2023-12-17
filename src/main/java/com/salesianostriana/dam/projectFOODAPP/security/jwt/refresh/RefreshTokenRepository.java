package com.salesianostriana.dam.projectFOODAPP.security.jwt.refresh;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, User> {
    Optional<RefreshToken>findByToken (String token);

    @Modifying
    int deleteByUser(Usuario user);
}
