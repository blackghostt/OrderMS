package com.priceshoes.rest.applications.bean;

import java.util.List;

public class InventoryBean {
	public List<Long> skuIds;
	public List<Integer> storeIds;

	public List<Long> getSkuIds() {
		return this.skuIds;
	}

	public void setSkuIds(List<Long> skuIds) {
		this.skuIds = skuIds;
	}

	public List<Integer> getStoreIds() {
		return this.storeIds;
	}

	public void setStoreIds(List<Integer> storeIds) {
		this.storeIds = storeIds;
	}
}
