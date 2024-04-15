package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.PagoDto;

import java.time.LocalDate;
import java.util.List;

public interface PagoService {
    List<PagoDto> findAll();
    PagoDto findById(Long id);
    PagoDto guardar (PagoDto pagoDto);

    PagoDto actualizar (Long id, PagoDto pagoDto);

    List<PagoDto> findByPedidoIdAndMetodoPago(Long pedidoId, String metodoPago);
    List<PagoDto> findByFechaPagoBetween (LocalDate fechaInicio, LocalDate fechaFin);
    void delete(Long id);

}
