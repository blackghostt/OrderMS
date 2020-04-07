package com.priceshoes.rest.applications.entity;

public class InventoryBean {
	private int ti_cve_n;
	private String id_art;
	private float ta_cve_n;
	private int inv_exist_n;

	public int getTi_cve_n() {
		return this.ti_cve_n;
	}

	public void setTi_cve_n(int ti_cve_n) {
		this.ti_cve_n = ti_cve_n;
	}

	public String getId_art() {
		return this.id_art;
	}

	public void setId_art(String id_art) {
		this.id_art = id_art;
	}

	public float getTa_cve_n() {
		return this.ta_cve_n;
	}

	public void setTa_cve_n(float ta_cve_n) {
		this.ta_cve_n = ta_cve_n;
	}

	public int getInv_exist_n() {
		return this.inv_exist_n;
	}

	public void setInv_exist_n(int inv_exist_n) {
		this.inv_exist_n = inv_exist_n;
	}
}