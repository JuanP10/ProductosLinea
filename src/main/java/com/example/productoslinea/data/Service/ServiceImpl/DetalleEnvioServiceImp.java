package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Send.DetalleEnvioDtoSend;
import com.example.productoslinea.data.Mappers.DetalleEnvioMapper;
import com.example.productoslinea.data.Service.DetalleEnvioService;
import com.example.productoslinea.data.entities.DetalleEnvio;
import com.example.productoslinea.data.entities.Enums.Estado;
import com.example.productoslinea.data.repositories.DetalleEnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DetalleEnvioServiceImp implements DetalleEnvioService {
    private final DetalleEnvioRepository detalleEnvioRepository;
    private final DetalleEnvioMapper detalleEnvioMapper;

    public DetalleEnvioServiceImp(DetalleEnvioRepository detalleEnvioRepository, DetalleEnvioMapper detalleEnvioMapper) {
        this.detalleEnvioRepository = detalleEnvioRepository;
        this.detalleEnvioMapper = detalleEnvioMapper;
    }


    @Override
    public List<DetalleEnvioDtoSend> findAll() {
        List<DetalleEnvio> detalleEnvioDtoSendList = detalleEnvioRepository.findAll();
        return detalleEnvioDtoSendList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDtoSend).toList();

    }

    @Override
    public DetalleEnvioDtoSend findById(Long id) {
        DetalleEnvio detalleEnvio = detalleEnvioRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de envio no encontrado con ID: " + id));
        return detalleEnvioMapper.detalleEnvioToDetalleEnvioDtoSend(detalleEnvio);
    }

    @Override
    public List<DetalleEnvioDtoSend> findByPedidoId(Long pedidoId) {
        List<DetalleEnvio> detalleEnvioList = detalleEnvioRepository.findByPedidoId(pedidoId);
        return detalleEnvioList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDtoSend).toList();
    }

    @Override
    public List<DetalleEnvioDtoSend> findByTransportadora(String transportadora) {
        List<DetalleEnvio> detalleEnvioList = detalleEnvioRepository.findByTransportadora(transportadora);
        return detalleEnvioList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDtoSend).toList();
    }

    @Override
    public List<DetalleEnvioDtoSend> findByPedidoEstado(String estado) {
        List<DetalleEnvio> detalleEnvioList = detalleEnvioRepository.findByPedidoEstado(Estado.valueOf(estado));
        return detalleEnvioList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDtoSend).toList();
    }

    @Override
    public DetalleEnvioDtoSend save(DetalleEnvioDtoSend detalleEnvioDtoSend) {
        DetalleEnvio detalleEnvio = detalleEnvioMapper.detalleEnvioDtoSendtoDetallEnvio(detalleEnvioDtoSend);
        return detalleEnvioMapper.detalleEnvioToDetalleEnvioDtoSend(detalleEnvioRepository.save(detalleEnvio));
    }

    @Override
    public void delete(Long id) {
        detalleEnvioRepository.deleteById(id);
    }
}
