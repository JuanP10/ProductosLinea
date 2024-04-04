package com.example.productoslinea.RepositoryTest;

import com.example.productoslinea.data.entities.Cliente;
import com.example.productoslinea.data.repositories.ClienteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testSaveCliente() {
        // Crear un cliente de ejemplo
        Cliente cliente = new Cliente();
        cliente.setNombre("Ejemplo");
        cliente.setEmail("fghj");

        Cliente savedCliente = clienteRepository.save(cliente);

        assertNotNull(savedCliente);
        assertNotNull(savedCliente.getId());

        Cliente retrievedCliente = clienteRepository.findById(savedCliente.getId()).orElse(null);

        assertNotNull(retrievedCliente);

        assertEquals(cliente.getNombre(), retrievedCliente.getNombre());
        assertEquals(cliente.getDireccion(), retrievedCliente.getDireccion());
    }

    @Test
    public void testFindAllClientes() {
        // Crear clientes de ejemplo y guardarlos en la base de datos
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Cliente1");
        cliente1.setEmail("fghj");
        clienteRepository.save(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Cliente2");
        cliente2.setEmail("fghj");
        clienteRepository.save(cliente2);

        List<Cliente> clientes = clienteRepository.findAll();

        // Verificar que se recuperaron al menos dos clientes de la base de datos
        assertTrue(clientes.size() >= 2);
    }
}

