package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.ItemPedidoDto;
import com.example.productoslinea.data.Service.ItemPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/order-items")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllOrderItems() {
        return ResponseEntity.ok(itemPedidoService.findAll());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(itemPedidoService.findByPedidoId(orderId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getOrderItemsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(itemPedidoService.findByProductoId(productId));
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDto> guardarItemPedido (@RequestBody ItemPedidoDto itemPedidoDto) {
        ItemPedidoDto itemPedido = itemPedidoService.save(itemPedidoDto);
        return new ResponseEntity<>(itemPedido, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderItem(@PathVariable Long id, @RequestBody ItemPedidoDto itemPedidoDto) {
        return ResponseEntity.ok(itemPedidoService.guardarItemPedido(id, itemPedidoDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable Long id) {
        itemPedidoService.delete(id);
        return ResponseEntity.ok().body("ItemPedido eliminado");
    }

    //---------------------------------------------------------//
    @GetMapping("/product/sales/{id}")
    public ResponseEntity<?> getTotalSalesByProductId(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.calcularTotalVentasPorProducto(id));
    }


}
