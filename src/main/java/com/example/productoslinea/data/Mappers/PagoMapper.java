package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.Send.PagoDtoSend;
import com.example.productoslinea.data.entities.Pago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagoMapper {
    PagoDtoSend pagoToPagoDtoSend(Pago pago);
    Pago pagoDtoSendToPago(PagoDtoSend pagoDtoSend);
}
