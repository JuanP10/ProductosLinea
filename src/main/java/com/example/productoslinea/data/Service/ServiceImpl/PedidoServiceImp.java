package com.example.productoslinea.data.Service.ServiceImpl;

import com.example.productoslinea.data.Dtos.Save.PedidoDtoSave;
import com.example.productoslinea.data.Dtos.Send.PedidoDtoSend;
import com.example.productoslinea.data.Mappers.PedidoMapper;
import com.example.productoslinea.data.Service.PedidoService;
import com.example.productoslinea.data.entities.Pedido;
import com.example.productoslinea.data.repositories.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImp implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoServiceImp(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }
    @Override
    public List<PedidoDtoSend> findByFechaPedidoBetween(String fechaInicio, String fechaFin) {
        return null;
    }

    @Override
    public List<PedidoDtoSend> findByClienteAndEstado(String cliente, String estado) {
        return null;
    }

    @Override
    public List<PedidoDtoSend> findAll() {
        return null;
    }

    @Override
    public PedidoDtoSend findById(Long id) {
        return null;
    }

    @Override
    public PedidoDtoSend guardarPedido(PedidoDtoSave pedidoDtoSave) {
        return null;
    }

    @Override
    public void deletePedido(Long id) {
        this.deletePedido(id);
    }
}
