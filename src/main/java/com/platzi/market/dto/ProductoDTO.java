package com.platzi.market.dto;

import java.util.Optional;
import java.util.function.Function;

import com.platzi.market.entity.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
	private Integer productId;
	private String name;
	private Integer categoryId;
	private Double price;
	private Integer stock;
	private Boolean active;
	private CategoriaDTO category;

	public static Function<Producto, ProductoDTO> productDTOFun = prod -> Optional.of(prod)
			.map(p -> new ProductoDTO(p.getIdProducto(), p.getNombre(), p.getIdCategoria(), p.getPrecioVenta(),
					p.getCantidadStock(), p.getEstado(), CategoriaDTO.cateDTOFun.apply(p.getCategoria())))
			.get();

	public static Function<ProductoDTO, Producto> productFun = prod -> Optional.of(prod)
			.map(p -> new Producto(p.getProductId(), p.getName(), p.getCategoryId(), p.getPrice(), p.getStock(),
					p.getActive(), CategoriaDTO.cateFun.apply(p.getCategory())))
			.get();
}
