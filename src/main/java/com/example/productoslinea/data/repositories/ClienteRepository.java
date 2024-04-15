package com.example.productoslinea.data.repositories;

import com.example.productoslinea.data.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
    List<Cliente> findByDireccion (String direccion);

    //Encontrar clientes por todos los clientes que comiencen por un nombre
    List<Cliente> findByNombreStartingWith (String nombre);  //

}
