package com.example.productoslinea.ControllerTest;

import com.example.productoslinea.data.Dtos.Send.PagoDtoSend;
import com.example.productoslinea.data.Service.PagoService;
import com.example.productoslinea.data.entities.Enums.MetodoPago;
import com.example.productoslinea.data.entities.Pago;
import com.example.productoslinea.data.repositories.PagoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
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
public class PagoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PagoService pagoService;

    @Test
    public void testGetAllPagos() {
        // Prueba de integración: Realizar una solicitud GET al endpoint correspondiente
        ResponseEntity<List<PagoDtoSend>> response = restTemplate.exchange("/pagos", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PagoDtoSend>>() {});

        // Verificar el código de estado de la respuesta
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Prueba unitaria: Verificar que el servicio devuelve una lista no vacía
        List<PagoDtoSend> pagos = pagoService.findAll();
        assertTrue(pagos.size() > 0);

        // Prueba unitaria: Verificar que la lista de pagos contiene al menos un pago
        List<Pago> pagosFromRepository = pagoRepository.findAll();
        assertTrue(pagosFromRepository.size() > 0);
    }

    @Test
    public void testGetPagoById() {
        Pago pago = new Pago();
        pago.setMetodoPago(MetodoPago.valueOf("NEQUI"));
        pago.setTotalPago(1000000.0);
        pagoRepository.save(pago);

        ResponseEntity<PagoDtoSend> response = restTemplate.getForEntity("/pagos/{id}", PagoDtoSend.class, pago.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        PagoDtoSend pagoDto = pagoService.findById(pago.getId());
        assertEquals(pago.getMetodoPago(), pagoDto.getMetodo());
        assertEquals(pago.getTotalPago(), pagoDto.getMonto(), 0.0);
    }
}

