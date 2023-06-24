package com.platzi.market.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.market.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
