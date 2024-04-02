package com.example.productoslinea.data.entities;

import com.example.productoslinea.data.entities.Enums.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Estado estado;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPedido;

    @ManyToOne @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany (mappedBy = "pedido")
    private List<ItemPedido> items;

    @OneToOne @JoinColumn(name = "id_pago")
    private Pago pago;

    @OneToOne @JoinColumn(name = "id_envio")
    private DetalleEnvio envio;

}
