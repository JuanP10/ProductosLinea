package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    List<ItemPedido> findByPedidoId(Long pedidoId);

    List<ItemPedido> findByProductoId(Long productoId);


    // Calcular la suma del total de ventas para un producto
    @Query("SELECT SUM(ip.cantidad * ip.precioUnitario) FROM ItemPedido ip WHERE ip.producto.id = ?1")
    Double calcularTotalVentasPorProducto(Long productoId);

}
