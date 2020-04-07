package com.priceshoes.applications.respuesta;

import java.util.List;

import com.priceshoes.rest.applications.entity.CatalogInfo;

public class CatalogRespuesta extends Respuesta{
	
	private List<CatalogInfo> catalogInfo;

	public List<CatalogInfo> getCatalogInfo() {
		return catalogInfo;
	}

	public void setCatalogInfo(List<CatalogInfo> catalogInfo) {
		this.catalogInfo = catalogInfo;
	}
	

}
