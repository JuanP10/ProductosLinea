package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Send.ItemPedidoDtoSend;
import com.example.productoslinea.data.Mappers.ItemPedidoMapper;
import com.example.productoslinea.data.Service.ItemPedidoService;
import com.example.productoslinea.data.entities.ItemPedido;
import com.example.productoslinea.data.repositories.ItemPedidoRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ItemPedidoServiceImp implements ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;
    private final ItemPedidoMapper itemPedidoMapper;

    public ItemPedidoServiceImp(ItemPedidoRepository itemPedidoRepository, ItemPedidoMapper itemPedidoMapper) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.itemPedidoMapper = itemPedidoMapper;
    }

    @Override
    public List<ItemPedidoDtoSend> findAll() {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findAll();
        return itemPedidos.stream().map(itemPedidoMapper::itemPedidoToItemPedidoDtoSend).toList();
    }

    @Override
    public ItemPedidoDtoSend findById(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("ItemPedido not found con el ID: "+id));
        return itemPedidoMapper.itemPedidoToItemPedidoDtoSend(itemPedido);
    }

    @Override
    public ItemPedidoDtoSend save(ItemPedidoDtoSend itemPedidoDtoSend) {
        ItemPedido itemPedido = itemPedidoMapper.itemPedidoDtoSendToItemPedido(itemPedidoDtoSend);
        return itemPedidoMapper.itemPedidoToItemPedidoDtoSend(itemPedidoRepository.save(itemPedido));
    }

    @Override
    public List<ItemPedidoDtoSend> findByPedidoId(Long id) {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findByPedidoId(id);
        return itemPedidos.stream().map(itemPedidoMapper::itemPedidoToItemPedidoDtoSend).toList();
    }

    @Override
    public List<ItemPedidoDtoSend> findByProductoId(Long id) {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findByProductoId(id);
        return itemPedidos.stream().map(itemPedidoMapper::itemPedidoToItemPedidoDtoSend).toList();
    }

    @Override
    public Double calcularTotalVentasPorProducto(Long id) {
        return itemPedidoRepository.calcularTotalVentasPorProducto(id);
    }

    @Override
    public void delete(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
