package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.Send.PagoDtoSend;
import com.example.productoslinea.data.Service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/payments")
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

   @GetMapping
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(Long id) {
        return ResponseEntity.ok(pagoService.findById(id));
    }

    @GetMapping("/pedido/{pedidoId}/metodo/{metodoPago}")
    public ResponseEntity<?> getPaymentsByPedidoIdAndMetodoPago(Long pedidoId, String metodoPago) {
        return ResponseEntity.ok(pagoService.findByPedidoIdAndMetodoPago(pedidoId, metodoPago));
    }

    @GetMapping("/date")
    public ResponseEntity<?> getPaymentsByDate(LocalDate fechaInicio, LocalDate fechaFin) {
        return ResponseEntity.ok(pagoService.findByFechaPagoBetween(fechaInicio, fechaFin));
    }

    @PostMapping
    public ResponseEntity<?> guardarCliente(@RequestBody PagoDtoSend pagoDtoSend) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(pagoDtoSend));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(Long id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
