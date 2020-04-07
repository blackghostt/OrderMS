package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.PsPedtmkNcPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PS_PEDTMK_NC")
public class PsPedtmkNc implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private PsPedtmkNcPK id;
	@Column(name = "PS_TI_CVE_N")
	private Long psTiCveN;
	@Column(name = "PTNC_EST_STR")
	private String ptncEstStr;

	public PsPedtmkNcPK getId() {
		return this.id;
	}

	public void setId(PsPedtmkNcPK id) {
		this.id = id;
	}

	public Long getPsTiCveN() {
		return this.psTiCveN;
	}

	public void setPsTiCveN(Long psTiCveN) {
		this.psTiCveN = psTiCveN;
	}

	public String getPtncEstStr() {
		return this.ptncEstStr;
	}

	public void setPtncEstStr(String ptncEstStr) {
		this.ptncEstStr = ptncEstStr;
	}
}