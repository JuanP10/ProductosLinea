package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.PedidoDto;
import com.example.productoslinea.data.Service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> findAll() {
        List<PedidoDto> pedidos = pedidoService.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
        PedidoDto pedido = pedidoService.findById(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @GetMapping("/clientStatus/{id}")
    public ResponseEntity<List<PedidoDto>> findByClienteAndEstado(@PathVariable Long id, @RequestParam String estado) {
        List<PedidoDto> pedidos = pedidoService.findByClienteAndEstado(id, estado);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);

    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> recuperarPedidosConArticulosPorCliente(@PathVariable Long id) {
        List<PedidoDto> pedidos = pedidoService.recuperarPedidosConArticulosPorCliente(id);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }


    @GetMapping("/date")
    public ResponseEntity<List<PedidoDto>> findByFechaPedidoBetween(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        List<PedidoDto> pedidos = pedidoService.findByFechaPedidoBetween(fechaInicio, fechaFin);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<PedidoDto> guardarPedido(@RequestBody PedidoDto pedido) {
        PedidoDto pedidoGuardado = pedidoService.guardarPedido(pedido);
        return new ResponseEntity<>(pedidoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> updatePedido(@PathVariable Long id, @RequestBody PedidoDto pedido) {
        PedidoDto pedidoActualizado = pedidoService.actualizarPedido(id, pedido);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return  ResponseEntity.ok().body("Pedido eliminado correctamente");
    }


}
