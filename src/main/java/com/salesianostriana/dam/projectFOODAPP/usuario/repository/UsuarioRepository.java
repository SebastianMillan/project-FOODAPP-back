package com.salesianostriana.dam.projectFOODAPP.usuario.repository;

import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetUserDtoDetail;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    boolean existsByUsernameIgnoreCase(String username);

    Optional<Usuario> findFirstByUsername(String username);

    @Query("""
            Select new com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetUserDtoDetail(
            u.nombre, u.username, u.edad )from Usuario u
            """)
    Page<GetUserDtoDetail> allUsuarios(Pageable page);
}