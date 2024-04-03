package com.example.productoslinea.data.Contollers;

import com.example.productoslinea.data.Dtos.Send.ClienteDtoSend;
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
    public ResponseEntity<List<ClienteDtoSend>> findAll() {
        List<ClienteDtoSend> clientes = clienteService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ClienteDtoSend> findById(Long id) {
        ClienteDtoSend cliente = clienteService.findById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteDtoSend> findByEmail(String email) {
        ClienteDtoSend cliente = clienteService.findByEmail(email);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<List<ClienteDtoSend>> findByDireccion(String direccion) {
        List<ClienteDtoSend> cliente = clienteService.findByDireccion(direccion);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ClienteDtoSend>> findAllByNombreStarting(String nombre) {
        List<ClienteDtoSend> cliente = clienteService.findAllByNombreStarting(nombre);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDtoSend> guardarCliente(@RequestBody ClienteDtoSend cliente) {
        ClienteDtoSend clienteGuardado = clienteService.guardarCliente(cliente);
        return new ResponseEntity<>(clienteGuardado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
