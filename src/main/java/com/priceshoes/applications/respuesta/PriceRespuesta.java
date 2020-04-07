package com.priceshoes.applications.respuesta;

import java.util.List;

import com.priceshoes.rest.applications.entity.ProductPrice;

public class PriceRespuesta extends Respuesta {

	private List<ProductPrice> productPrices;

	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}
}
