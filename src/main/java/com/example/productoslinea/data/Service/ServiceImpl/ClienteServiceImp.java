package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Send.ClienteDtoSend;
import com.example.productoslinea.data.Mappers.ClienteMapper;
import com.example.productoslinea.data.Service.ClienteService;
import com.example.productoslinea.data.entities.Cliente;
import com.example.productoslinea.data.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public ClienteDtoSend findByEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        return clienteMapper.clienteToClienteDtoSend(cliente);
    }

    @Override
    public List<ClienteDtoSend> findByDireccion(String direccion) {
        List <Cliente> clientes = clienteRepository.findByDireccion(direccion);
        return clientes.stream().map(clienteMapper::clienteToClienteDtoSend).collect(Collectors.toList());
    }

    @Override
    public List<ClienteDtoSend> findAllByNombreStarting(String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombreStartingWith(nombre);
        return clientes.stream().map(clienteMapper::clienteToClienteDtoSend).collect(Collectors.toList());
    }

    @Override
    public List<ClienteDtoSend> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::clienteToClienteDtoSend).collect(Collectors.toList());
    }

    @Override
    public ClienteDtoSend guardarCliente(ClienteDtoSend cliente) {
        Cliente clienteEntity = clienteMapper.clienteDtoSendToCliente(cliente);
        return clienteMapper.clienteToClienteDtoSend(clienteRepository.save(clienteEntity));
    }

    @Override
    public ClienteDtoSend findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente not found with ID: " + id));
        return clienteMapper.clienteToClienteDtoSend(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
