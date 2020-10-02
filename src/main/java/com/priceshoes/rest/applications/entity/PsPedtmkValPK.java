package com.priceshoes.rest.applications.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkValPK implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="VA_NUM_N")	private Long vaNumN;
	@Column(name="TI_CVE_N")	private Long tiCveN;
	@Column(name="PT_NUM_N")	private Long ptNumN;
	
	public Long getVaNumN() {
		return vaNumN;
	}
	public void setVaNumN(Long vaNumN) {
		this.vaNumN = vaNumN;
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
		PsPedtmkValPK other = (PsPedtmkValPK) obj;
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
