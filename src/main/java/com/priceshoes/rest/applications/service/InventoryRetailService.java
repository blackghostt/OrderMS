package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.entity.InventoryRetail;
import com.priceshoes.rest.applications.repository.InventoryRetailRepository;
import com.priceshoes.rest.applications.service.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class InventoryRetailService extends AbstractService {
	@Autowired
	private InventoryRetailRepository inventoryRepositoryRetail;

	public long count() {
		return this.inventoryRepositoryRetail.count();
	}

	public Iterable<InventoryRetail> findInventoryBySkuAndSizeId(long skuId, double size) {
		return this.inventoryRepositoryRetail.findBySkuAndSizeId(skuId, size);
	}

	public Iterable<InventoryRetail> findAll() {
		return this.inventoryRepositoryRetail.findAll();
	}

	public Page<InventoryRetail> findAll(int start, int end) {
		return this.inventoryRepositoryRetail.findAll(new PageRequest(start, end));
	}

	public Iterable<InventoryRetail> findInventoryBySkuId(long skuId) {
		return this.inventoryRepositoryRetail.findBySkuId(skuId);
	}

	public Iterable<InventoryRetail> findInventoryBySkuIds(List<Long> skuIds) {
		return this.inventoryRepositoryRetail.findBySkuIds(skuIds);
	}

	public Iterable<InventoryRetail> findInventoryByStoreId(Long storeId) {
		return this.inventoryRepositoryRetail.findByStoreId(storeId);
	}

	public Iterable<InventoryRetail> findInventoryBySkuAndStoreId(Long skuId, Integer storeId) {
		return this.inventoryRepositoryRetail.findBySkuAndStoreId(skuId, storeId);
	}

	public Page<InventoryRetail> findInventoryBySkuId(Long skuId, int start, int end) {
		return this.inventoryRepositoryRetail.findBySkuId(skuId.longValue(), new PageRequest(start, end));
	}

	public Page<InventoryRetail> findInventoryBySkuIds(List<Long> skuIds, int start, int end) {
		return this.inventoryRepositoryRetail.findBySkuIds(skuIds, new PageRequest(start, end));
	}

	public Page<InventoryRetail> findInventoryByStoreId(Integer storeId, int start, int end) {
		return this.inventoryRepositoryRetail.findByStoreId(storeId, new PageRequest(start, end));
	}

	public Page<InventoryRetail> findInventoryBySkuAndStoreId(Long skuId, Integer storeId, int start, int end) {
		return this.inventoryRepositoryRetail.findBySkuAndStoreId(skuId, storeId, new PageRequest(start, end));
	}
}