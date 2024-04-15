package com.example.productoslinea.data.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private Long id;
    private String nombre;
    private String email;
    private String direccion;
}
