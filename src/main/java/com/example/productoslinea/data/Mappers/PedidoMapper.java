package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.Save.PedidoDtoSave;
import com.example.productoslinea.data.Dtos.Send.PedidoDtoSend;
import com.example.productoslinea.data.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface PedidoMapper {
    PedidoDtoSend pedidoToPedidoDtoSend(PedidoDtoSend pedidoDtoSend);
    Pedido pedidoDtoSendToPedido(PedidoDtoSave pedido);
}
