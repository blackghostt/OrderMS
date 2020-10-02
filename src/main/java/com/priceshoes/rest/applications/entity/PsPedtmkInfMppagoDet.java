package com.priceshoes.rest.applications.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.priceshoes.rest.applications.bean.FormaPagoDet;

@Entity
@Table(name="PPVMX.PS_PEDTMK_INF_MPPAGO_DET")
public class PsPedtmkInfMppagoDet 
{
	@EmbeddedId						private PsPedtmkInfMppagoDetPK id;
	@Column(name="SALD_MONTO_N")	private Double 					saldMontoN;
	@Column(name="SALD_EST_STR")	private String 					saldEstStr;
	
	public PsPedtmkInfMppagoDet(PsPedtmkInfMppagoPK pagoPK,FormaPagoDet det)
	{
		this.id = new PsPedtmkInfMppagoDetPK(pagoPK,det.getTipo(),det.getKey());
		this.saldMontoN = det.getMonto();
		this.saldEstStr  = "S".equalsIgnoreCase(det.getTipo()) ? "P" : null; 
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
	
}
