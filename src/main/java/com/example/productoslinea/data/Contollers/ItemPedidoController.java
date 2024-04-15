package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.ItemPedidoDto;
import com.example.productoslinea.data.Service.ItemPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/orderItems")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping
    public ResponseEntity<?> getAllOrderItems() {
        return ResponseEntity.ok(itemPedidoService.findAll());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrderItemsByOrderId(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.findByPedidoId(id));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getOrderItemsByProductId(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.findByProductoId(id));
    }

    @GetMapping("/product/sales/{id}")
    public ResponseEntity<?> getTotalSalesByProductId(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.calcularTotalVentasPorProducto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderItem(@PathVariable Long id, @RequestBody ItemPedidoDto itemPedidoDto) {
        return ResponseEntity.ok(itemPedidoService.guardarItemPedido(id, itemPedidoDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ItemPedidoDto> guardarItemPedido (@RequestBody ItemPedidoDto itemPedidoDto) {
        ItemPedidoDto itemPedido = itemPedidoService.save(itemPedidoDto);
        return new ResponseEntity<>(itemPedido, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable Long id) {
        itemPedidoService.delete(id);
        return ResponseEntity.ok().body("ItemPedido eliminado");
    }


}
