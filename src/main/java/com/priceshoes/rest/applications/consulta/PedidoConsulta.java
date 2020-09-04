package com.priceshoes.rest.applications.consulta;

import com.priceshoes.rest.applications.bean.FormaPagoPedido;
import com.priceshoes.rest.applications.bean.Pedido;
import com.priceshoes.rest.applications.bean.PedidoLite;

public class PedidoConsulta {
	private PedidoLite 		pedidoLite;
	private boolean 		agregarGuia = false;
	private boolean 		actualizarEstatus = false;
	private Pedido 			pedido;
	private FormaPagoPedido formaPagoPedido;
	
	public PedidoLite getPedidoLite() {
		return this.pedidoLite;
	}

	public void setPedidoLite(PedidoLite pedidoLite) {
		this.pedidoLite = pedidoLite;
	}

	public boolean isAgregarGuia() {
		return this.agregarGuia;
	}

	public void setAgregarGuia(boolean agregarGuia) {
		this.agregarGuia = agregarGuia;
	}

	public boolean isActualizarEstatus() {
		return this.actualizarEstatus;
	}

	public void setActualizarEstatus(boolean actualizarEstatus) {
		this.actualizarEstatus = actualizarEstatus;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public FormaPagoPedido getFormaPagoPedido() {
		return this.formaPagoPedido;
	}

	public void setFormaPagoPedido(FormaPagoPedido formaPagoPedido) {
		this.formaPagoPedido = formaPagoPedido;
	}

}