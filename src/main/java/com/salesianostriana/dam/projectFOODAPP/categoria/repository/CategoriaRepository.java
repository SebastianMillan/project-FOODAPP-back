package com.salesianostriana.dam.projectFOODAPP.categoria.repository;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {


    @Query("SELECT p FROM Producto p WHERE p.categoria.nombre = ?1")
    List<Producto> productosCategoria(String nombreCategoria);

    @Query("""
            SELECT c
            FROM Categoria c
            WHERE c.id = ?1
            """)
    Categoria buscarCategoriaPorId (UUID categoriaId);


    @Query("""
            SELECT COUNT(p)
            FROM Producto p
            JOIN p.categoria as cat
            WHERE cat.id = ?1
            """)
    int contarCantidadProductosDeUnaCategoria (UUID categoriaId);

}