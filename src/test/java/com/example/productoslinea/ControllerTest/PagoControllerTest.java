package com.example.productoslinea.ControllerTest;

import com.example.productoslinea.data.Dtos.PagoDto;
import com.example.productoslinea.data.Service.PagoService;
import com.example.productoslinea.data.entities.Enums.MetodoPago;
import com.example.productoslinea.data.entities.Pago;
import com.example.productoslinea.data.repositories.PagoRepository;
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
public class PagoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PagoService pagoService;

    @Test
    public void testGetAllPagos() {
        ResponseEntity<List<PagoDto>> response = restTemplate.exchange("/pagos", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PagoDto>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<PagoDto> pagos = pagoService.findAll();
        assertTrue(pagos.size() > 0);

        List<Pago> pagosFromRepository = pagoRepository.findAll();
        assertTrue(pagosFromRepository.size() > 0);
    }

    @Test
    public void testGetPagoById() {
        Pago pago = new Pago();
        pago.setMetodoPago(MetodoPago.valueOf("NEQUI"));
        pago.setTotalPago(1000000.0);
        pagoRepository.save(pago);

        ResponseEntity<PagoDto> response = restTemplate.getForEntity("/pagos/{id}", PagoDto.class, pago.getId());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        PagoDto pagoDto = pagoService.findById(pago.getId());
        assertEquals(pago.getMetodoPago(), pagoDto.getMetodo());
        assertEquals(pago.getTotalPago(), pagoDto.getMonto(), 0.0);
    }
}

