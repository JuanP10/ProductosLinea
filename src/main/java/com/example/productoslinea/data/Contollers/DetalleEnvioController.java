package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.Send.DetalleEnvioDtoSend;
import com.example.productoslinea.data.Service.DetalleEnvioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipping")
public class DetalleEnvioController {

    private final DetalleEnvioService detalleEnvioService;

    public DetalleEnvioController(DetalleEnvioService detalleEnvioService) {
        this.detalleEnvioService = detalleEnvioService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleEnvioDtoSend>> findAll() {
        return ResponseEntity.ok(detalleEnvioService.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<DetalleEnvioDtoSend> findById(Long id) {
        return ResponseEntity.ok(detalleEnvioService.findById(id));
    }

    @GetMapping ("/pedido/{pedidoId}")
    public ResponseEntity<List<DetalleEnvioDtoSend>> findByPedidoId(Long pedidoId) {
        return ResponseEntity.ok(detalleEnvioService.findByPedidoId(pedidoId));
    }

    @GetMapping ("/transportadora/{transportadora}")
    public ResponseEntity<List<DetalleEnvioDtoSend>> findByTransportadora (String transportadora) {
        return ResponseEntity.ok(detalleEnvioService.findByTransportadora(transportadora));
    }

    @GetMapping ("/estado/{estado}")
    public ResponseEntity<List<DetalleEnvioDtoSend>> findByPedidoEstado(String estado) {
        return ResponseEntity.ok(detalleEnvioService.findByPedidoEstado(estado));
    }

    @GetMapping ("/save")
    public ResponseEntity<DetalleEnvioDtoSend> save(DetalleEnvioDtoSend detalleEnvioDtoSend) {
        return ResponseEntity.ok(detalleEnvioService.save(detalleEnvioDtoSend));
    }

    @GetMapping ("/delete/{id}")
    public void delete(Long id) {
        detalleEnvioService.delete(id);
    }

}
