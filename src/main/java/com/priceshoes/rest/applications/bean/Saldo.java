package com.priceshoes.rest.applications.bean;

public class Saldo {
	protected Double total;
	protected Double saldo;
	protected Double notasCredito;
	protected Double vales;
	protected Double depositos;

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double value) {
		this.total = value;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double value) {
		this.saldo = value;
	}

	public Double getNotasCredito() {
		return this.notasCredito;
	}

	public void setNotasCredito(Double value) {
		this.notasCredito = value;
	}

	public Double getVales() {
		return this.vales;
	}

	public void setVales(Double value) {
		this.vales = value;
	}

	public Double getDepositos() {
		return this.depositos;
	}

	public void setDepositos(Double value) {
		this.depositos = value;
	}
}