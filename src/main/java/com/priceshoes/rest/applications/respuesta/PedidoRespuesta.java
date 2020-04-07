package com.priceshoes.rest.applications.respuesta;

import com.priceshoes.rest.applications.bean.FormaPagoPedido;
import com.priceshoes.rest.applications.entity.PsPedtmk;
import com.priceshoes.rest.applications.respuesta.Respuesta;

public class PedidoRespuesta extends Respuesta {
	private PsPedtmk psPedtmk;
	private FormaPagoPedido formaPagoPedido = new FormaPagoPedido();
	private Long value;
	private boolean bandera;
	private boolean banderaSaldo;

	public PsPedtmk getPsPedtmk() {
		return this.psPedtmk;
	}

	public void setPsPedtmk(PsPedtmk psPedtmk) {
		this.psPedtmk = psPedtmk;
	}

	public Long getValue() {
		return this.value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public boolean isBandera() {
		return this.bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public FormaPagoPedido getFormaPagoPedido() {
		return this.formaPagoPedido;
	}

	public void setFormaPagoPedido(FormaPagoPedido formaPagoPedido) {
		this.formaPagoPedido = formaPagoPedido;
	}

	public boolean isBanderaSaldo() {
		return this.banderaSaldo;
	}

	public void setBanderaSaldo(boolean banderaSaldo) {
		this.banderaSaldo = banderaSaldo;
	}
}