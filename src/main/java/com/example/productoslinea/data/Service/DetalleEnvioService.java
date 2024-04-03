package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Send.DetalleEnvioDtoSend;

import java.util.List;

public interface DetalleEnvioService {
    List<DetalleEnvioDtoSend> findAll();
    DetalleEnvioDtoSend findById(Long id);

    List<DetalleEnvioDtoSend> findByPedidoId(Long pedidoId);

    List<DetalleEnvioDtoSend> findByTransportadora (String transportadora);

    List<DetalleEnvioDtoSend> findByPedidoEstado(String estado);

    DetalleEnvioDtoSend save(DetalleEnvioDtoSend detalleEnvioDtoSend);
    void delete(Long id);

}
