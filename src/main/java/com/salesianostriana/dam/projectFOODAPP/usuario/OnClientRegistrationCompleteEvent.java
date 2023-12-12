package com.salesianostriana.dam.projectFOODAPP.usuario;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;
@Getter
@Setter
public class OnClientRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private Usuario usuario;

    public OnClientRegistrationCompleteEvent(Usuario usuario, Locale locale, String appUrl){
        super(usuario);

        this.usuario = usuario;
        this.locale = locale;
        this.appUrl = appUrl;
    }
}
