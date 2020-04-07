package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkDetPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long tiCveN;
	private Long ptNumN;
	private Long ptdNumN;

	@Column(name = "TI_CVE_N")
	public Long getTiCveN() {
		return this.tiCveN;
	}

	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}

	@Column(name = "PT_NUM_N")
	public Long getPtNumN() {
		return this.ptNumN;
	}

	public void setPtNumN(Long ptNumN) {
		this.ptNumN = ptNumN;
	}

	@Column(name = "PTD_NUM_N")
	public Long getPtdNumN() {
		return this.ptdNumN;
	}

	public void setPtdNumN(Long ptdNumN) {
		this.ptdNumN = ptdNumN;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof PsPedtmkDetPK)) {
			return false;
		} else {
			PsPedtmkDetPK castOther = (PsPedtmkDetPK) other;
			return this.tiCveN == castOther.tiCveN && this.ptNumN == castOther.ptNumN
					&& this.ptdNumN == castOther.ptdNumN;
		}
	}

	public int hashCode() {
		boolean prime = true;
		byte hash = 17;
		int hash1 = hash * 31 + (int) (this.tiCveN.longValue() ^ this.tiCveN.longValue() >>> 32);
		hash1 = hash1 * 31 + (int) (this.ptNumN.longValue() ^ this.ptNumN.longValue() >>> 32);
		hash1 = hash1 * 31 + (int) (this.ptdNumN.longValue() ^ this.ptdNumN.longValue() >>> 32);
		return hash1;
	}
}