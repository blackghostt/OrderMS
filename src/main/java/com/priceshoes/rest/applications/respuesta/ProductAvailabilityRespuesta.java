package com.priceshoes.rest.applications.respuesta;

import com.priceshoes.rest.applications.entity.SkuDate;
import com.priceshoes.rest.applications.respuesta.Respuesta;
import java.util.List;

public class ProductAvailabilityRespuesta extends Respuesta {
	private List<SkuDate> skuDates;

	public List<SkuDate> getSkuDates() {
		return this.skuDates;
	}

	public void setSkuDates(List<SkuDate> skuDates) {
		this.skuDates = skuDates;
	}
}