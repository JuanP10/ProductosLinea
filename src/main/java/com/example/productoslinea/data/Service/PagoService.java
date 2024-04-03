package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Send.PagoDtoSend;

import java.time.LocalDate;
import java.util.List;

public interface PagoService {
    List<PagoDtoSend> findAll();
    PagoDtoSend findById(Long id);
    PagoDtoSend save(PagoDtoSend pagoDtoSend);

    List<PagoDtoSend> findByPedidoIdAndMetodoPago(Long pedidoId, String metodoPago);
    List<PagoDtoSend> findByFechaPagoBetween (LocalDate fechaInicio, LocalDate fechaFin);
    void delete(Long id);

}
