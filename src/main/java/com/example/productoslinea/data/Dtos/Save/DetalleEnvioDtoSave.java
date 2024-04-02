package com.example.productoslinea.data.Dtos.Save;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleEnvioDtoSave {
    private String direccion;
    private String transportadora;
    private int numeroGuia;
}
