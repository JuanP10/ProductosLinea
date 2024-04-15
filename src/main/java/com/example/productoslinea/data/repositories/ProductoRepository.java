package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String terminoBusqueda);
    @Query("SELECT p FROM Producto p WHERE p.stock> 0")
    List<Producto> findByStockGreaterThan();
    List<Producto> findByPrecioLessThanEqualAndStockLessThanEqual(Double precioMaximo, Integer stockMaximo);
}
