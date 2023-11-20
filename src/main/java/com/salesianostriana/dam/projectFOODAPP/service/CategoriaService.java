package com.salesianostriana.dam.projectFOODAPP.service;

import com.salesianostriana.dam.projectFOODAPP.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
}
