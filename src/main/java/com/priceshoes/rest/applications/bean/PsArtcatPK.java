package com.priceshoes.rest.applications.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsArtcatPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long caCveN;
	private Long idArt;
	private String coCveStr;
	private Long caPagN;
	private Double taCveN;

	@Column(name = "CA_CVE_N")
	public Long getCaCveN() {
		return this.caCveN;
	}

	public void setCaCveN(Long caCveN) {
		this.caCveN = caCveN;
	}

	@Column(name = "ID_ART")
	public Long getIdArt() {
		return this.idArt;
	}

	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}

	@Column(name = "CO_CVE_STR")
	public String getCoCveStr() {
		return this.coCveStr;
	}

	public void setCoCveStr(String coCveStr) {
		this.coCveStr = coCveStr;
	}

	@Column(name = "CA_PAG_N")
	public Long getCaPagN() {
		return this.caPagN;
	}

	public void setCaPagN(Long caPagN) {
		this.caPagN = caPagN;
	}

	@Column(name = "TA_CVE_N")
	public Double getTaCveN() {
		return this.taCveN;
	}

	public void setTaCveN(Double taCveN) {
		this.taCveN = taCveN;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof PsArtcatPK)) {
			return false;
		} else {
			PsArtcatPK castOther = (PsArtcatPK) other;
			return this.caCveN == castOther.caCveN && this.idArt == castOther.idArt
					&& this.coCveStr.equals(castOther.coCveStr) && this.taCveN.equals(castOther.taCveN)
					&& this.caPagN == castOther.caPagN;
		}
	}

	public int hashCode() {
		boolean prime = true;
		byte hash = 17;
		int hash1 = hash * 31 + (int) (this.caCveN.longValue() ^ this.caCveN.longValue() >>> 32);
		hash1 = hash1 * 31 + (int) (this.idArt.longValue() ^ this.idArt.longValue() >>> 32);
		hash1 = hash1 * 31 + this.coCveStr.hashCode();
		hash1 = hash1 * 31 + this.taCveN.hashCode();
		hash1 = hash1 * 31 + (int) (this.caPagN.longValue() ^ this.caPagN.longValue() >>> 32);
		return hash1;
	}
}