package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.PagoDto;
import com.example.productoslinea.data.Mappers.PagoMapper;
import com.example.productoslinea.data.Service.PagoService;
import com.example.productoslinea.data.entities.Enums.MetodoPago;
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
    public List<PagoDto> findAll() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagos.stream().map(pagoMapper::pagoToPagoDto).toList();
    }

    @Override
    public PagoDto findById(Long id) {
        Pago pago = pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado con el ID: " + id));
        return pagoMapper.pagoToPagoDto(pago);
    }

    @Override
    public PagoDto guardar (PagoDto pagoDto) {
        Pago pago = pagoMapper.pagoDtoToPago(pagoDto);
        return pagoMapper.pagoToPagoDto(pagoRepository.save(pago));
    }

    @Override
    public PagoDto actualizar(Long id, PagoDto pagoDto) {
        Pago pago = pagoMapper.pagoDtoToPago(pagoDto);
        Pago pagoActualizado = pagoRepository.findById(id).map(pago1 -> {
            pago1.setTotalPago(pago.getTotalPago());
            pago1.setFechaPago(pago.getFechaPago());
            pago1.setMetodoPago(pago.getMetodoPago());
            pago1.setPedido(pago.getPedido());
            return pagoRepository.save(pago1);
        }).orElseThrow(() -> new RuntimeException("Pago no encontrado con el ID: " + id));

        return pagoMapper.pagoToPagoDto(pagoActualizado);
    }

    @Override
    public List<PagoDto> findByPedidoIdAndMetodoPago(Long pedidoId, String metodoPago) {
        List<Pago> pagos = pagoRepository.findByPedidoIdAndMetodoPago(pedidoId, metodoPago);
        return pagos.stream().map(pagoMapper::pagoToPagoDto).toList();
    }

    @Override
    public List<PagoDto> findByFechaPagoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Pago> pagos = pagoRepository.findByFechaPagoBetween(fechaInicio, fechaFin);
        return pagos.stream().map(pagoMapper::pagoToPagoDto).toList();
    }

    @Override
    public void delete(Long id) {
        pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado con el ID: " + id));
        pagoRepository.deleteById(id);
    }
}
