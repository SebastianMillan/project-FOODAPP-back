package com.salesianostriana.dam.projectFOODAPP.security.jwt.refresh;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.lang.ref.Reference;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.refresh.duration}")
    private int duratinoInMinutes;

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    @Transactional
    public int deleteByUser(Usuario user){
        return refreshTokenRepository.deleteByUser(user);
    }

    public RefreshToken createRefreshToken(Usuario user){
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(user);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(Instant.now().plusSeconds(duratinoInMinutes * 60));

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verify(RefreshToken refreshToken){
        if(refreshToken.getExpiryDate().compareTo(Instant.now())<0) {
            refreshTokenRepository.delete(refreshToken);
            throw new RefreshTokenException("Su cuenta ha expirado" + refreshToken.getToken() + "Por favor, vuelva a loguearse");
        }
        return refreshToken;
    }
}
