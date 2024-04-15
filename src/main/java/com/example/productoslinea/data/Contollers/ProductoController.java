package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.ProductoDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> findById(@PathVariable Long id) {
        ProductoDto producto = productoService.findById(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductoDto>> findAllByNombreStarting(@RequestParam String nombre) {
        List<ProductoDto> producto = productoService.findByName(nombre);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @GetMapping("/instock")
    public ResponseEntity<List<ProductoDto>> findByStock() {
        List<ProductoDto> productos = productoService.findByStock();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDto> guardarProducto(@RequestBody ProductoDto producto) {
        ProductoDto productoGuardado = productoService.guardarProducto(producto);
        return new ResponseEntity<>(productoGuardado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable Long id, @RequestBody ProductoDto producto) {
        ProductoDto productoActualizado = productoService.actualizarProducto(id, producto);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok().body("Producto eliminado");
    }


    // ----------------------------------------------------------------------------------- //
    @GetMapping("/price/{price}")
    public ResponseEntity<List<ProductoDto>> findByPriceAndStock(@PathVariable Double price, @RequestParam Integer stock) {
        List<ProductoDto> productos = productoService.findByPriceAndStock(price, stock);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> findAll() {
        List<ProductoDto> productos = productoService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}
