package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.Enums.MetodoPago;
import com.example.productoslinea.data.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByFechaPagoBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<Pago> findByPedidoIdAndMetodoPago(Long pedidoId, MetodoPago metodoPago);
}
