package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Send.ProductoDtoSend;

import java.util.List;

public interface ProductoService {

    List<ProductoDtoSend> findByName (String name);
    List<ProductoDtoSend> findByStock ();
    List<ProductoDtoSend> findByPriceAndStock (double price, int stock);

    List<ProductoDtoSend> findAll(); //
    ProductoDtoSend findById(Long id); //

    ProductoDtoSend guardarProducto (ProductoDtoSend productoDtoSend); //

    void deleteProducto(Long id); //
}
