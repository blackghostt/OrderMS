package com.priceshoes.rest.applications.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkVinPK implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="PT_NUM_N") 	private Long ptNumN;
	@Column(name="TI_CVE_N")	private Long tiCveN;
	
	public Long getPtNumN() {
		return ptNumN;
	}
	public void setPtNumN(Long ptNumN) {
		this.ptNumN = ptNumN;
	}
	public Long getTiCveN() {
		return tiCveN;
	}
	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ptNumN == null) ? 0 : ptNumN.hashCode());
		result = prime * result + ((tiCveN == null) ? 0 : tiCveN.hashCode());
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
		PsPedtmkVinPK other = (PsPedtmkVinPK) obj;
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
		return true;
	}
	
	
}
