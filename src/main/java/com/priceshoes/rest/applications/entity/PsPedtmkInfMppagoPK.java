package com.priceshoes.rest.applications.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkInfMppagoPK implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="TI_CVE_N")	private Integer tiCveN;
	@Column(name="PT_NUM_N")	private Long	ptNumN;
	@Column(name="FPE_CVE_STR")	private String	fpeCveStr;
	
	public PsPedtmkInfMppagoPK(Long ptNumN, Integer tiCveN,String fpeCveStr) 
	{
		this.ptNumN = ptNumN;
		this.tiCveN = tiCveN;
		this.fpeCveStr = fpeCveStr;
	}

	public Integer getTiCveN() {
		return tiCveN;
	}

	public void setTiCveN(Integer tiCveN) {
		this.tiCveN = tiCveN;
	}

	public Long getPtNumN() {
		return ptNumN;
	}

	public void setPtNumN(Long ptNumN) {
		this.ptNumN = ptNumN;
	}

	public String getFpeCveStr() {
		return fpeCveStr;
	}

	public void setFpeCveStr(String fpeCveStr) {
		this.fpeCveStr = fpeCveStr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fpeCveStr == null) ? 0 : fpeCveStr.hashCode());
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
		PsPedtmkInfMppagoPK other = (PsPedtmkInfMppagoPK) obj;
		if (fpeCveStr == null) {
			if (other.fpeCveStr != null)
				return false;
		} else if (!fpeCveStr.equals(other.fpeCveStr))
			return false;
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
