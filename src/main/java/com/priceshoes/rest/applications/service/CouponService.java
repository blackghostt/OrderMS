package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.repository.CouponRepository;
import com.priceshoes.rest.applications.service.AbstractService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService extends AbstractService {
	@Autowired
	private CouponRepository couponRepository;

	public Long count() {
		return Long.valueOf(this.couponRepository.count());
	}

	public BigDecimal getSalary(String id) {
		return this.couponRepository.getSalary(id);
	}
}