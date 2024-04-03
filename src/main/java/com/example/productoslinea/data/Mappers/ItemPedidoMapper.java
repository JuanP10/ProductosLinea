package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.Send.ItemPedidoDtoSend;
import com.example.productoslinea.data.entities.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedidoDtoSend itemPedidoToItemPedidoDtoSend(ItemPedido itemPedido);
    ItemPedido itemPedidoDtoSendToItemPedido(ItemPedidoDtoSend itemPedidoDtoSend);
}
