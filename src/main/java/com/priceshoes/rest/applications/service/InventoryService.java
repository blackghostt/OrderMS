package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.entity.InventoryOnline;
import com.priceshoes.rest.applications.entity.InventoryRetail;
import com.priceshoes.rest.applications.repository.InventoryOnlineRepository;
import com.priceshoes.rest.applications.repository.InventoryRetailRepository;
import com.priceshoes.rest.applications.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class InventoryService extends AbstractService {
	@Autowired
	private InventoryOnlineRepository inventoryOnlineRepository;
	@Autowired
	private InventoryRetailRepository inventoryRetailRepository;

	public Iterable<InventoryOnline> findAllOnline() {
		return this.inventoryOnlineRepository.findAll();
	}

	public Iterable<InventoryRetail> findAllRetail() {
		return this.inventoryRetailRepository.findAll();
	}

	public Page<InventoryOnline> findAllOnline(int page, int size) {
		return this.inventoryOnlineRepository.findAll(new PageRequest(page, size));
	}

	public Page<InventoryRetail> findAllRetail(int page, int size) {
		return this.inventoryRetailRepository.findAll(new PageRequest(page, size));
	}
}