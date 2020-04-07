package com.priceshoes.rest.applications.inventory;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.respuesta.PriceRespuesta;
import com.priceshoes.rest.applications.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/product" })
public class PriceController extends AbstractRestController {
	@Autowired
	private PriceService priceService;

	@RequestMapping(value = { "/prices" }, method = { RequestMethod.GET })
	public ResponseEntity<PriceRespuesta> getPrice(@RequestParam(value = "days", defaultValue = "1") int days) {
		this.logDebug("Start / Rest service of private");
		PriceRespuesta respuesta = this.priceService.getPrices(days);
		this.logDebug("End / Rest service of private");
		return ResponseEntity.ok(respuesta);
	}
}