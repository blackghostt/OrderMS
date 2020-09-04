package com.priceshoes.rest.applications.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery
(
	name = "F_GET_ECOMM_SALDOS",
	query = "{ ? = call ppvmx.F_GET_ECOMM_SALDOS@lrcorpprice('041600053753') }",
	callable = true,
	resultClass = SaldosSocio.class
)
public class SaldosSocio 
{
	@Id
	@Column(name = "SO_ID_STR")
	private String soIdStr;
	
	@Column
	private BigDecimal nc;
	
	@Column
	private BigDecimal vales;
	
	@Column
	private BigDecimal cupon;
	
	@Column
	private BigDecimal saldo;
	
	public String getSoIdStr() {
		return soIdStr;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getNc() {
		return nc;
	}

	public void setNc(BigDecimal nc) {
		this.nc = nc;
	}

	public BigDecimal getVales() {
		return vales;
	}

	public void setVales(BigDecimal vales) {
		this.vales = vales;
	}

	public BigDecimal getCupon() {
		return cupon;
	}

	public void setCupon(BigDecimal cupon) {
		this.cupon = cupon;
	}
	
}
