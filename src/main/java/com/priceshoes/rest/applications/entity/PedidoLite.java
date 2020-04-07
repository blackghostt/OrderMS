package com.priceshoes.rest.applications.entity;

public class PedidoLite {
	protected Long pedidoIdPs;
	protected String guia;
	protected String estatus;
	protected String referencia;

	public Long getPedidoIdPs() {
		return this.pedidoIdPs;
	}

	public void setPedidoIdPs(Long value) {
		this.pedidoIdPs = value;
	}

	public String getGuia() {
		return this.guia;
	}

	public void setGuia(String value) {
		this.guia = value;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String value) {
		this.estatus = value;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String value) {
		this.referencia = value;
	}
}