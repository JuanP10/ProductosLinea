package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.Enums.Estado;
import com.example.productoslinea.data.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin);
    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId AND p.estado = :estado")
    List<Pedido> findByClienteWithEstado(Long clienteId, String estado);

    // Recuperar pedidos con sus artículos usando JOIN fetch para evitar el problema N+1, para un cliente específico
    @Query("SELECT p FROM Pedido p JOIN FETCH p.items WHERE p.cliente.id = :cliente")
    List<Pedido> recuperarPedidosConArticulosPorCliente(Long cliente);
}
