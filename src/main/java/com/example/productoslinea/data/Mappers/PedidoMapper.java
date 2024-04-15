package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.PedidoDto;
import com.example.productoslinea.data.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface PedidoMapper {
    PedidoDto pedidoToPedidoDto(Pedido pedido);
    Pedido pedidoDtoToPedido(PedidoDto pedidoDto);
}
