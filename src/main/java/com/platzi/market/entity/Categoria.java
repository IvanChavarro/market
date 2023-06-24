package com.platzi.market.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {

	public Categoria(Integer idCategoria, String descripcion, Boolean estado) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idCategoria;

	private String descripcion;
	private Boolean estado;

	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;

}
