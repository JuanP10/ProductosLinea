package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.DetalleEnvio;
import com.example.productoslinea.data.entities.Enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetalleEnvioRepository extends JpaRepository<DetalleEnvio, Long> {
    List<DetalleEnvio> findByPedidoId(Long pedidoId);
    List<DetalleEnvio> findByTransportadora (String transportadora);
    List<DetalleEnvio> findByPedidoEstado(Estado estado);


}
