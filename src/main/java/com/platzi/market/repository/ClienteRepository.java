package com.platzi.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.market.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Cliente findById(String id);
}
