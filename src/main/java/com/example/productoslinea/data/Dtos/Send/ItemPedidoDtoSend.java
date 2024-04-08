package com.example.productoslinea.data.Dtos.Send;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemPedidoDtoSend {
    private Long id;
    private Integer cantidad;
    private Double precioUnitario;
    private PedidoDtoSend pedido;
    private ProductoDtoSend producto;

}
