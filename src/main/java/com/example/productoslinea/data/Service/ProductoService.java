package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Send.ProductoDtoSend;
import com.example.productoslinea.data.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<ProductoDtoSend> findByName (String name);
    List<ProductoDtoSend> findByStock ();
    List<ProductoDtoSend> findByPriceAndStock (double price, int stock);

    List<Producto> findAll();
    Producto guardarProducto(Producto producto);
    Producto findById(Long id);

    void deleteProducto(Long id);
}
