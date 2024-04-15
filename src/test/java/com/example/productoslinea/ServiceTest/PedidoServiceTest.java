package com.example.productoslinea.ServiceTest;

import com.example.productoslinea.data.Dtos.PedidoDto;
import com.example.productoslinea.data.Mappers.PedidoMapper;
import com.example.productoslinea.data.Service.ServiceImpl.PedidoServiceImp;
import com.example.productoslinea.data.entities.Enums.Estado;
import com.example.productoslinea.data.entities.Pedido;
import com.example.productoslinea.data.repositories.PedidoRepository;
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
public class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PedidoMapper pedidoMapper;

    @InjectMocks
    private PedidoServiceImp pedidoService;

    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        pedido.setFechaPedido(LocalDate.parse("2021-10-10"));
        pedido.setEstado(Estado.valueOf("Enviado"));
        pedido.setPago(null);
    }

    @Test
    void givenPedidoId_whenFindPedidoById_thenReturnPedido(){
        Long idPedido = 1L;

        given(pedidoRepository.findById(idPedido))
                .willReturn(Optional.of(pedido));

        PedidoDto pedidoDto = new PedidoDto();

        given(pedidoMapper.pedidoToPedidoDto(any(Pedido.class)))
                .willReturn(pedidoDto);

        PedidoDto result = pedidoService.findById(idPedido);

        assertNotNull(result);
    }

    @Test
    void givenPedidoId_whenIdNotFound_thenReturnException() {
        given(pedidoRepository.findById(any()))
                .willReturn(Optional.empty());

        assertThrows(ConfigDataNotFoundException.class, () ->{
            pedidoService.findById(any());
        }, "Data wasn't found");
    }
}

