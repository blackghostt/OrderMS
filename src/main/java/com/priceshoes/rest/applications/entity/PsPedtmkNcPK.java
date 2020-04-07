package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkNcPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "TI_CVE_N")
	private long tiCveN;
	@Column(name = "NC_SERIE_STR")
	private String ncSerieStr;
	@Column(name = "NC_NUM_N")
	private long ncNumN;
	@Column(name = "PT_NUM_N")
	private long ptNumN;

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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof PsPedtmkNcPK)) {
			return false;
		} else {
			PsPedtmkNcPK castOther = (PsPedtmkNcPK) other;
			return this.tiCveN == castOther.tiCveN && this.ncSerieStr.equals(castOther.ncSerieStr)
					&& this.ncNumN == castOther.ncNumN && this.ptNumN == castOther.ptNumN;
		}
	}

	public int hashCode() {
		boolean prime = true;
		byte hash = 17;
		int hash1 = hash * 31 + (int) (this.tiCveN ^ this.tiCveN >>> 32);
		hash1 = hash1 * 31 + this.ncSerieStr.hashCode();
		hash1 = hash1 * 31 + (int) (this.ncNumN ^ this.ncNumN >>> 32);
		hash1 = hash1 * 31 + (int) (this.ptNumN ^ this.ptNumN >>> 32);
		return hash1;
	}
}