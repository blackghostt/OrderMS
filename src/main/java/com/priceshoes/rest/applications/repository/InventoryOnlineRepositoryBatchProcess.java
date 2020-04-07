package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.entity.InventoryBean;
import java.util.List;

public interface InventoryOnlineRepositoryBatchProcess {
	List<InventoryBean> getInventory(int arg0, int arg1);
}