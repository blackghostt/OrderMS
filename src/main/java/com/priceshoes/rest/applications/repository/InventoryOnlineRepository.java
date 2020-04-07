package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.entity.InventoryOnline;
import com.priceshoes.rest.applications.repository.InventoryRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryOnlineRepository
		extends InventoryRepository<InventoryOnline, Long>, JpaSpecificationExecutor<InventoryOnline> {
}