package com.example.productoslinea.data.Dtos.Save;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDtoSave {
    private String nombre;
    private String email;
    private String direccion;
}
