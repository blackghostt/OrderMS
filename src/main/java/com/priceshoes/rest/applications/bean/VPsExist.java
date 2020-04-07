package com.priceshoes.rest.applications.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_PS_EXIST")
public class VPsExist implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long boCveN;
	private Integer exCantN;
	private Long idArt;
	private Long secuencia;
	private Double taCveN;
	private Integer tiCveN;

	@Column(name = "BO_CVE_N")
	public Long getBoCveN() {
		return this.boCveN;
	}

	public void setBoCveN(Long boCveN) {
		this.boCveN = boCveN;
	}

	@Column(name = "EX_CANT_N")
	public Integer getExCantN() {
		return this.exCantN;
	}

	public void setExCantN(Integer exCantN) {
		this.exCantN = exCantN;
	}

	@Column(name = "ID_ART")
	public Long getIdArt() {
		return this.idArt;
	}

	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}

	@Id
	public Long getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(Long secuencia) {
		this.secuencia = secuencia;
	}

	@Column(name = "TA_CVE_N")
	public Double getTaCveN() {
		return this.taCveN;
	}

	public void setTaCveN(Double taCveN) {
		this.taCveN = taCveN;
	}

	@Column(name = "TI_CVE_N")
	public Integer getTiCveN() {
		return this.tiCveN;
	}

	public void setTiCveN(Integer tiCveN) {
		this.tiCveN = tiCveN;
	}
}