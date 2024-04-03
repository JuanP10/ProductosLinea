package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.Send.ClienteDtoSend;
import com.example.productoslinea.data.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ClienteDtoSend findByEmail(String email); //
    List<ClienteDtoSend> findByDireccion(String direccion); //

    List<ClienteDtoSend> findAllByNombreStarting(String nombre); //
    List<ClienteDtoSend> findAll(); //

    ClienteDtoSend guardarCliente(ClienteDtoSend cliente); //
    ClienteDtoSend findById(Long id); //
    void deleteCliente(Long id); //
}
