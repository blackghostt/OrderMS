package com.priceshoes.rest.applications.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "webfGetTiendasPisoVenta", query = "{? = call PPVMX.WEBF_GET_TIENDAS_PISO_VENTA}", callable = true, resultClass = Tienda.class)
public class Tienda {
	private Integer tienda;

	@Id
	@Column(name = "TI_CVE_N")
	public Integer getTienda() {
		return this.tienda;
	}

	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}
}