package com.example.productoslinea.ControllerTest;

import com.example.productoslinea.data.Dtos.ClienteDto;
import com.example.productoslinea.data.Service.ClienteService;
import com.example.productoslinea.data.entities.Cliente;
import com.example.productoslinea.data.repositories.ClienteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testGetAllClientes() {
        ResponseEntity<List<ClienteDto>> response = restTemplate.exchange("/clientes", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ClienteDto>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<ClienteDto> clientes = clienteService.findAll();
        assertTrue(clientes.size() > 0);

        List<Cliente> clientesFromRepository = clienteRepository.findAll();
        assertTrue(clientesFromRepository.size() > 0);
    }

    @Test
    public void testGetClienteById() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Ejemplo");
        cliente.setDireccion("Calle 123");
        cliente.setEmail("skdja");

        clienteRepository.save(cliente);

        ResponseEntity<ClienteDto> response = restTemplate.getForEntity("/clientes/{id}", ClienteDto.class, cliente.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        ClienteDto clienteDto = clienteService.findById(cliente.getId());
        assertEquals(cliente.getNombre(), clienteDto.getNombre());
        assertEquals(cliente.getDireccion(), clienteDto.getDireccion());
        assertEquals(cliente.getEmail(), clienteDto.getEmail());
    }
}

