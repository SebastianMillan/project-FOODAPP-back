package com.salesianostriana.dam.projectFOODAPP.usuario.controller;

import com.salesianostriana.dam.projectFOODAPP.usuario.dto.GetTrabajadorDto;
import com.salesianostriana.dam.projectFOODAPP.usuario.model.Trabajador;
import com.salesianostriana.dam.projectFOODAPP.usuario.service.TrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/trabajador")
@RestController
@RequiredArgsConstructor
public class TrabajadorController {

private final TrabajadorService trabajadorService;




    @GetMapping("/")
    public ResponseEntity <List<GetTrabajadorDto>> getAllTrabajadores (){
        List<Trabajador> trabajadorList =  trabajadorService.findAllTrabajadores();
        return ResponseEntity.ok(
                trabajadorList.stream()
                        .map(GetTrabajadorDto::of)
                        .toList()
        );
    }
}
