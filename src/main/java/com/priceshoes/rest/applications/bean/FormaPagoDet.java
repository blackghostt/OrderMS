package com.priceshoes.rest.applications.bean;

public class FormaPagoDet 
{
	private String 		tipo;
	private String 		key;
	private Double 		monto;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
}
