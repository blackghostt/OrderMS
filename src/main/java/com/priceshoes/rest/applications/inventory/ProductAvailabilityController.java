package com.priceshoes.rest.applications.inventory;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.service.ProductAvailabilityService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/product" })
public class ProductAvailabilityController extends AbstractRestController {
	@Autowired
	private ProductAvailabilityService productAvailabilityService;

	@RequestMapping(method = { RequestMethod.GET }, value = { "/availability" })
	public ResponseEntity<?> getAvailability() {
		HashMap body = new HashMap();
		body.put("data", this.productAvailabilityService.getAvailability());
		return ResponseEntity.ok(body);
	}
}