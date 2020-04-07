package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkDepPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "TI_CVE_N")
	private long tiCveN;
	@Column(name = "PT_NUM_N")
	private long ptNumN;
	@Column(name = "DEP_NUM_N")
	private long depNumN;

	public long getTiCveN() {
		return this.tiCveN;
	}

	public void setTiCveN(long tiCveN) {
		this.tiCveN = tiCveN;
	}

	public long getPtNumN() {
		return this.ptNumN;
	}

	public void setPtNumN(long ptNumN) {
		this.ptNumN = ptNumN;
	}

	public long getDepNumN() {
		return this.depNumN;
	}

	public void setDepNumN(long depNumN) {
		this.depNumN = depNumN;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof PsPedtmkDepPK)) {
			return false;
		} else {
			PsPedtmkDepPK castOther = (PsPedtmkDepPK) other;
			return this.tiCveN == castOther.tiCveN && this.ptNumN == castOther.ptNumN
					&& this.depNumN == castOther.depNumN;
		}
	}

	public int hashCode() {
		boolean prime = true;
		byte hash = 17;
		int hash1 = hash * 31 + (int) (this.tiCveN ^ this.tiCveN >>> 32);
		hash1 = hash1 * 31 + (int) (this.ptNumN ^ this.ptNumN >>> 32);
		hash1 = hash1 * 31 + (int) (this.depNumN ^ this.depNumN >>> 32);
		return hash1;
	}
}