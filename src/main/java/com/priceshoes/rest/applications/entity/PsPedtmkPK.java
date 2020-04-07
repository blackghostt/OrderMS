package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsPedtmkPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long tiCveN;
	private Long ptNumN;

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

	public int hashCode() {
		boolean prime = true;
		byte result = 1;
		int result1 = 31 * result + (this.ptNumN == null ? 0 : this.ptNumN.hashCode());
		result1 = 31 * result1 + (this.tiCveN == null ? 0 : this.tiCveN.hashCode());
		return result1;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			PsPedtmkPK other = (PsPedtmkPK) obj;
			if (this.ptNumN == null) {
				if (other.ptNumN != null) {
					return false;
				}
			} else if (!this.ptNumN.equals(other.ptNumN)) {
				return false;
			}

			if (this.tiCveN == null) {
				if (other.tiCveN != null) {
					return false;
				}
			} else if (!this.tiCveN.equals(other.tiCveN)) {
				return false;
			}

			return true;
		}
	}
}