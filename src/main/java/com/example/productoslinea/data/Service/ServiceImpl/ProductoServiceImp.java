package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.ProductoDto;
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
    public List<ProductoDto> findByName(String name) {
        List <Producto> productos = productoRepository.findByNombreContainingIgnoreCase(name);
        return productos.stream().map(productoMapper::productoToProductoDto).toList();
    }

    @Override
    public List<ProductoDto> findByStock() {
        List<Producto> productos = productoRepository.findByStockGreaterThan();
        return productos.stream().map(productoMapper::productoToProductoDto).toList();
    }

    @Override
    public List<ProductoDto> findByPriceAndStock(Double precio, Integer stock) {
        List<Producto> productos = productoRepository.findByPrecioLessThanEqualAndStockLessThanEqual(precio, stock);
        return productos.stream().map(productoMapper::productoToProductoDto).toList();
    }

    @Override
    public List<ProductoDto> findAll() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(productoMapper::productoToProductoDto).toList();
    }

    @Override
    public ProductoDto findById(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Producto no encontrado con esta ID: " + id));
        return productoMapper.productoToProductoDto(producto);
    }

    @Override
    public ProductoDto guardarProducto(ProductoDto productoDto) {
       Producto producto = productoMapper.productoDtoToProducto(productoDto);
       return productoMapper.productoToProductoDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDto actualizarProducto(Long id, ProductoDto productoDto) {
        Producto producto = productoMapper.productoDtoToProducto(productoDto);
        Producto productoActualizado = productoRepository.findById(id).map(producto1 -> {
            producto1.setNombre(producto.getNombre());
            producto1.setPrecio(producto.getPrecio());
            producto1.setStock(producto.getStock());
            return productoRepository.save(producto1);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con esta ID: " + id));

        return productoMapper.productoToProductoDto(productoActualizado);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado con esta ID: " + id));
        productoRepository.deleteById(id);
    }
}
