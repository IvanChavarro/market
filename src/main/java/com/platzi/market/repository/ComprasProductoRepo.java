package com.platzi.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.platzi.market.entity.ComprasProducto;

public interface ComprasProductoRepo extends JpaRepository<ComprasProducto, Integer> {

	@Query(value = "SELECT p from ComprasProducto p " + "where p.compra.idCompra = :idCompra ")
	List<ComprasProducto> findByIdCompra(Integer idCompra);
}
