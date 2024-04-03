package com.example.productoslinea.data.Mappers;

import com.example.productoslinea.data.Dtos.Send.ClienteDtoSend;
import com.example.productoslinea.data.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ClienteMapper {
    ClienteDtoSend clienteToClienteDtoSend(Cliente cliente);
    Cliente clienteDtoSendToCliente(ClienteDtoSend clienteDtoSend);
}
