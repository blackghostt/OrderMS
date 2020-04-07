package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.ArticuloLite;

public class ArticuloPedido {
	protected ArticuloLite articulo;
	protected Integer cantidad;
	protected Double descuento;

	public ArticuloLite getArticulo() {
		return this.articulo;
	}

	public void setArticulo(ArticuloLite value) {
		this.articulo = value;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer value) {
		this.cantidad = value;
	}

	public Double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Double value) {
		this.descuento = value;
	}
}