package com.example.productoslinea.ServiceTest;

import com.example.productoslinea.data.Dtos.Send.PagoDtoSend;
import com.example.productoslinea.data.Mappers.PagoMapper;
import com.example.productoslinea.data.Service.ServiceImpl.PagoServiceImp;
import com.example.productoslinea.data.entities.Enums.MetodoPago;
import com.example.productoslinea.data.entities.Pago;
import com.example.productoslinea.data.repositories.PagoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.config.ConfigDataNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class PagoServiceTest {

    @Mock
    private PagoRepository pagoRepository;

    @Mock
    private PagoMapper pagoMapper;

    @InjectMocks
    private PagoServiceImp pagoService;

    private Pago pago;

    @BeforeEach
    public void setUp() {
        pago = new Pago();
        pago.setMetodoPago(MetodoPago.valueOf("NEQUI"));
        pago.setTotalPago(1000000.0);
        pago.setFechaPago(LocalDate.parse("2021-10-10"));

    }

    @Test
    void givenPagoId_whenFindPagoById_thenReturnPago(){
        Long idPago = 1L;

        given(pagoRepository.findById(idPago))
                .willReturn(Optional.of(pago));

        PagoDtoSend pagoDto = new PagoDtoSend();

        given(pagoMapper.pagoToPagoDtoSend(any(Pago.class)))
                .willReturn(pagoDto);

        PagoDtoSend result = pagoService.findById(idPago);

        assertNotNull(result);
    }

    @Test
    void givenPagoId_whenIdNotFound_thenReturnException() {
        given(pagoRepository.findById(any()))
                .willReturn(Optional.empty());

        assertThrows(ConfigDataNotFoundException.class, () ->{
            pagoService.findById(any());
        }, "Data wasn't found");
    }
}

