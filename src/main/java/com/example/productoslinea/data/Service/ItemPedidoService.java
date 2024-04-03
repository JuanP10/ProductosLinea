package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Send.ItemPedidoDtoSend;

import java.util.List;

public interface ItemPedidoService {

    List<ItemPedidoDtoSend> findAll();
    ItemPedidoDtoSend findById(Long id);
    ItemPedidoDtoSend save(ItemPedidoDtoSend itemPedidoDtoSend);

    List<ItemPedidoDtoSend> findByPedidoId(Long id);
    List<ItemPedidoDtoSend> findByProductoId(Long id);

    Double calcularTotalVentasPorProducto(Long id);
    void delete(Long id);

}
