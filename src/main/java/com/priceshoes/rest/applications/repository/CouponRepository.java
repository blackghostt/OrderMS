package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.entity.Coupon;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends PagingAndSortingRepository<Coupon, Long>, JpaSpecificationExecutor<Coupon> {
	@Procedure
	BigDecimal getSalary(@Param("pSO_ID_STR") String arg0);
}