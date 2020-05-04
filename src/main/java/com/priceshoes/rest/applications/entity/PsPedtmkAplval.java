package com.priceshoes.rest.applications.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PS_PEDTMK_APLVAL")
public class PsPedtmkAplval implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PsPedtmkAplvalPK id;
	
	@Column(name="PTAV_ORD_N")
	private Integer ptavOrdN;
	
	public PsPedtmkAplval(Long pedido, Long sucursal, long vale, int orden) 
	{
		this.id = new PsPedtmkAplvalPK(pedido,sucursal,vale);
		this.ptavOrdN = orden;
	}
	public PsPedtmkAplvalPK getId() {
		return id;
	}
	public void setId(PsPedtmkAplvalPK id) {
		this.id = id;
	}
	public Integer getPtavOrdN() {
		return ptavOrdN;
	}
	public void setPtavOrdN(Integer ptavOrdN) {
		this.ptavOrdN = ptavOrdN;
	}
	
}
