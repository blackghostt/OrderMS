package com.priceshoes.rest.applications.entity;

import java.math.BigDecimal;

public class MemberBalance {
	private BigDecimal NC;
	private BigDecimal vales;
	private BigDecimal depositos;
	private BigDecimal saldo;

	public BigDecimal getNC() {
		return this.NC;
	}

	public void setNC(BigDecimal nC) {
		this.NC = nC;
	}

	public BigDecimal getVales() {
		return this.vales;
	}

	public void setVales(BigDecimal vales) {
		this.vales = vales;
	}

	public BigDecimal getDepositos() {
		return this.depositos;
	}

	public void setDepositos(BigDecimal depositos) {
		this.depositos = depositos;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
}