package com.priceshoes.rest.applications.respuesta;

import com.priceshoes.rest.applications.entity.ProductPrice;
import com.priceshoes.rest.applications.respuesta.Respuesta;
import java.util.List;

public class PriceRespuesta extends Respuesta {
	private List<ProductPrice> productPrices;

	public List<ProductPrice> getProductPrices() {
		return this.productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}
}