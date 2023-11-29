package com.salesianostriana.dam.projectFOODAPP.producto.repository;

import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaProductsDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductoRepository extends JpaRepository<Producto, UUID> {

    @Query("select p from Producto p order by function('RAND') limit 1")
    Optional<Producto> getProductMonth();

    @Query("select p from Producto p order by function('RAND') limit 6")
    List<Producto> getProductNews();

    @Query("SELECT COUNT(lp) FROM LineaPedido lp WHERE lp.producto.id = ?1")
    int comprobarProductoEnLineaPedido(UUID productId);

    @Query("SELECT p FROM Producto p GROUP BY p.categoria, p.id")
    List<Producto> findAllGroupByCategoria();

    List<Producto> findByCategoriaId(UUID categoriaId);

    @Query("""
            select p
            from Producto p
            where cast(p.id as string)=?1
            """)
    Optional<Producto> encontrarProductoPorId(String id);
}