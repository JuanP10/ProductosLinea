package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.ClienteDto;
import com.example.productoslinea.data.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ClienteMapper {
    ClienteDto clienteToClienteDto(Cliente cliente);
    Cliente clienteDtoToCliente(ClienteDto clienteDto);
}
