package com.platzi.market.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.market.entity.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
	public List<Compra> findByIdCliente(String idCliente);
}
