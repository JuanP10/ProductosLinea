package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String terminoBusqueda);

    List<Producto> findByStockGreaterThan(int cantidad);
    List<Producto> findByPriceLessThanEqualAndStockLessThanEqual(double precioMaximo, int stockMaximo);
}
