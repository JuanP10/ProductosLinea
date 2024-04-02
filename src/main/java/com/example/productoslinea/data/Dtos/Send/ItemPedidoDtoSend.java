package com.example.productoslinea.data.Dtos.Send;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDtoSend {
    private Long id;
    private int cantidad;
    private double precioUnitario;
    private ProductoDtoSend producto;

}
