package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.ItemPedidoDto;
import com.example.productoslinea.data.Mappers.ItemPedidoMapper;
import com.example.productoslinea.data.Service.ItemPedidoService;
import com.example.productoslinea.data.entities.ItemPedido;
import com.example.productoslinea.data.repositories.ItemPedidoRepository;
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
    public List<ItemPedidoDto> findAll() {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findAll();
        return itemPedidos.stream().map(itemPedidoMapper::itemPedidoToItemPedidoDto).toList();
    }

    @Override
    public ItemPedidoDto findById(Long id) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("ItemPedido no encontrado con el ID: "+id));
        return itemPedidoMapper.itemPedidoToItemPedidoDto(itemPedido);
    }

    @Override
    public ItemPedidoDto save(ItemPedidoDto itemPedidoDto) {
        ItemPedido itemPedido = itemPedidoMapper.itemPedidoDtoToItemPedido(itemPedidoDto);
        return itemPedidoMapper.itemPedidoToItemPedidoDto(itemPedidoRepository.save(itemPedido));
    }

    @Override
    public ItemPedidoDto guardarItemPedido(Long id, ItemPedidoDto itemPedidoDto) {
        ItemPedido itemPedido = itemPedidoMapper.itemPedidoDtoToItemPedido(itemPedidoDto);
        ItemPedido itemPedidoGuardado = itemPedidoRepository.findById(id).map(itemPedidoEncontrado -> {
            itemPedidoEncontrado.setCantidad(itemPedido.getCantidad());
            itemPedidoEncontrado.setProducto(itemPedido.getProducto());
            itemPedidoEncontrado.setPedido(itemPedido.getPedido());
            return itemPedidoRepository.save(itemPedidoEncontrado);
        }).orElseThrow(() -> new RuntimeException("ItemPedido no encontrado con el ID: "+id));

        return itemPedidoMapper.itemPedidoToItemPedidoDto(itemPedidoGuardado);
    }

    @Override
    public List<ItemPedidoDto> findByPedidoId(Long idPedido) {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findByPedidoId(idPedido);
        return itemPedidos.stream().map(itemPedidoMapper::itemPedidoToItemPedidoDto).toList();
    }

    @Override
    public List<ItemPedidoDto> findByProductoId(Long idProducto) {
        List<ItemPedido> itemPedidos = itemPedidoRepository.findByProductoId(idProducto);
        return itemPedidos.stream().map(itemPedidoMapper::itemPedidoToItemPedidoDto).toList();
    }

    @Override
    public Double calcularTotalVentasPorProducto(Long idProducto) {
        return itemPedidoRepository.calcularTotalVentasPorProducto(idProducto);
    }

    @Override
    public void delete(Long id) {
        itemPedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("ItemPedido no encontrado con el ID: "+id));
        itemPedidoRepository.deleteById(id);
    }
}
