package com.example.productoslinea.data.Dtos.Save;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDtoSave {
    private String nombre;
    private double precio;
    private int stock;
}
