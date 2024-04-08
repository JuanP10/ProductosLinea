package com.example.productoslinea.data.Dtos.Send;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDtoSend {
    private Long id;
    private String nombre;
    private String email;
    private String direccion;
    @JsonFormat(pattern = "dd/MM/yyyy")
    List<PedidoDtoSend> pedidos;

}
