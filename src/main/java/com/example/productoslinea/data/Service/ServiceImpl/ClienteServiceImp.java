package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Send.ClienteDtoSend;
import com.example.productoslinea.data.Mappers.ClienteMapper;
import com.example.productoslinea.data.Service.ClienteService;
import com.example.productoslinea.data.entities.Cliente;
import com.example.productoslinea.data.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImp(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }


    @Override
    public Cliente findByEmail(String email) {
        return this.clienteRepository.findByEmail(email);
    }

    @Override
    public List<ClienteDtoSend> findByDireccion(String direccion) {
        List<ClienteDtoSend> clientesDireccion = clienteRepository.findByDireccion(direccion)
                .stream()
                .map(clienteMapper::clienteToClienteDtoSend)
                .toList();
        return clientesDireccion;
    }

    @Override
    public List<ClienteDtoSend> findAllByNombreStarting(String nombre) {
        return null;
    }

    @Override
    public List<ClienteDtoSend> findAll() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::clienteToClienteDtoSend)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDtoSend guardarCliente(ClienteDtoSend cliente) {
        return null;
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return this.clienteRepository.findById(id);
    }

    @Override
    public void deleteCliente(Long id) {
        this.deleteCliente(id);
    }
}
