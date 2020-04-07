package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.PsInventarioEcommPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PS_INVENTARIO_ECOMM")
public class PsInventarioEcomm implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private PsInventarioEcommPK id = new PsInventarioEcommPK();
	@Column(name = "CO_CVE_STR")
	private String corrida;
	@Column(name = "INVE_DIASINV_N")
	private Integer diasInv;
	@Column(name = "INVE_EST_STR")
	private String estatus;
	@Column(name = "INVE_EXIST_N")
	private Integer existencias;
	@Temporal(TemporalType.DATE)
	@Column(name = "INVE_FEC_DT")
	private Date fecha;
	@Column(name = "INVE_SUGVTA_N")
	private Double ventaSug;

	public PsInventarioEcommPK getId() {
		return this.id;
	}

	public void setId(PsInventarioEcommPK id) {
		this.id = id;
	}

	public String getCorrida() {
		return this.corrida;
	}

	public void setCorrida(String corrida) {
		this.corrida = corrida;
	}

	public Integer getDiasInv() {
		return this.diasInv;
	}

	public void setDiasInv(Integer diasInv) {
		this.diasInv = diasInv;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getExistencias() {
		return this.existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getVentaSug() {
		return this.ventaSug;
	}

	public void setVentaSug(Double ventaSug) {
		this.ventaSug = ventaSug;
	}
}