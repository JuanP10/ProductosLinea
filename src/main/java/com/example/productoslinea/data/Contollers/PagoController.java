package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.PagoDto;
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


    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getPaymentsByPedidoIdAndMetodoPago(@PathVariable Long orderId, @RequestParam String metodoPago) {
        return ResponseEntity.ok(pagoService.findByPedidoIdAndMetodoPago(orderId, metodoPago));
    }

    @GetMapping("/date-range")
    public ResponseEntity<?> getPaymentsByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(pagoService.findByFechaPagoBetween(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<?> guardarCliente(@RequestBody PagoDto pagoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.guardar(pagoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody PagoDto pagoDto) {
        return ResponseEntity.ok(pagoService.actualizar(id, pagoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        pagoService.delete(id);
        return ResponseEntity.ok().body("Pago eliminado");
    }



}
