package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PS_FPAGO_ECOMM")
public class PsFPagoEcomm implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "FPE_CVE_STR")
	private String fpeCveStr;
	@Column(name = "FPE_DESC_STR")
	private String fpeDescStr;
	@Column(name = "FPE_EST_STR")
	private String fpeEstStr;
	@Column(name = "BA_CVE_N")
	private Long baCveN;
	@Column(name = "FPE_TIPO_STR")
	private String fpeTipoStr;

	public String getFpeCveStr() {
		return this.fpeCveStr;
	}

	public void setFpeCveStr(String fpeCveStr) {
		this.fpeCveStr = fpeCveStr;
	}

	public String getFpeDescStr() {
		return this.fpeDescStr;
	}

	public void setFpeDescStr(String fpeDescStr) {
		this.fpeDescStr = fpeDescStr;
	}

	public String getFpeEstStr() {
		return this.fpeEstStr;
	}

	public void setFpeEstStr(String fpeEstStr) {
		this.fpeEstStr = fpeEstStr;
	}

	public Long getBaCveN() {
		return this.baCveN;
	}

	public void setBaCveN(Long baCveN) {
		this.baCveN = baCveN;
	}

	public String getFpeTipoStr() {
		return this.fpeTipoStr;
	}

	public void setFpeTipoStr(String fpeTipoStr) {
		this.fpeTipoStr = fpeTipoStr;
	}
}