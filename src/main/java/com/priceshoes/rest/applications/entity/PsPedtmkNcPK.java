package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkNcPK implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "TI_CVE_N")		private long tiCveN;
	@Column(name = "NC_SERIE_STR")	private String ncSerieStr;
	@Column(name = "NC_NUM_N")		private long ncNumN;
	@Column(name = "PT_NUM_N")		private long ptNumN;

	public long getTiCveN() {
		return this.tiCveN;
	}

	public void setTiCveN(long tiCveN) {
		this.tiCveN = tiCveN;
	}

	public String getNcSerieStr() {
		return this.ncSerieStr;
	}

	public void setNcSerieStr(String ncSerieStr) {
		this.ncSerieStr = ncSerieStr;
	}

	public long getNcNumN() {
		return this.ncNumN;
	}

	public void setNcNumN(long ncNumN) {
		this.ncNumN = ncNumN;
	}

	public long getPtNumN() {
		return this.ptNumN;
	}

	public void setPtNumN(long ptNumN) {
		this.ptNumN = ptNumN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ncNumN ^ (ncNumN >>> 32));
		result = prime * result + ((ncSerieStr == null) ? 0 : ncSerieStr.hashCode());
		result = prime * result + (int) (ptNumN ^ (ptNumN >>> 32));
		result = prime * result + (int) (tiCveN ^ (tiCveN >>> 32));
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
		PsPedtmkNcPK other = (PsPedtmkNcPK) obj;
		if (ncNumN != other.ncNumN)
			return false;
		if (ncSerieStr == null) {
			if (other.ncSerieStr != null)
				return false;
		} else if (!ncSerieStr.equals(other.ncSerieStr))
			return false;
		if (ptNumN != other.ptNumN)
			return false;
		if (tiCveN != other.tiCveN)
			return false;
		return true;
	}

	
}