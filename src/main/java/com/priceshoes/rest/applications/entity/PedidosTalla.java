package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PS_PEDIDOS_TALLA")
public class PedidosTalla implements Serializable {
	private static final long serialVersionUID = 7917052377452460888L;
	@Id
	@Column(name = "RECD_PEDIDO_N")
	private String recdPedidoN;
	@Column(name = "TA_CVE_N")
	private Integer taCveN;
	@Column(name = "TA_CVE_N_INI")
	private Integer taCveNIni;
	@Column(name = "ID_ART")
	private String idArt;

	public String getRecdPedidoN() {
		return this.recdPedidoN;
	}

	public void setRecdPedidoN(String recdPedidoN) {
		this.recdPedidoN = recdPedidoN;
	}

	public Integer getTaCveN() {
		return this.taCveN;
	}

	public void setTaCveN(Integer taCveN) {
		this.taCveN = taCveN;
	}

	public Integer getTaCveNIni() {
		return this.taCveNIni;
	}

	public void setTaCveNIni(Integer taCveNIni) {
		this.taCveNIni = taCveNIni;
	}

	public String getIdArt() {
		return this.idArt;
	}

	public void setIdArt(String idArt) {
		this.idArt = idArt;
	}
}