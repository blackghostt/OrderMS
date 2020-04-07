package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MemberAddressPK implements Serializable {
	private static final long serialVersionUID = 2702866112319006397L;
	@Column(name = "SO_ID_STR")
	private String soIdStr;
	@Column(name = "SOD_CONS_N")
	private Long sodConsN;

	public String getSoIdStr() {
		return this.soIdStr;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	public Long getSodConsN() {
		return this.sodConsN;
	}

	public void setSodConsN(Long sodConsN) {
		this.sodConsN = sodConsN;
	}

	public String toString() {
		return "MemberAddressPK(soIdStr=" + this.getSoIdStr() + ", sodConsN=" + this.getSodConsN() + ")";
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof MemberAddressPK)) {
			return false;
		} else {
			MemberAddressPK other = (MemberAddressPK) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				String this$soIdStr = this.getSoIdStr();
				String other$soIdStr = other.getSoIdStr();
				if (this$soIdStr == null) {
					if (other$soIdStr != null) {
						return false;
					}
				} else if (!this$soIdStr.equals(other$soIdStr)) {
					return false;
				}

				Long this$sodConsN = this.getSodConsN();
				Long other$sodConsN = other.getSodConsN();
				if (this$sodConsN == null) {
					if (other$sodConsN != null) {
						return false;
					}
				} else if (!this$sodConsN.equals(other$sodConsN)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof MemberAddressPK;
	}

	public int hashCode() {
		boolean PRIME = true;
		byte result = 1;
		String $soIdStr = this.getSoIdStr();
		int result1 = result * 59 + ($soIdStr == null ? 43 : $soIdStr.hashCode());
		Long $sodConsN = this.getSodConsN();
		result1 = result1 * 59 + ($sodConsN == null ? 43 : $sodConsN.hashCode());
		return result1;
	}
}