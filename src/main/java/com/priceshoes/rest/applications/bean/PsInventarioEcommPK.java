package com.priceshoes.rest.applications.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PsInventarioEcommPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "TI_CVE_N")
	private Long tienda;
	@Column(name = "ID_ART")
	private Long articulo;
	@Column(name = "TA_CVE_N")
	private Double talla;

	public Long getTienda() {
		return this.tienda;
	}

	public void setTienda(Long tienda) {
		this.tienda = tienda;
	}

	public Long getArticulo() {
		return this.articulo;
	}

	public void setArticulo(Long articulo) {
		this.articulo = articulo;
	}

	public Double getTalla() {
		return this.talla;
	}

	public void setTalla(Double talla) {
		this.talla = talla;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		} else if (!(other instanceof PsInventarioEcommPK)) {
			return false;
		} else {
			PsInventarioEcommPK castOther = (PsInventarioEcommPK) other;
			return this.tienda == castOther.tienda && this.articulo == castOther.articulo
					&& this.talla == castOther.talla;
		}
	}

	public int hashCode() {
		boolean prime = true;
		byte hash = 17;
		int hash1 = hash * 31 + (int) (this.tienda.longValue() ^ this.tienda.longValue() >>> 32);
		hash1 = hash1 * 31 + (int) (this.articulo.longValue() ^ this.articulo.longValue() >>> 32);
		hash1 = hash1 * 31 + this.talla.hashCode();
		return hash1;
	}
}