package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.DetalleEnvioDto;
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
    public List<DetalleEnvioDto> findAll() {
        List<DetalleEnvio> detalleEnvioDtoSendList = detalleEnvioRepository.findAll();
        return detalleEnvioDtoSendList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDto).toList();

    }

    @Override
    public DetalleEnvioDto findById(Long id) {
        DetalleEnvio detalleEnvio = detalleEnvioRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de envio no encontrado con ID: " + id));
        return detalleEnvioMapper.detalleEnvioToDetalleEnvioDto(detalleEnvio);
    }

    @Override
    public List<DetalleEnvioDto> findByPedidoId(Long pedidoId) {
        List<DetalleEnvio> detalleEnvioList = detalleEnvioRepository.findByPedidoId(pedidoId);
        return detalleEnvioList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDto).toList();
    }

    @Override
    public List<DetalleEnvioDto> findByTransportadora(String transportadora) {
        List<DetalleEnvio> detalleEnvioList = detalleEnvioRepository.findByTransportadora(transportadora);
        return detalleEnvioList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDto).toList();
    }

    @Override
    public List<DetalleEnvioDto> findByPedidoEstado(String estado) {
        List<DetalleEnvio> detalleEnvioList = detalleEnvioRepository.findByPedidoEstado(estado);
        return detalleEnvioList.stream().map(detalleEnvioMapper::detalleEnvioToDetalleEnvioDto).toList();
    }

    @Override
    public DetalleEnvioDto save(DetalleEnvioDto detalleEnvioDto) {
        DetalleEnvio detalleEnvio = detalleEnvioMapper.detalleEnvioDtotoDetalleEnvio(detalleEnvioDto);
        return detalleEnvioMapper.detalleEnvioToDetalleEnvioDto(detalleEnvioRepository.save(detalleEnvio));
    }

    @Override
    public DetalleEnvioDto actualizarUpdate(Long id, DetalleEnvioDto detalleEnvioDto) {
       DetalleEnvio detalleEnvio = detalleEnvioMapper.detalleEnvioDtotoDetalleEnvio(detalleEnvioDto);
       DetalleEnvio detalleEnvioActualizado = detalleEnvioRepository.findById(id).map(detalleEnvio1 -> {
           detalleEnvio1.setDireccion(detalleEnvio.getDireccion());
           detalleEnvio1.setTransportadora(detalleEnvio.getTransportadora());
           detalleEnvio1.setNumeroGuia(detalleEnvio.getNumeroGuia());
           return detalleEnvioRepository.save(detalleEnvio1);
       }).orElseThrow(() -> new RuntimeException("Detalle de envio no encontrado con ID: " + id));
         return detalleEnvioMapper.detalleEnvioToDetalleEnvioDto(detalleEnvioActualizado);
    }

    @Override
    public void delete(Long id) {
        detalleEnvioRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de envio no encontrado con ID: " + id));
        detalleEnvioRepository.deleteById(id);
    }
}
