package com.example.productoslinea.data.Dtos.Save;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDtoSave {
    private int cantidad;
    private double precioUnitario;
}
