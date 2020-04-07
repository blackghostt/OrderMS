package com.priceshoes.rest.applications.entity;

public class CatalogInfo {
	private int Id_Art;
	private String Desc_Catalogo;

	public int getId_Art() {
		return this.Id_Art;
	}

	public void setId_Art(int id_Art) {
		this.Id_Art = id_Art;
	}

	public String getDesc_Catalogo() {
		return this.Desc_Catalogo;
	}

	public void setDesc_Catalogo(String desc_Catalogo) {
		this.Desc_Catalogo = desc_Catalogo;
	}
}