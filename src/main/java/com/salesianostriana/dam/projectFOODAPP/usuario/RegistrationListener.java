package com.salesianostriana.dam.projectFOODAPP.usuario;

import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnClientRegistrationCompleteEvent> {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnClientRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnClientRegistrationCompleteEvent event) {
        Usuario usuario = event.getUsuario();
        String token = UUID.randomUUID().toString();
        usuarioService.createVerificationToken(usuario, token);

        String recipientAddress = usuario.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/regitrationConfirm?token=" + token;
        String message = messages.getMessage("message.regSucc", null, event.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\r\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}