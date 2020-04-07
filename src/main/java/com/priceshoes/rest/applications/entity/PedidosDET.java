package com.priceshoes.rest.applications.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PS_PEDIDOS_DET")
public class PedidosDET {
	@Id
	@Column(name = "RECD_PEDIDO_N")
	private String recdPedidoN;
	@Column(name = "PED_FCOMP_DT")
	private Date pedFcompDt;
	@Column(name = "ID_ART")
	private String idArt;
	@Column(name = "PED_EST_STR")
	private String pedEstStr;
	@Column(name = "TA_CVE_N_INI")
	private Integer taCveNIni;

	public String getRecdPedidoN() {
		return this.recdPedidoN;
	}

	public void setRecdPedidoN(String recdPedidoN) {
		this.recdPedidoN = recdPedidoN;
	}

	public Date getPedFcompDt() {
		return this.pedFcompDt;
	}

	public void setPedFcompDt(Date pedFcompDt) {
		this.pedFcompDt = pedFcompDt;
	}

	public String getIdArt() {
		return this.idArt;
	}

	public void setIdArt(String idArt) {
		this.idArt = idArt;
	}

	public String getPedEstStr() {
		return this.pedEstStr;
	}

	public void setPedEstStr(String pedEstStr) {
		this.pedEstStr = pedEstStr;
	}

	public Integer getTaCveNIni() {
		return this.taCveNIni;
	}

	public void setTaCveNIni(Integer taCveNIni) {
		this.taCveNIni = taCveNIni;
	}
}