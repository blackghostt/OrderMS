package com.priceshoes.rest.applications.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PsPedtmkInfMppagoDetInfo 
{
	@EmbeddedId						private PsPedtmkInfMppagoDetPK id;
	@Column(name="SALD_MONTO_N")	private Double 					saldMontoN;
	@Column(name="SALD_EST_STR")	private String 					saldEstStr;
	@Column(name="SO_ID_STR")		private String 					soIdStr;
	
	public PsPedtmkInfMppagoDetInfo()
	{
		this.id = new PsPedtmkInfMppagoDetPK();
	}
	public PsPedtmkInfMppagoDetPK getId() {
		return id;
	}
	public void setId(PsPedtmkInfMppagoDetPK id) {
		this.id = id;
	}
	public Double getSaldMontoN() {
		return saldMontoN;
	}
	public void setSaldMontoN(Double saldMontoN) {
		this.saldMontoN = saldMontoN;
	}
	public String getSaldEstStr() {
		return saldEstStr;
	}
	public void setSaldEstStr(String saldEstStr) {
		this.saldEstStr = saldEstStr;
	}
	public String getSoIdStr() {
		return soIdStr;
	}
	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}
}
