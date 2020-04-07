package com.priceshoes.rest.applications.respuesta;

import com.priceshoes.rest.applications.entity.CatalogInfo;
import com.priceshoes.rest.applications.respuesta.Respuesta;
import java.util.List;

public class CatalogRespuesta extends Respuesta {
	private List<CatalogInfo> catalogInfo;

	public List<CatalogInfo> getCatalogInfo() {
		return this.catalogInfo;
	}

	public void setCatalogInfo(List<CatalogInfo> catalogInfo) {
		this.catalogInfo = catalogInfo;
	}
}