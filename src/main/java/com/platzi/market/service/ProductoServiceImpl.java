package com.platzi.market.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platzi.market.dto.CategoriaDTO;
import com.platzi.market.dto.ProductoDTO;
import com.platzi.market.entity.Producto;
import com.platzi.market.repository.CategoryRepository;
import com.platzi.market.repository.ProductoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository prodRepo;
	@Autowired
	private CategoryRepository cateRepo;

	@Override
	public List<ProductoDTO> getAll() {
		log.info("Starting getAll at " + new Date());
		return prodRepo.findAll().stream().map(p -> ProductoDTO.productDTOFun.apply(p)).collect(Collectors.toList());
	}

	@Override
	public Optional<List<ProductoDTO>> getByCategory(int categoryId) {
		log.info("Starting getByCategory at " + new Date());
		return Optional.of(prodRepo.findByIdCategoriaOrderByNombreAsc(categoryId).stream()
				.map(p -> ProductoDTO.productDTOFun.apply(p)).collect(Collectors.toList()));
	}

	@Override
	public Optional<List<ProductoDTO>> getScarseProductoDTOs(int quantity) {
		log.info("Starting getScarseProductoDTOs at " + new Date());
		Optional<List<Producto>> products = prodRepo.findByCantidadStockLessThanAndEstado(quantity, true);
		return Optional.of(products.isPresent()
				? products.get().stream().map(p -> ProductoDTO.productDTOFun.apply(p)).collect(Collectors.toList())
				: new ArrayList<>());
	}

	@Override
	public Optional<ProductoDTO> getProductoDTO(int ProductoDTOId) {
		log.info("Starting getProductoDTO at " + new Date());
		Optional<Producto> prod = prodRepo.findById(ProductoDTOId);
		return prod.isPresent() ? Optional.of(ProductoDTO.productDTOFun.apply(prod.get())) : null;
	}

	@Override
	public ProductoDTO save(ProductoDTO ProductoDTO) {
		log.info("Starting save at " + new Date());
		ProductoDTO.setCategory(CategoriaDTO.cateDTOFun.apply(cateRepo.findById(ProductoDTO.getCategoryId()).get()));
		return ProductoDTO.productDTOFun.apply(prodRepo.save(ProductoDTO.productFun.apply(ProductoDTO)));
	}

	@Override
	public Boolean delete(int ProductoDTOId) {
		log.info("Starting delete at " + new Date());
		return getProductoDTO(ProductoDTOId).map(p -> {
			prodRepo.delete(ProductoDTO.productFun.apply(p));
			return true;
		}).orElse(false);

	}

}
