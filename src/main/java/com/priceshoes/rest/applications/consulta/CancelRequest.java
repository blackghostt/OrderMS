package com.priceshoes.rest.applications.consulta;

public class CancelRequest 
{
	private Long	sucursal;
	private Long	pedido;
	
	public Long getSucursal() {
		return sucursal;
	}
	public void setSucursal(Long sucursal) {
		this.sucursal = sucursal;
	}
	public Long getPedido() {
		return pedido;
	}
	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}
	
	
}
