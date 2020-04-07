package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.entity.InventoryOnline;
import com.priceshoes.rest.applications.repository.InventoryOnlineRepository;
import com.priceshoes.rest.applications.service.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class InventoryOnlineService extends AbstractService {
	@Autowired
	private InventoryOnlineRepository inventoryOnlineRepository;

	public Iterable<InventoryOnline> findInventoryBySkuAndSizeId(long skuId, double size) {
		return this.inventoryOnlineRepository.findBySkuAndSizeId(skuId, size);
	}

	public Iterable<InventoryOnline> findAll() {
		return this.inventoryOnlineRepository.findAll();
	}

	public List<InventoryOnline> findAllStoreIds(List<Integer> storeIds) {
		return (List) this.inventoryOnlineRepository.findAll();
	}

	public Page<InventoryOnline> findAll(int start, int end) {
		return this.inventoryOnlineRepository.findAll(new PageRequest(start, end));
	}

	public Page<InventoryOnline> findAllByStoreIds(List<Integer> storeIds, int start, int end) {
		return this.inventoryOnlineRepository.findAllByStoreIds(storeIds, new PageRequest(start, end));
	}

	public Iterable<InventoryOnline> findInventoryBySkuId(long skuId) {
		return this.inventoryOnlineRepository.findBySkuId(skuId);
	}

	public Iterable<InventoryOnline> findInventoryBySkuIds(List<Long> skuIds) {
		return this.inventoryOnlineRepository.findBySkuIds(skuIds);
	}

	public Iterable<InventoryOnline> findInventoryByStoreId(Long storeId) {
		return this.inventoryOnlineRepository.findByStoreId(storeId);
	}

	public Iterable<InventoryOnline> findInventoryBySkuAndStoreId(Long skuId, Integer storeId) {
		return this.inventoryOnlineRepository.findBySkuAndStoreId(skuId, storeId);
	}

	public Iterable<InventoryOnline> findInventoryBySkuAndStoreIds(List<Long> skuIds, List<Integer> storeIds) {
		return this.inventoryOnlineRepository.findBySkuAndStoreIds(skuIds, storeIds);
	}

	public Page<InventoryOnline> findInventoryBySkuId(Long skuId, int start, int end) {
		return this.inventoryOnlineRepository.findBySkuId(skuId.longValue(), new PageRequest(start, end));
	}

	public Page<InventoryOnline> findInventoryBySkuIds(List<Long> skuIds, int start, int end) {
		return this.inventoryOnlineRepository.findBySkuIds(skuIds, new PageRequest(start, end));
	}

	public Page<InventoryOnline> findInventoryByStoreId(Integer storeId, int start, int end) {
		return this.inventoryOnlineRepository.findByStoreId(storeId, new PageRequest(start, end));
	}

	public Page<InventoryOnline> findInventoryBySkuAndStoreId(Long skuId, Integer storeId, int start, int end) {
		return this.inventoryOnlineRepository.findBySkuAndStoreId(skuId, storeId, new PageRequest(start, end));
	}
}