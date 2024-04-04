package com.example.productoslinea.RepositoryTest;

import com.example.productoslinea.data.entities.Pago;
import com.example.productoslinea.data.repositories.PagoRepository;
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
public class PagoRepositoryTest {

    @Autowired
    private PagoRepository pagoRepository;

    @Test
    public void testSavePago() {
        // Crear un pago de ejemplo
        Pago pago = new Pago();

        Pago savedPago = pagoRepository.save(pago);

        assertNotNull(savedPago);
        assertNotNull(savedPago.getId());

        Pago retrievedPago = pagoRepository.findById(savedPago.getId()).orElse(null);

        assertNotNull(retrievedPago);
    }

    @Test
    public void testFindAllPagos() {
        // Crear pagos de ejemplo y guardarlos en la base de datos
        Pago pago1 = new Pago();
        pagoRepository.save(pago1);

        Pago pago2 = new Pago();
        pagoRepository.save(pago2);
        List<Pago> pagos = pagoRepository.findAll();
        assertTrue(pagos.size() >= 2);
    }
}

