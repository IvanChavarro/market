package com.platzi.market.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

	public Producto(Integer idProducto, String nombre, Integer idCategoria, Double precioVenta, Integer cantidadStock,
			Boolean estado, Categoria categoria) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.idCategoria = idCategoria;
		this.precioVenta = precioVenta;
		this.cantidadStock = cantidadStock;
		this.estado = estado;
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer idProducto;

	private String nombre;

	@Column(name = "id_categoria")
	private Integer idCategoria;

	@Column(name = "codigo_barras")
	private String codigoBarras;

	@Column(name = "precio_venta")
	private Double precioVenta;

	@Column(name = "cantidad_stock")
	private Integer cantidadStock;

	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private Categoria categoria;

}
