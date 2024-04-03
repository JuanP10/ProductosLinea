package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Send.PagoDtoSend;
import com.example.productoslinea.data.Mappers.PagoMapper;
import com.example.productoslinea.data.Service.PagoService;
import com.example.productoslinea.data.entities.Pago;
import com.example.productoslinea.data.repositories.PagoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagoServiceImp implements PagoService {
    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    public PagoServiceImp(PagoRepository pagoRepository, PagoMapper pagoMapper) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
    }

    @Override
    public List<PagoDtoSend> findAll() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagos.stream().map(pagoMapper::pagoToPagoDtoSend).toList();
    }

    @Override
    public PagoDtoSend findById(Long id) {
        Pago pago = pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado con el ID: " + id));
        return pagoMapper.pagoToPagoDtoSend(pago);
    }

    @Override
    public PagoDtoSend save(PagoDtoSend pagoDtoSend) {
        Pago pago = pagoMapper.pagoDtoSendToPago(pagoDtoSend);
        return pagoMapper.pagoToPagoDtoSend(pagoRepository.save(pago));
    }

    @Override
    public List<PagoDtoSend> findByPedidoIdAndMetodoPago(Long pedidoId, String metodoPago) {
        List<Pago> pagos = pagoRepository.findByPedidoIdAndMetodoPago(pedidoId, metodoPago);
        return pagos.stream().map(pagoMapper::pagoToPagoDtoSend).toList();
    }

    @Override
    public List<PagoDtoSend> findByFechaPagoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Pago> pagos = pagoRepository.findByFechaPagoBetween(fechaInicio, fechaFin);
        return pagos.stream().map(pagoMapper::pagoToPagoDtoSend).toList();
    }

    @Override
    public void delete(Long id) {
        pagoRepository.deleteById(id);
    }
}
