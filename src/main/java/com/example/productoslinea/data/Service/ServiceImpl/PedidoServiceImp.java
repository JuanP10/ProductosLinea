package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Send.PedidoDtoSend;
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
    public List<PedidoDtoSend> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Pedido> pedidos = pedidoRepository.findByFechaPedidoBetween(fechaInicio, fechaFin);
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDtoSend).toList();
    }

    @Override
    public List<PedidoDtoSend> findByClienteAndEstado(Long clienteId, String estado) {
        List<Pedido> pedidos = pedidoRepository.findByClienteWithEstado(clienteId, Estado.valueOf(estado));
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDtoSend).toList();
    }

    @Override
    public List<PedidoDtoSend> recuperarPedidosConArticulosPorCliente(Long clienteId) {
        List<Pedido> pedidos = pedidoRepository.recuperarPedidosConArticulosPorCliente(clienteId);
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDtoSend).toList();
    }

    @Override
    public List<PedidoDtoSend> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedidoMapper::pedidoToPedidoDtoSend).toList();

    }

    @Override
    public PedidoDtoSend findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado" + id));
        return pedidoMapper.pedidoToPedidoDtoSend(pedido);
    }

    @Override
    public PedidoDtoSend guardarPedido(PedidoDtoSend pedidoDtoSend) {
        Pedido pedido = pedidoMapper.pedidoDtoSendToPedido(pedidoDtoSend);
        return pedidoMapper.pedidoToPedidoDtoSend(pedidoRepository.save(pedido));
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
