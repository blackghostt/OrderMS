/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.entity.SkuDate;
import com.priceshoes.rest.applications.repository.ProductAvailabilityRepository;
import com.priceshoes.rest.applications.service.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductAvailabilityService extends AbstractService {
	@Autowired
	private ProductAvailabilityRepository productAvailabilityRepository;

	public List<SkuDate> getAvailability() {
		return this.productAvailabilityRepository.getAvailability();
	}
}