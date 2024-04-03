package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Save.PedidoDtoSave;
import com.example.productoslinea.data.Dtos.Send.PedidoDtoSend;

import java.time.LocalDate;
import java.util.List;

public interface PedidoService {

    List<PedidoDtoSend> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin); //

    List<PedidoDtoSend> findByClienteAndEstado (Long clienteId, String estado); //

    List<PedidoDtoSend> recuperarPedidosConArticulosPorCliente (Long clienteId); //
    List<PedidoDtoSend> findAll(); //
    PedidoDtoSend findById(Long id); //
    PedidoDtoSend guardarPedido (PedidoDtoSend pedidoDtoSend); //
    void deletePedido(Long id); //

}
