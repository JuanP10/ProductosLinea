package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.DetalleEnvioDto;

import java.util.List;

public interface DetalleEnvioService {
    List<DetalleEnvioDto> findAll();
    DetalleEnvioDto findById(Long id);

    List<DetalleEnvioDto> findByPedidoId(Long pedidoId);

    List<DetalleEnvioDto> findByTransportadora (String transportadora);

    List<DetalleEnvioDto> findByPedidoEstado(String estado);

    DetalleEnvioDto save(DetalleEnvioDto detalleEnvioDto);

    DetalleEnvioDto actualizarUpdate (Long id, DetalleEnvioDto detalleEnvioDto);
    void delete(Long id);

}
