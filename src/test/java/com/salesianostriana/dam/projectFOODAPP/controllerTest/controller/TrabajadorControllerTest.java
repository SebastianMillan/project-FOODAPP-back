package com.salesianostriana.dam.projectFOODAPP.controllerTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import com.salesianostriana.dam.projectFOODAPP.usuario.controller.TrabajadorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT, classes =
        {SpringSecurityTestWebConfig.class})


class TrabajadorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void whenValidInput_thenReturns200() throws Exception {
        Producto producto = Producto.builder()
                .id(UUID.randomUUID())
                .nombre("Leche")
                .precio(2.0)
                .build();

        mockMvc.perform(post("/admin/add/producto")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(producto)))
                        .andExpect(status().isCreated());

    }
}