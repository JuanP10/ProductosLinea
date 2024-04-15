package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.PedidoDto;
import com.example.productoslinea.data.Mappers.PedidoMapper;
import com.example.productoslinea.data.Service.PedidoService;
import com.example.productoslinea.data.entities.Enums.Estado;
import com.example.productoslinea.data.entities.Pedido;
import com.example.productoslinea.data.repositories.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImp implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoServiceImp(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public List<PedidoDto> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Pedido> pedidos = pedidoRepository.findByFechaPedidoBetween(fechaInicio, fechaFin);
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDto).toList();
    }

    @Override
    public List<PedidoDto> findByClienteAndEstado(Long clienteId, String estado) {
        List<Pedido> pedidos = pedidoRepository.findByClienteWithEstado(clienteId, estado);
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDto).toList();
    }

    @Override
    public List<PedidoDto> recuperarPedidosConArticulosPorCliente(Long customerId) {
        List<Pedido> pedidos = pedidoRepository.recuperarPedidosConArticulosPorCliente(customerId);
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDto).toList();
    }

    @Override
    public List<PedidoDto> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDto).toList();

    }

    @Override
    public PedidoDto findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado" + id));
        return pedidoMapper.pedidoToPedidoDto(pedido);
    }

    @Override
    public PedidoDto guardarPedido(PedidoDto pedidoDto) {
        Pedido pedido = pedidoMapper.pedidoDtoToPedido(pedidoDto);
        return pedidoMapper.pedidoToPedidoDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto actualizarPedido(Long id, PedidoDto pedidoDto) {
        Pedido pedido = pedidoMapper.pedidoDtoToPedido(pedidoDto);
        Pedido pedidoActualizado = pedidoRepository.findById(id).map(pedido1 -> {
            pedido1.setEstado(pedido.getEstado());
            pedido1.setFechaPedido(pedido.getFechaPedido());
            pedido1.setCliente(pedido.getCliente());
            pedido1.setItems(pedido.getItems());
            pedido1.setPago(pedido.getPago());
            pedido1.setEnvio(pedido.getEnvio());
            return pedidoRepository.save(pedido1);
        }).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado" + id));

        return pedidoMapper.pedidoToPedidoDto(pedidoActualizado);
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado" + id));
        pedidoRepository.deleteById(id);
    }
}
