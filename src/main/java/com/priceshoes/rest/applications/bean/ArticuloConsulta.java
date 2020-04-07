package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.ArticuloLite;
import com.priceshoes.rest.applications.bean.ArticuloLiteCollection;
import java.io.Serializable;

public class ArticuloConsulta implements Serializable {
	private static final long serialVersionUID = -1860515161887400215L;
	private String name;
	private ArticuloLiteCollection articuloCollection;
	private ArticuloLite articuloLite;
	private Long[] ids;
	private Double[] tallas;

	public Double[] getTallas() {
		return this.tallas;
	}

	public void setTallas(Double[] tallas) {
		this.tallas = tallas;
	}

	public ArticuloLiteCollection getArticuloCollection() {
		return this.articuloCollection;
	}

	public void setArticuloCollection(ArticuloLiteCollection articuloCollection) {
		this.articuloCollection = articuloCollection;
	}

	public ArticuloLite getArticuloLite() {
		return this.articuloLite;
	}

	public void setArticuloLite(ArticuloLite articuloLite) {
		this.articuloLite = articuloLite;
	}

	public Long[] getIds() {
		return this.ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}