package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.entity.InventoryRetail;
import com.priceshoes.rest.applications.repository.InventoryRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRetailRepository
		extends InventoryRepository<InventoryRetail, Long>, JpaSpecificationExecutor<InventoryRetail> {
}