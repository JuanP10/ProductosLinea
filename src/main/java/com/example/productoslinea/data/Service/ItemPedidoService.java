package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.ItemPedidoDto;

import java.util.List;

public interface ItemPedidoService {

    List<ItemPedidoDto> findAll();
    ItemPedidoDto findById(Long id);
    ItemPedidoDto save(ItemPedidoDto itemPedidoDto);

    ItemPedidoDto guardarItemPedido (Long id, ItemPedidoDto itemPedidoDto);

    List<ItemPedidoDto> findByPedidoId(Long idPedido);
    List<ItemPedidoDto> findByProductoId(Long idProducto);

    Double calcularTotalVentasPorProducto(Long idProducto);
    void delete(Long id);

}
