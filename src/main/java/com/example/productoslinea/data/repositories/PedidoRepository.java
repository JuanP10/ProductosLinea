package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.Cliente;
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
    List<Pedido> findByClienteAndEstado(Cliente cliente, Estado estado);

    @Query("SELECT DISTINCT p FROM Pedido p LEFT JOIN FETCH p.items WHERE p.cliente = ?1")
    List<Pedido> recuperarPedidosConArticulosPorCliente(@Param( "cliente") Long idCliente);
}
