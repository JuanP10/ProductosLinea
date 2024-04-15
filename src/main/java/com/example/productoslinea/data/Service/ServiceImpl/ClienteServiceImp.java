package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.ClienteDto;
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
    public ClienteDto findByEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        return clienteMapper.clienteToClienteDto(cliente);
    }

    @Override
    public List<ClienteDto> findByDireccion(String direccion) {
        List <Cliente> clientes = clienteRepository.findByDireccion(direccion);
        return clientes.stream().map(clienteMapper::clienteToClienteDto).toList();
    }

    @Override
    public List<ClienteDto> findAllByNombreStarting(String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombreStartingWith(nombre);
        return clientes.stream().map(clienteMapper::clienteToClienteDto).toList();
    }

    @Override
    public List<ClienteDto> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::clienteToClienteDto).toList();
    }

    @Override
    public ClienteDto actualizarCliente(Long id, ClienteDto cliente) {
        Cliente clienteEntity = clienteMapper.clienteDtoToCliente(cliente);
        Cliente clienteActualizado = clienteRepository.findById(id).map(clienteEncontrado -> {
            clienteEncontrado.setNombre(clienteEntity.getNombre());
            clienteEncontrado.setEmail(clienteEntity.getEmail());
            clienteEncontrado.setDireccion(clienteEntity.getDireccion());
            return clienteRepository.save(clienteEncontrado);
        }).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

        return clienteMapper.clienteToClienteDto(clienteActualizado);
    }

    @Override
    public ClienteDto guardarCliente(ClienteDto cliente) {
        Cliente clienteEntity = clienteMapper.clienteDtoToCliente(cliente);
        return clienteMapper.clienteToClienteDto(clienteRepository.save(clienteEntity));
    }

    @Override
    public ClienteDto findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));
        return clienteMapper.clienteToClienteDto(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

        clienteRepository.deleteById(id);
    }
}
