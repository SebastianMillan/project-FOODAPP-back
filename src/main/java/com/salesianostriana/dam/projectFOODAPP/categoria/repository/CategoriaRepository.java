package com.salesianostriana.dam.projectFOODAPP.categoria.repository;
import com.salesianostriana.dam.projectFOODAPP.categoria.dto.GetCategoriaProductsDto;
import com.salesianostriana.dam.projectFOODAPP.categoria.model.Categoria;
import com.salesianostriana.dam.projectFOODAPP.producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {


    @Query("SELECT p FROM Producto p WHERE LOWER(p.categoria.nombre) = LOWER(?1)")
    List<Producto> productosCategoriaIgnoreCase(String nombreCategoria);

    @Query("""
            SELECT COUNT(p)
            FROM Producto p
            JOIN p.categoria as cat
            WHERE cat.id = ?1
            """)
    int contarCantidadProductosDeUnaCategoria (UUID categoriaId);


    Categoria findByNombreIgnoreCase(String nombre);

    @Query("""
            SELECT c
            FROM Categoria c
            WHERE c.nombre = ?1
            """)
    Optional<Categoria> buscarCategoriaPorNombre(String nombreCategoria);


}