package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.DetalleEnvioDto;
import com.example.productoslinea.data.Service.DetalleEnvioService;
import com.example.productoslinea.data.entities.DetalleEnvio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shippingDetails")
public class DetalleEnvioController {

    private final DetalleEnvioService detalleEnvioService;

    public DetalleEnvioController(DetalleEnvioService detalleEnvioService) {
        this.detalleEnvioService = detalleEnvioService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleEnvioDto>> findAll() {
        return ResponseEntity.ok(detalleEnvioService.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<DetalleEnvioDto> findById(@PathVariable Long id) {
        DetalleEnvioDto detalleEnvioDto = detalleEnvioService.findById(id);
        return new ResponseEntity<>(detalleEnvioDto, HttpStatus.OK);
    }

    @GetMapping ("/order/{id}")
    public ResponseEntity<List<DetalleEnvioDto>> findByPedidoId(@PathVariable Long id) {
        return ResponseEntity.ok(detalleEnvioService.findByPedidoId(id));
    }

    @GetMapping ("/shippingCompany/{name}")
    public ResponseEntity<List<DetalleEnvioDto>> findByTransportadora (@PathVariable String name) {
        return ResponseEntity.ok(detalleEnvioService.findByTransportadora(name));
    }

    @GetMapping ("/order/status/{status}")
    public ResponseEntity<List<DetalleEnvioDto>> findByPedidoEstado(@PathVariable String status) {
        return ResponseEntity.ok(detalleEnvioService.findByPedidoEstado(status));
    }

    @PostMapping
    public ResponseEntity<DetalleEnvioDto> save(@RequestBody DetalleEnvioDto detalleEnvioDto) {
        return ResponseEntity.ok(detalleEnvioService.save(detalleEnvioDto));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<DetalleEnvioDto> update(@PathVariable Long id, @RequestBody DetalleEnvioDto detalleEnvioDto) {
        return ResponseEntity.ok(detalleEnvioService.actualizarUpdate(id, detalleEnvioDto));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        detalleEnvioService.delete(id);
        return ResponseEntity.ok().body("Envio eliminado correctamente");
    }

}
