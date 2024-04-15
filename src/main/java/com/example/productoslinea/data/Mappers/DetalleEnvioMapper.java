package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.DetalleEnvioDto;
import com.example.productoslinea.data.entities.DetalleEnvio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalleEnvioMapper {
    DetalleEnvioDto detalleEnvioToDetalleEnvioDto (DetalleEnvio detalleEnvio);
    DetalleEnvio detalleEnvioDtotoDetalleEnvio(DetalleEnvioDto detalleEnvioDto);

}
