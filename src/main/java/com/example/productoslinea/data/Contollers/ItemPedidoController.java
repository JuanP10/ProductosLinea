package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.Send.ItemPedidoDtoSend;
import com.example.productoslinea.data.Service.ItemPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;

@RestController
@RequestMapping("/api/v1/order-items")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOrderItems() {
        return ResponseEntity.ok(itemPedidoService.findAll());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderItemsByOrderId(Long orderId) {
        return ResponseEntity.ok(itemPedidoService.findByPedidoId(orderId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getOrderItemsByProductId(Long productId) {
        return ResponseEntity.ok(itemPedidoService.findByProductoId(productId));
    }

    @GetMapping("/product/{productId}/total-sales")
    public ResponseEntity<?> getTotalSalesByProductId(Long productId) {
        return ResponseEntity.ok(itemPedidoService.calcularTotalVentasPorProducto(productId));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOrderItemById(Long id) {
        return ResponseEntity.ok(itemPedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> saveOrderItem(ItemPedidoDtoSend itemPedidoDtoSend) {
        return ResponseEntity.ok(itemPedidoService.save(itemPedidoDtoSend));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteOrderItem(Long id) {
        itemPedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
