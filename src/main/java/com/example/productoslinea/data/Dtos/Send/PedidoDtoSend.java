package com.example.productoslinea.data.Dtos.Send;
import com.example.productoslinea.data.Dtos.Save.ItemPedidoDtoSave;
import com.example.productoslinea.data.Dtos.Save.PagoDtoSave;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDtoSend {
    private Long id;
    @JsonFormat (pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    private String estado;
    private ClienteDtoSend cliente;
    List<ItemPedidoDtoSend> itemsPedido;
    private PagoDtoSend pago;


}
