package com.priceshoes.rest.applications.bean;

public class ArticuloLite {
	protected Long idArticuloPs;
	protected Double talla;
	protected Double precio;
	protected String tallaEQ;
	protected String apartado;

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getIdArticuloPs() {
		return this.idArticuloPs;
	}

	public void setIdArticuloPs(Long value) {
		this.idArticuloPs = value;
	}

	public Double getTalla() {
		return this.talla;
	}

	public void setTalla(Double value) {
		this.talla = value;
	}

	public String getTallaEQ() {
		return this.tallaEQ;
	}

	public void setTallaEQ(String value) {
		this.tallaEQ = value;
	}

	public String getApartado() {
		return this.apartado;
	}

	public void setApartado(String value) {
		this.apartado = value;
	}
}