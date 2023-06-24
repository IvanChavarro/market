package com.platzi.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.market.dto.ProductoDTO;
import com.platzi.market.service.ProductoService;

@RestController
@RequestMapping("/products")
public class ProductoController {

	@Autowired
	private ProductoService productService;

	@GetMapping("/all")
	public List<ProductoDTO> getAll() {
		return productService.getAll();
	}

	@GetMapping("/{id}")
	public Optional<ProductoDTO> getProduct(@PathVariable("id") int productId) {
		return productService.getProductoDTO(productId);
	}

	@GetMapping("/category/{categoryId}")
	public Optional<List<ProductoDTO>> getByCategory(@PathVariable("categoryId") int categoryId) {
		return productService.getByCategory(categoryId);
	}

	@PostMapping("/save")
	public ProductoDTO save(@RequestBody ProductoDTO product) {
		return productService.save(product);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") int productId) {
		return productService.delete(productId);
	}

}
