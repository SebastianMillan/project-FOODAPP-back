package com.salesianostriana.dam.projectFOODAPP.producto.controller;

import com.salesianostriana.dam.projectFOODAPP.producto.dto.GetProductShortDto;
import com.salesianostriana.dam.projectFOODAPP.producto.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/month_product")
    public GetProductShortDto getMonthProduct(){
        return GetProductShortDto.of(productoService.getMonthProduct());
    }

    @GetMapping("/offer_product")
    public List<GetProductShortDto> getProductOnOffer(){
        return productoService.getProductsOnOffer().stream()
                .map(GetProductShortDto::of)
                .toList();
    }

    @GetMapping("/new_product")
    public List<GetProductShortDto> getProductNews(){
        return productoService.getProductNews().stream()
                .map(GetProductShortDto::of)
                .toList();
    }
}
