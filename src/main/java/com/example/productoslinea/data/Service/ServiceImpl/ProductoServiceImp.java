package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Save.ProductoDtoSave;
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
        return this.findByName(name);
    }

    @Override
    public Producto findById(Long id) {
        return this.findById(id);
    }

    @Override
    public List<ProductoDtoSend> findAll() {
        return productoRepository.findAll().stream()
                .map(productoMapper::productoToProductoDtoSend)
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductoDtoSend> findByStock() {
        List<Producto> productsStock = productoRepository.findByStockGreaterThan();
        return productsStock.stream()
                .map(productoMapper::productoToProductoDtoSend)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDtoSend> findByPriceAndStock (double price, int stock) {
        List<Producto> productsCheck = productoRepository.findByPriceLessThanEqualAndStockLessThanEqual(price, stock);
        return productsCheck.stream()
                .map(productoMapper::productoToProductoDtoSend)
                .collect(Collectors.toList());
    }



    @Override
    public ProductoDtoSend guardarProducto(ProductoDtoSave productoDtoSave) {
        Producto producto = productoMapper.productoDtoSendToProducto(productoDtoSave);
        Producto producto1 = productoRepository.save(producto);
        return productoMapper.productoToProductoDtoSend(producto1);
    }



    @Override
    public void deleteProducto(Long id) {
        this.deleteProducto(id);
    }


}
