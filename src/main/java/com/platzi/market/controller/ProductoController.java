package com.platzi.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ProductoDTO>> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProductoDTO>> getProduct(@PathVariable("id") int productId) {
		return ResponseEntity.ok(productService.getProductoDTO(productId));
	}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Optional<List<ProductoDTO>>> getByCategory(@PathVariable("categoryId") int categoryId) {
		return ResponseEntity.ok(productService.getByCategory(categoryId));
	}

	@PostMapping("/save")
	public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") int productId) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.delete(productId));
	}

}
