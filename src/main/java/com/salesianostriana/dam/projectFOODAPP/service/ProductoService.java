package com.salesianostriana.dam.projectFOODAPP.service;

import com.salesianostriana.dam.projectFOODAPP.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
}
