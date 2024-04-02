package com.example.productoslinea.data.Dtos.Send;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDtoSend {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    @JsonIgnore
    private List<ItemPedidoDtoSend> itemPedidos;
}
