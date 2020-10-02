package com.priceshoes.rest.applications.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PS_PEDTMK_VAL")
public class PsPedtmkVal 
{
	@EmbeddedId						private PsPedtmkValPK 	id;
	@Column(name="PTVA_EST_STR") 	private String 			ptvaEstStr;
	@Column(name="PS_TI_CVE_N") 	private Long 			psTiCveN;
	
	public PsPedtmkVal()
	{
		this.id = new PsPedtmkValPK();
	}
	
	public PsPedtmkValPK getId() {
		return id;
	}
	public void setId(PsPedtmkValPK id) {
		this.id = id;
	}
	public String getPtvaEstStr() {
		return ptvaEstStr;
	}
	public void setPtvaEstStr(String ptvaEstStr) {
		this.ptvaEstStr = ptvaEstStr;
	}
	public Long getPsTiCveN() {
		return psTiCveN;
	}
	public void setPsTiCveN(Long psTiCveN) {
		this.psTiCveN = psTiCveN;
	}
	
	
}
