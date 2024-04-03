package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.Save.ProductoDtoSave;
import com.example.productoslinea.data.Dtos.Send.ProductoDtoSend;
import com.example.productoslinea.data.entities.Producto;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")

public interface ProductoMapper {
    Producto productoDtoSendToProducto(ProductoDtoSave productoDtoSend);
    ProductoDtoSend productoToProductoDtoSend(Producto producto);
}
