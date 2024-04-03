package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Save.PedidoDtoSave;
import com.example.productoslinea.data.Dtos.Send.PedidoDtoSend;

import java.util.List;

public interface PedidoService {

    List<PedidoDtoSend> findByFechaPedidoBetween(String fechaInicio, String fechaFin);

    List<PedidoDtoSend> findByClienteAndEstado (String cliente, String estado);
    List<PedidoDtoSend> findAll();
    PedidoDtoSend findById(Long id);
    PedidoDtoSend guardarPedido (PedidoDtoSave pedidoDtoSend);
    void deletePedido(Long id);

}
