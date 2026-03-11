package com.restaurante.comidasrapidas.Repository;

import com.restaurante.comidasrapidas.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}