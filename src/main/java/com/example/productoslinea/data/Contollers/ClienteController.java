package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.ClienteDto;
import com.example.productoslinea.data.Service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")

public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping ()
    public ResponseEntity<List<ClienteDto>> findAll() {
        List<ClienteDto> clientes = clienteService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        ClienteDto cliente = clienteService.findById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteDto> findByEmail(@PathVariable String email) {
        ClienteDto cliente = clienteService.findByEmail(email);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/address/{address}")
    public ResponseEntity<List<ClienteDto>> findByDireccion(@PathVariable String address) {
        List<ClienteDto> cliente = clienteService.findByDireccion(address);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ClienteDto>> findAllByNombreStarting(@PathVariable String name) {
        List<ClienteDto> cliente = clienteService.findAllByNombreStarting(name);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> guardarCliente(@RequestBody ClienteDto cliente) {
        ClienteDto clienteGuardado = clienteService.guardarCliente(cliente);
        return new ResponseEntity<>(clienteGuardado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok().body("Cliente eliminado con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable Long id, @RequestBody ClienteDto cliente) {
        ClienteDto clienteActualizado = clienteService.actualizarCliente(id, cliente);
        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }

}
