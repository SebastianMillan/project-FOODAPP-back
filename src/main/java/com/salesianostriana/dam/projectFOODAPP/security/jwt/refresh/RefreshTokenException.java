package com.salesianostriana.dam.projectFOODAPP.security.jwt.refresh;

import com.salesianostriana.dam.projectFOODAPP.security.errorhandling.JwtTokenException;

public class RefreshTokenException extends JwtTokenException {
    public RefreshTokenException(String msg) {
        super(msg);
    }
}
