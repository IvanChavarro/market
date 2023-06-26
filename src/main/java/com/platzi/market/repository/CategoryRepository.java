package com.platzi.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.market.entity.Categoria;

public interface CategoryRepository extends JpaRepository<Categoria, Integer> {

}
