package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.ArticuloPedidoCollection;
import com.priceshoes.rest.applications.bean.Direccion;
import com.priceshoes.rest.applications.bean.FormasPagoPedidoCollection;

public class Pedido {
	protected String socioIdPs;
	protected Direccion direccionEnvio;
	protected Direccion direccionPago;
	protected String tipoPedido;
	protected Double importeTotal;
	protected Double gastosEnvio;
	protected Double seguroMensajeria;
	protected Double descuentoPedido;
	protected ArticuloPedidoCollection items;
	protected FormasPagoPedidoCollection formasPagos;
	protected String formaPedido;
	protected String pedidoMagento;

	public String getSocioIdPs() {
		return this.socioIdPs;
	}

	public void setSocioIdPs(String value) {
		this.socioIdPs = value;
	}

	public Direccion getDireccionEnvio() {
		return this.direccionEnvio;
	}

	public void setDireccionEnvio(Direccion value) {
		this.direccionEnvio = value;
	}

	public Direccion getDireccionPago() {
		return this.direccionPago;
	}

	public void setDireccionPago(Direccion value) {
		this.direccionPago = value;
	}

	public Double getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(Double value) {
		this.importeTotal = value;
	}

	public Double getGastosEnvio() {
		return this.gastosEnvio;
	}

	public void setGastosEnvio(Double value) {
		this.gastosEnvio = value;
	}

	public Double getSeguroMensajeria() {
		return this.seguroMensajeria;
	}

	public void setSeguroMensajeria(Double value) {
		this.seguroMensajeria = value;
	}

	public Double getDescuentoPedido() {
		return this.descuentoPedido;
	}

	public void setDescuentoPedido(Double value) {
		this.descuentoPedido = value;
	}

	public ArticuloPedidoCollection getItems() {
		return this.items;
	}

	public void setItems(ArticuloPedidoCollection value) {
		this.items = value;
	}

	public FormasPagoPedidoCollection getFormasPagos() {
		return this.formasPagos;
	}

	public void setFormasPagos(FormasPagoPedidoCollection formasPagos) {
		this.formasPagos = formasPagos;
	}

	public String getFormaPedido() {
		return this.formaPedido;
	}

	public void setFormaPedido(String value) {
		this.formaPedido = value;
	}

	public String getTipoPedido() {
		return this.tipoPedido;
	}

	public void setTipoPedido(String value) {
		this.tipoPedido = value;
	}

	public String getPedidoMagento() {
		return this.pedidoMagento;
	}

	public void setPedidoMagento(String value) {
		this.pedidoMagento = value;
	}
}