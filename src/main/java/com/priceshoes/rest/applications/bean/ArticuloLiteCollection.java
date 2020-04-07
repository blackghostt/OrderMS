package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.ArticuloLite;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArticuloLiteCollection implements Serializable {
	private static final long serialVersionUID = -5311593758599583762L;
	protected List<ArticuloLite> articulo;

	public void setArticulo(List<ArticuloLite> articulo) {
		this.articulo = articulo;
	}

	public List<ArticuloLite> getArticulo() {
		if (this.articulo == null) {
			this.articulo = new ArrayList();
		}

		return this.articulo;
	}
}