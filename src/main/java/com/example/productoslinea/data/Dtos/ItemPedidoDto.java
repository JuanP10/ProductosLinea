package com.example.productoslinea.data.Dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemPedidoDto {
    private Long id;
    private Integer cantidad;
    private Double precioUnitario;
    private PedidoDto pedido;
    private ProductoDto producto;

}
