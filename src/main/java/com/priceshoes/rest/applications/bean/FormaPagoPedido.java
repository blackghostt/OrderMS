package com.priceshoes.rest.applications.bean;

public class FormaPagoPedido {
	protected String formaPago;
	protected Double cantidad;
	protected String referencia;

	public String getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(String value) {
		this.formaPago = value;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Double value) {
		this.cantidad = value;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String value) {
		this.referencia = value;
	}
}