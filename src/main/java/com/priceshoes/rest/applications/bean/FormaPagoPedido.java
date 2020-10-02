package com.priceshoes.rest.applications.bean;

import java.util.List;

public class FormaPagoPedido 
{
	protected String formaPago;
	protected Double cantidad;
	protected String referencia;
	protected String typeId;
	protected String status;
	protected Double paidAmount;
	protected List<FormaPagoDet> detalle;
	
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public List<FormaPagoDet> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<FormaPagoDet> detalle) {
		this.detalle = detalle;
	}
	
}