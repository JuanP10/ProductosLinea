package com.example.productoslinea.RepositoryTest;

import com.example.productoslinea.data.entities.Pedido;
import com.example.productoslinea.data.repositories.PedidoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PedidoRepositoryTest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    public void testSavePedido() {
        // Crear un pedido de ejemplo
        Pedido pedido = new Pedido();
        Pedido savedPedido = pedidoRepository.save(pedido);
        assertNotNull(savedPedido);
        assertNotNull(savedPedido.getId());
        Pedido retrievedPedido = pedidoRepository.findById(savedPedido.getId()).orElse(null);
        assertNotNull(retrievedPedido);
    }

    @Test
    public void testFindAllPedidos() {
        Pedido pedido1 = new Pedido();
        pedidoRepository.save(pedido1);

        Pedido pedido2 = new Pedido();
        pedidoRepository.save(pedido2);
        List<Pedido> pedidos = pedidoRepository.findAll();
        assertTrue(pedidos.size() >= 2);
    }
}
