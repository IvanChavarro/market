package com.platzi.market.service;

import java.util.List;
import java.util.Optional;

import com.platzi.market.dto.ProductoDTO;

public interface ProductoService {
	List<ProductoDTO> getAll();

	Optional<List<ProductoDTO>> getByCategory(int categoryId);

	Optional<List<ProductoDTO>> getScarseProductoDTOs(int quantity);

	Optional<ProductoDTO> getProductoDTO(int ProductoDTOId);

	ProductoDTO save(ProductoDTO ProductoDTO);

	Boolean delete(int ProductoDTOId);
}
