package com.priceshoes.rest.applications.entity;

import java.util.Date;

public class SkuDate {
	private String skuId;
	private Date date;

	public SkuDate() {
	}

	SkuDate(String skuId, Date date) {
		this.skuId = skuId;
		this.date = date;
	}

	public String getSkuId() {
		return this.skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}