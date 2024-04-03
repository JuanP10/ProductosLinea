package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.Send.DetalleEnvioDtoSend;
import com.example.productoslinea.data.entities.DetalleEnvio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalleEnvioMapper {
    DetalleEnvioDtoSend detalleEnvioToDetalleEnvioDtoSend (DetalleEnvio detalleEnvio);
    DetalleEnvio detalleEnvioDtoSendtoDetallEnvio(DetalleEnvioDtoSend detalleEnvioDtoSend);

}
