package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.ItemPedidoDto;
import com.example.productoslinea.data.entities.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedido itemPedidoDtoToItemPedido(ItemPedidoDto itemPedidoDto);
    ItemPedidoDto itemPedidoToItemPedidoDto (ItemPedido itemPedido);
}
