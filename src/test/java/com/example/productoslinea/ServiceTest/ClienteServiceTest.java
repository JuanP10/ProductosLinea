package com.example.productoslinea.ServiceTest;

import com.example.productoslinea.data.Dtos.Send.ClienteDtoSend;
import com.example.productoslinea.data.Mappers.ClienteMapper;
import com.example.productoslinea.data.Service.ServiceImpl.ClienteServiceImp;
import com.example.productoslinea.data.entities.Cliente;
import com.example.productoslinea.data.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DataJpaTest

public class ClienteServiceTest {
    @Mock
    private ClienteRepository clientRepository;

    @Mock
    private ClienteMapper clientMapper;

    @InjectMocks
    private ClienteServiceImp clientService;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setEmail("ramirez@gmail.com");
        cliente.setDireccion("Kr 24");
    }

    @Test
    void ReturnClientID(){
        Long idProduct = 1L;

        given(clientRepository.findById(idProduct))
                .willReturn(Optional.of(cliente));

        ClienteDtoSend productDto = new ClienteDtoSend();

        given(clientMapper.clienteToClienteDtoSend(any(Cliente.class)))
                .willReturn(productDto);

        ClienteDtoSend result = clientService.findById(idProduct);

        assertNotNull(result);
    }

    @Test
    void ReturnExceptionClienteNotFoundID() {
        given(clientRepository.findById(any()))
                .willReturn(Optional.empty());

        assertThrows(ConfigDataNotFoundException.class, () ->{
            clientService.findById(any());
        }, "Data wasn't found");
    }

    @Test
    void UpdateCliente() {
        ClienteDtoSend clientDto = new ClienteDtoSend();
        clientDto.setNombre("Juanito");
        clientDto.setEmail("juanito@gmail.com");
        clientDto.setDireccion("sdadf");

        Long test1 = 1L;

        given(clientRepository.findById(test1))
                .willReturn(Optional.of(cliente));

        assertDoesNotThrow(() -> {
            clientService.guardarCliente(clientDto);
        });
    }

    @Test
    void DeleteCliente() {
        Long clienteId = 1L;

        given(clientRepository.findById(clienteId))
                .willReturn(Optional.of(cliente));

        willDoNothing().given(clientRepository).delete(any());

        clientService.deleteCliente(clienteId);

        verify(clientRepository, times(1)).delete(any());
    }
}
