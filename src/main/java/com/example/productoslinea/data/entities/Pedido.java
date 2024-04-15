package com.example.productoslinea.data.entities;

import com.example.productoslinea.data.entities.Enums.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "fecha_pedido", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaPedido;

    @ManyToOne @JoinColumn(name = "cliente")
    private Cliente cliente;

    @OneToMany (mappedBy = "pedido")
    private List<ItemPedido> items;

    @OneToOne (mappedBy = "pedido")
    private Pago pago;

    @OneToOne (mappedBy = "pedido")
    private DetalleEnvio envio;

}
