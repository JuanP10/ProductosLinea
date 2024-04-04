package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Send.ProductoDtoSend;
import com.example.productoslinea.data.Mappers.ProductoMapper;
import com.example.productoslinea.data.Service.ProductoService;
import com.example.productoslinea.data.entities.Producto;
import com.example.productoslinea.data.repositories.ProductoRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImp implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImp(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }


    @Override
    public List<ProductoDtoSend> findByName(String name) {
        List <Producto> productos = productoRepository.findByNombreContainingIgnoreCase(name);
        return productos.stream().map(productoMapper::productoToProductoDtoSend).collect(Collectors.toList());
    }

    @Override
    public List<ProductoDtoSend> findByStock() {
        List<Producto> productos = productoRepository.findByStockGreaterThan();
        return productos.stream().map(productoMapper::productoToProductoDtoSend).collect(Collectors.toList());
    }

    @Override
    public List<ProductoDtoSend> findByPriceAndStock(double price, int stock) {
        List<Producto> productos = productoRepository.findByPriceLessThanEqualAndStockLessThanEqual(price, stock);
        return productos.stream().map(productoMapper::productoToProductoDtoSend).collect(Collectors.toList());
    }

    @Override
    public List<ProductoDtoSend> findAll() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(productoMapper::productoToProductoDtoSend).collect(Collectors.toList());
    }

    @Override
    public ProductoDtoSend findById(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Producto no encontrado con esta ID: " + id));
        return productoMapper.productoToProductoDtoSend(producto);
    }

    @Override
    public ProductoDtoSend guardarProducto(ProductoDtoSend productoDtoSend) {
       Producto producto = productoMapper.productoDtoSendToProducto(productoDtoSend);
       return productoMapper.productoToProductoDtoSend(productoRepository.save(producto));
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
