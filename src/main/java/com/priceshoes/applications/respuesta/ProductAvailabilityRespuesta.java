package com.priceshoes.applications.respuesta;

import java.util.List;

import com.priceshoes.rest.applications.entity.SkuDate;

public class ProductAvailabilityRespuesta extends Respuesta {

	private List<SkuDate> skuDates;

	public List<SkuDate> getSkuDates() {
		return skuDates;
	}

	public void setSkuDates(List<SkuDate> skuDates) {
		this.skuDates = skuDates;
	}
}
