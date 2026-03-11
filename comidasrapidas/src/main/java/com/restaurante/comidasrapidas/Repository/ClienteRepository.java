package com.restaurante.comidasrapidas.Repository;

import com.restaurante.comidasrapidas.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}