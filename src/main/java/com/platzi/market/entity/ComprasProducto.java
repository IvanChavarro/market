package com.platzi.market.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compras_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComprasProducto {
	@EmbeddedId
	private ComprasProductoPK id;

	private Integer cantidad;
	private Double total;
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_compra", insertable = false, updatable = false)
	private Compra compra;

	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private Producto producto;

	
}
