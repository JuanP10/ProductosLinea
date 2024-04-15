package com.example.productoslinea.data.Dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
}
