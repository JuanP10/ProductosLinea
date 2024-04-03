package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.Send.PedidoDtoSend;
import com.example.productoslinea.data.Service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDtoSend>> findAll() {
        List<PedidoDtoSend> pedidos = pedidoService.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDtoSend> findById(Long id) {
        PedidoDtoSend pedido = pedidoService.findById(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}/estado/{estado}")
    public ResponseEntity<List<PedidoDtoSend>> findByClienteAndEstado(Long clienteId, String estado) {
        List<PedidoDtoSend> pedidos = pedidoService.findByClienteAndEstado(clienteId, estado);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);

    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PedidoDtoSend>> recuperarPedidosConArticulosPorCliente(Long clienteId) {
        List<PedidoDtoSend> pedidos = pedidoService.recuperarPedidosConArticulosPorCliente(clienteId);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);

    }

    @GetMapping("/fecha/{fechaInicio}/{fechaFin}")
    public ResponseEntity<List<PedidoDtoSend>> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        List<PedidoDtoSend> pedidos = pedidoService.findByFechaPedidoBetween(fechaInicio, fechaFin);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<PedidoDtoSend> guardarPedido(PedidoDtoSend pedido) {
        PedidoDtoSend pedidoGuardado = pedidoService.guardarPedido(pedido);
        return new ResponseEntity<>(pedidoGuardado, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePedido(Long id) {
        pedidoService.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
