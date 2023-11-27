package com.salesianostriana.dam.projectFOODAPP.usuario.controller;

import com.salesianostriana.dam.projectFOODAPP.security.jwt.access.JwtProvider;
import com.salesianostriana.dam.projectFOODAPP.usuario.dto.*;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Cliente;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Usuario;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.ClienteService;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService userService;
    private final ClienteService clienteService;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse> createUserWithUserRole(@RequestBody CreateUserRequest createUserRequest) {
        Usuario user = userService.createUserWithUserRole(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.fromUser(user));
    }

    // Más adelante podemos manejar la seguridad de acceso a esta petición

    @PostMapping("/auth/register/admin")
    public ResponseEntity<UserResponse> createUserWithAdminRole(@RequestBody CreateUserRequest createUserRequest) {
        Usuario user = userService.createUserWithAdminRole(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.fromUser(user));
    }


    @PostMapping("/auth/login")
    public ResponseEntity<JwtUserResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        Usuario user = (Usuario) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(JwtUserResponse.of(user, token));
    }

    @PutMapping("/user/changePassword")
    public ResponseEntity<UserResponse> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest,
                                                       @AuthenticationPrincipal Usuario loggedUser) {
        // Este código es mejorable.
        // La validación de la contraseña nueva se puede hacer con un validador.
        // La gestión de errores se puede hacer con excepciones propias
        try {
            if (userService.passwordMatch(loggedUser, changePasswordRequest.getOldPassword())) {
                Optional<Usuario> modified = userService.editPassword(loggedUser.getId(), changePasswordRequest.getNewPassword());
                if (modified.isPresent())
                    return ResponseEntity.ok(UserResponse.fromUser(modified.get()));
            } else {
                // Lo ideal es que esto se gestionara de forma centralizada
                // Se puede ver cómo hacerlo en la formación sobre Validación con Spring Boot
                // y la formación sobre Gestión de Errores con Spring Boot
                throw new RuntimeException();
            }
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password Data Error");
        }

        return null;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener Usuario Logeado", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetUserDetailDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a801b2-8c0d-1503-818c-0d250f870003",
                                                "nombre": "Francisco Claro",
                                                "email": "fran@gmail.com",
                                                "avatar": null,
                                                "direccion": "c/Evangelista, 3",
                                                "codPostal": "41011",
                                                "poblacion": "Sevilla",
                                                "puntos": 100,
                                                "pedidos": [
                                                    {
                                                        "id": "c0a801b2-8c0d-1503-818c-0d25106b000c",
                                                        "fecha": "2023-11-26T20:39:42.053019",
                                                        "estadoPedido": "CONFIRMADO",
                                                        "importeTotal": 6.3
                                                    }
                                                ]
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "401", description = "No se encuentra Usuario loggeado", content = @Content)
    })
    @Operation(summary = "getLoggedUser", description = "Obtener el Usuario loggeado")
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public ResponseEntity<GetClienteDtoDetail> getLoggedUser(@AuthenticationPrincipal Cliente user) {
            return ResponseEntity.ok(GetClienteDtoDetail.of(user, clienteService.buscarPedidosByClienteId(user.getId().toString())));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Obtener Cliente con sus pedidos", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetClienteDtoDetail.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a84001-8c00-1e9f-818c-006ea8f60003",
                                                "nombre": "Francisco Claro",
                                                "email": "fran@gmail.com",
                                                "avatar": null,
                                                "direccion": "c/Evangelista, 3",
                                                "codPostal": "41011",
                                                "poblacion": "Sevilla",
                                                "puntos": 100,
                                                "pedidos": [
                                                    {
                                                        "id": "c0a84001-8c00-1e9f-818c-006ea9df000c",
                                                        "fecha": "2023-11-24T09:25:01.658822",
                                                        "estadoPedido": "CONFIRMADO",
                                                        "importeTotal": 6.3
                                                    }
                                                ]
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
    })
    @Operation(summary = "getClientDetailsWithOrders", description = "Obtener Cliente por su Id con sus pedidos asociados")
    @GetMapping("/admin/client/{id}")
    public GetClienteDtoDetail getClientDetailsWithOrders(@PathVariable String id){
        return GetClienteDtoDetail.of(clienteService.buscarClienteDetail(id), clienteService.buscarPedidosByClienteId(id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Editar datos del Cliente loggeado", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetClienteDtoDetail.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                "id": "c0a801b2-8c0d-1417-818c-0d4421110003",
                                                "nombre": "pepe",
                                                "email": "pepe@gmail.com",
                                                "avatar": "https://noticiasdelaciencia.com/upload/images/12_2021/6754_ciencia-en-imagenes-este-murcielago-da-la-cara.jpg",
                                                "direccion": "C/Montaña nº3",
                                                "codPostal": "33133",
                                                "poblacion": "Valencia",
                                                "puntos": 100,
                                                "pedidos": [
                                                    {
                                                        "id": "c0a801b2-8c0d-1417-818c-0d4421e0000c",
                                                        "fecha": "2023-11-26T21:13:38.144181",
                                                        "estadoPedido": "CONFIRMADO",
                                                        "importeTotal": 6.3
                                                    }
                                                ]
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "400", description = "Dato introducido inválido", content = @Content)
    })
    @Operation(summary = "editLoggedUser", description = "Editar datos del Cliente loggeado")
    @PutMapping("/profile/edit")
    public GetClienteDtoDetail editLoggedUser(@Valid @RequestBody EditLoggedUserDto editado, @AuthenticationPrincipal Cliente c){
        return GetClienteDtoDetail.of(clienteService.editLoggedUser(editado,c), clienteService.buscarPedidosByClienteId(c.getId().toString()));
    }


}
