package com.priceshoes.applications.respuesta;


import com.priceshoes.rest.applications.bean.FormaPagoPedido;
import com.priceshoes.rest.applications.entity.PsPedtmk;

public class PedidoRespuesta extends Respuesta
{

	private PsPedtmk 		psPedtmk;
	private FormaPagoPedido formaPagoPedido;
	private Long 			value;
	private boolean 		bandera;
	private boolean 		banderaSaldo;
	
	
	public PedidoRespuesta()
	{
		this.formaPagoPedido = new FormaPagoPedido();
	}
	
	public PsPedtmk getPsPedtmk() {
		return psPedtmk;
	}
	
	public void setPsPedtmk(PsPedtmk psPedtmk) {
		this.psPedtmk = psPedtmk;
	}
	
	public Long getValue() {
		return value;
	}
	
	public void setValue(Long value) {
		this.value = value;
	}
	
	public boolean isBandera() {
		return bandera;
	}
	
	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public FormaPagoPedido getFormaPagoPedido() {
		return formaPagoPedido;
	}

	public void setFormaPagoPedido(FormaPagoPedido formaPagoPedido) {
		this.formaPagoPedido = formaPagoPedido;
	}
	public boolean isBanderaSaldo() {
		return banderaSaldo;
	}
	public void setBanderaSaldo(boolean banderaSaldo) {
		this.banderaSaldo = banderaSaldo;
	}
}
