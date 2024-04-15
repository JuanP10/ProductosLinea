package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.ProductoDto;
import com.example.productoslinea.data.entities.Producto;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")

public interface ProductoMapper {
    Producto productoDtoToProducto (ProductoDto productoDto);
    ProductoDto productoToProductoDto (Producto producto);
}
