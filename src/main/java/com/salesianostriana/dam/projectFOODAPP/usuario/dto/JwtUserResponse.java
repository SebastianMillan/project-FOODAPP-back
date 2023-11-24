package com.salesianostriana.dam.projectFOODAPP.usuario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.catalina.User;

import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtUserResponse extends UserResponse {

    private String token;
    private String refreshToken;

    public JwtUserResponse(UserResponse userResponse) {
        id = userResponse.getId();
        username = userResponse.getUsername();
        fullName = userResponse.getFullName();
        roles=userResponse.getRoles();
        avatar = userResponse.getAvatar();
        createdAt = userResponse.getCreatedAt();
    }

    public static JwtUserResponse of (Usuario user, String token) {
        JwtUserResponse result = new JwtUserResponse(UserResponse.fromUser(user));
        result.setToken(token);
        return result;

    }

}

