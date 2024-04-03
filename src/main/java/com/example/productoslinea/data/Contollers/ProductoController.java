package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.Send.ProductoDtoSend;
import com.example.productoslinea.data.Service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDtoSend>> findAll() {
        List<ProductoDtoSend> productos = productoService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDtoSend> findById(Long id) {
        ProductoDtoSend producto = productoService.findById(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/search/{nombre}")
    public ResponseEntity<List<ProductoDtoSend>> findAllByNombreStarting(String nombre) {
        List<ProductoDtoSend> producto = productoService.findByName(nombre);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        productoService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/stock")
    public ResponseEntity<List<ProductoDtoSend>> findByStock() {
        List<ProductoDtoSend> productos = productoService.findByStock();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @GetMapping("/price/{price}/stock/{stock}")
    public ResponseEntity<List<ProductoDtoSend>> findByPriceAndStock(double price, int stock) {
        List<ProductoDtoSend> productos = productoService.findByPriceAndStock(price, stock);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDtoSend> guardarProducto(@RequestBody ProductoDtoSend producto) {
        ProductoDtoSend productoGuardado = productoService.guardarProducto(producto);
        return new ResponseEntity<>(productoGuardado, HttpStatus.CREATED);
    }
}
