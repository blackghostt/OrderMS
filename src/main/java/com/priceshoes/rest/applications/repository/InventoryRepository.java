package com.priceshoes.rest.applications.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface InventoryRepository<T, ID extends Serializable>
		extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {
	Iterable<T> findBySkuAndSizeId(@Param("skuId") long arg0, @Param("size") double arg2);

	Iterable<T> findBySkuId(@Param("skuId") long arg0);

	Iterable<T> findBySkuIds(@Param("skuIds") List<Long> arg0);

	Page<T> findAllByStoreIds(@Param("storeIds") List<Integer> arg0, Pageable arg1);

	Iterable<T> findBySkuAndStoreId(@Param("skuId") Long arg0, @Param("storeId") Integer arg1);

	Iterable<T> findByStoreId(@Param("storeId") Long arg0);

	Iterable<T> findBySkuAndStoreIds(@Param("skuIds") List<Long> arg0, @Param("storeIds") List<Integer> arg1);

	Page<T> findBySkuId(@Param("skuId") long arg0, Pageable arg2);

	Page<T> findBySkuIds(@Param("skuIds") List<Long> arg0, Pageable arg1);

	Page<T> findBySkuAndStoreId(@Param("skuId") Long arg0, @Param("storeId") Integer arg1, Pageable arg2);

	Page<T> findByStoreId(@Param("storeId") Integer arg0, Pageable arg1);

	Page<T> findBySkuAndStoreIds(@Param("skuIds") List<Long> arg0, @Param("storeIds") List<Long> arg1, Pageable arg2);

	Page<T> findAll(Pageable arg0);
}