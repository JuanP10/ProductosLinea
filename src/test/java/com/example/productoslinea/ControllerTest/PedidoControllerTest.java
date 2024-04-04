package com.example.productoslinea.ControllerTest;

import com.example.productoslinea.data.Dtos.Send.PedidoDtoSend;
import com.example.productoslinea.data.Service.PedidoService;
import com.example.productoslinea.data.entities.Pedido;
import com.example.productoslinea.data.repositories.PedidoRepository;
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
public class PedidoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @Test
    public void testGetAllPedidos() {
        ResponseEntity<List<PedidoDtoSend>> response = restTemplate.exchange("/pedidos", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PedidoDtoSend>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<PedidoDtoSend> pedidos = pedidoService.findAll();
        assertTrue(pedidos.size() > 0);

        List<Pedido> pedidosFromRepository = pedidoRepository.findAll();
        assertTrue(pedidosFromRepository.size() > 0);
    }
}
