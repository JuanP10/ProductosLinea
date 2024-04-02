package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
    List<Cliente> findByDireccion (String direccion);
    List<Cliente> findByNombreStartingWith(String nombre);

}
