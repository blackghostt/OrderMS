package com.priceshoes.applications.consulta;

import com.priceshoes.rest.applications.bean.FormaPagoPedido;
import com.priceshoes.rest.applications.bean.Pedido;
import com.priceshoes.rest.applications.bean.PedidoLite;

public class PedidoConsulta 
{

	private PedidoLite 		pedidoLite;
	private boolean 		agregarGuia = false;
	private boolean 		actualizarEstatus = false;
	private Pedido			pedido;
	private FormaPagoPedido formaPagoPedido;
	
	public PedidoLite getPedidoLite() {
		return pedidoLite;
	}
	public void setPedidoLite(PedidoLite pedidoLite) {
		this.pedidoLite = pedidoLite;
	}
	public boolean isAgregarGuia() {
		return agregarGuia;
	}
	public void setAgregarGuia(boolean agregarGuia) {
		this.agregarGuia = agregarGuia;
	}
	public boolean isActualizarEstatus() {
		return actualizarEstatus;
	}
	public void setActualizarEstatus(boolean actualizarEstatus) {
		this.actualizarEstatus = actualizarEstatus;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public FormaPagoPedido getFormaPagoPedido() {
		return formaPagoPedido;
	}
	public void setFormaPagoPedido(FormaPagoPedido formaPagoPedido) {
		this.formaPagoPedido = formaPagoPedido;
	}
	
	
}
