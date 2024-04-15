package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.PagoDto;
import com.example.productoslinea.data.entities.Pago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagoMapper {
    PagoDto pagoToPagoDto (Pago pago);
    Pago pagoDtoToPago (PagoDto pagoDto);
}
