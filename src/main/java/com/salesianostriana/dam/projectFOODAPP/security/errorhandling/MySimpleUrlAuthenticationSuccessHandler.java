package com.salesianostriana.dam.projectFOODAPP.security.errorhandling;

import com.salesianostriana.dam.projectFOODAPP.security.DeviceService;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@NoArgsConstructor
@Component()
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private DeviceService deviceService;

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication)
            throws IOException, ServletException {
        handle(request, response, authentication);
        loginNotification(authentication, request);

    }
    protected void handle(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
        final String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    protected String determineTargetUrl(final Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("READ_PRIVILEGE")) {
                isUser = true;
            } else if (grantedAuthority.getAuthority().equals("WRITE_PRIVILEGE")) {
                isAdmin = true;
                isUser = false;
                break;
            }
        }
        if (isUser) {
            String username;
            if (authentication.getPrincipal() instanceof Usuario) {
                username = ((Usuario)authentication.getPrincipal()).getEmail();
            }
            else {
                username = authentication.getName();
            }

            return "/homepage.html?user="+username;
        } else if (isAdmin) {
            return "/console";
        } else {
            throw new IllegalStateException();
        }
    }

    private void loginNotification(Authentication authentication,
                                   HttpServletRequest request) {
        try {
            if (authentication.getPrincipal() instanceof Usuario) {
                deviceService.verifyDevice(((Usuario)authentication.getPrincipal()), request);
            }
        } catch(Exception e) {
            logger.error("An error occurred verifying device or location");
            throw new RuntimeException(e);
        }
    }
}
