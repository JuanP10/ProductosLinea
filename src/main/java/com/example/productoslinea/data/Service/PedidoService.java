package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.PedidoDto;

import java.time.LocalDate;
import java.util.List;

public interface PedidoService {

    List<PedidoDto> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin); //

    List<PedidoDto> findByClienteAndEstado (Long clienteId, String estado); //

    List<PedidoDto> recuperarPedidosConArticulosPorCliente (Long cliente); //
    List<PedidoDto> findAll(); //
    PedidoDto findById(Long id); //
    PedidoDto guardarPedido (PedidoDto pedidoDto); //

    PedidoDto actualizarPedido (Long id, PedidoDto pedidoDto); //
    void deletePedido(Long id); //

}
