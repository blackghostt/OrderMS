package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsDepositoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private long tiCveN;
	private long depNumN;

	@Column(name = "TI_CVE_N", unique = true, nullable = false, precision = 3)
	public long getTiCveN() {
		return this.tiCveN;
	}

	public void setTiCveN(long tiCveN) {
		this.tiCveN = tiCveN;
	}

	@Column(name = "DEP_NUM_N", unique = true, nullable = false, precision = 15)
	public long getDepNumN() {
		return this.depNumN;
	}

	public void setDepNumN(long depNumN) {
		this.depNumN = depNumN;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof PsDepositoPK)) {
			return false;
		} else {
			PsDepositoPK castOther = (PsDepositoPK) other;
			return this.tiCveN == castOther.tiCveN && this.depNumN == castOther.depNumN;
		}
	}

	public int hashCode() {
		boolean prime = true;
		byte hash = 17;
		int hash1 = hash * 31 + (int) (this.tiCveN ^ this.tiCveN >>> 32);
		hash1 = hash1 * 31 + (int) (this.depNumN ^ this.depNumN >>> 32);
		return hash1;
	}
}