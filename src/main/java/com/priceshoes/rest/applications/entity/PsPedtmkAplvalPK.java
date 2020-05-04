package com.priceshoes.rest.applications.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class PsPedtmkAplvalPK implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="TI_CVE_N")	private Long tiCveN;
	@Column(name="PT_NUM_N") 	private Long ptNumN;
	@Column(name="VA_NUM_N") 	private Long vaNumN;
	public PsPedtmkAplvalPK(Long pedido, Long sucursal, long vale) 
	{
		this.tiCveN = sucursal;
		this.ptNumN = pedido;
		this.vaNumN = vale;
	}
	public Long getTiCveN() {
		return tiCveN;
	}
	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}
	public Long getPtNumN() {
		return ptNumN;
	}
	public void setPtNumN(Long ptNumN) {
		this.ptNumN = ptNumN;
	}
	public Long getVaNumN() {
		return vaNumN;
	}
	public void setVaNumN(Long vaNumN) {
		this.vaNumN = vaNumN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ptNumN == null) ? 0 : ptNumN.hashCode());
		result = prime * result + ((tiCveN == null) ? 0 : tiCveN.hashCode());
		result = prime * result + ((vaNumN == null) ? 0 : vaNumN.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PsPedtmkAplvalPK other = (PsPedtmkAplvalPK) obj;
		if (ptNumN == null) {
			if (other.ptNumN != null)
				return false;
		} else if (!ptNumN.equals(other.ptNumN))
			return false;
		if (tiCveN == null) {
			if (other.tiCveN != null)
				return false;
		} else if (!tiCveN.equals(other.tiCveN))
			return false;
		if (vaNumN == null) {
			if (other.vaNumN != null)
				return false;
		} else if (!vaNumN.equals(other.vaNumN))
			return false;
		return true;
	}
	
	
}
