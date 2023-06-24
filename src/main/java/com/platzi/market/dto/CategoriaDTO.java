package com.platzi.market.dto;

import java.util.Optional;
import java.util.function.Function;

import com.platzi.market.entity.Categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDTO {
	private Integer categoryId;
	private String category;
	private Boolean active;

	public static Function<Categoria, CategoriaDTO> cateDTOFun = cate -> Optional.of(cate)
			.map(c -> new CategoriaDTO(c.getIdCategoria(), c.getDescripcion(), c.getEstado())).get();
	
	public static Function<CategoriaDTO, Categoria> cateFun = cate -> Optional.of(cate)
			.map(c -> new Categoria(c.getCategoryId(), c.getCategory(), c.getActive())).get();
}
