package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.ProductoDto;

import java.util.List;

public interface ProductoService {

    List<ProductoDto> findByName (String name);
    List<ProductoDto> findByStock ();
    List<ProductoDto> findByPriceAndStock (Double precio, Integer stock);

    List<ProductoDto> findAll(); //
    ProductoDto findById(Long id); //

    ProductoDto guardarProducto (ProductoDto productoDto); //
    ProductoDto actualizarProducto (Long id, ProductoDto productoDto); //

    void deleteProducto(Long id); //
}
