package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    @Query("SELECT ip FROM ItemPedido ip WHERE ip.pedido.id = :pedidoId")
    List<ItemPedido> findByPedidoId(Long pedidoId);

    @Query("SELECT ip FROM ItemPedido ip WHERE ip.producto.id = :productoId")
    List<ItemPedido> findByProductoId(Long productoId);


    // Calcular la suma del total de ventas para un producto
    @Query("SELECT SUM(ip.cantidad * ip.precioUnitario) FROM ItemPedido ip WHERE ip.producto.id =: productoId")
    Double calcularTotalVentasPorProducto(Long productoId);

}
