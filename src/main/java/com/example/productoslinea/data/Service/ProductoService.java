package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Save.ProductoDtoSave;
import com.example.productoslinea.data.Dtos.Send.ProductoDtoSend;
import com.example.productoslinea.data.entities.Producto;

import java.util.List;

public interface ProductoService {

    List<ProductoDtoSend> findByName (String name);
    List<ProductoDtoSend> findByStock ();
    List<ProductoDtoSend> findByPriceAndStock (double price, int stock);

    List<ProductoDtoSend> findAll();
    Producto findById(Long id);

    ProductoDtoSend guardarProducto (ProductoDtoSave productoDtoSave);

    void deleteProducto(Long id);
}
