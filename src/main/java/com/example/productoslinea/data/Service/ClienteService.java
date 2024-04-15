package com.example.productoslinea.data.Service;

import com.example.productoslinea.data.Dtos.ClienteDto;

import java.util.List;

public interface ClienteService {
    ClienteDto findByEmail(String email); //
    List<ClienteDto> findByDireccion(String direccion); //

    List<ClienteDto> findAllByNombreStarting(String nombre); //
    List<ClienteDto> findAll(); //

    ClienteDto actualizarCliente(Long id, ClienteDto cliente); //

    ClienteDto guardarCliente(ClienteDto cliente); //
    ClienteDto findById(Long id); //
    void deleteCliente(Long id); //
}
