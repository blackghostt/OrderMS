package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.entity.SkuDate;
import java.util.List;

public interface ProductAvailabilityRepository {
	List<SkuDate> getAvailability();
}