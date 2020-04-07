package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.InventoryOnlinePK;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PS_INVENTARIO_ECOMM")
@NamedQueries({ @NamedQuery(name = "InventoryOnline.findAll", query = "SELECT i FROM InventoryOnline i"),
		@NamedQuery(name = "InventoryOnline.findBySkuId", query = "SELECT i FROM InventoryOnline i WHERE i.skuId = :skuId"),
		@NamedQuery(name = "InventoryOnline.findBySkuAndSizeId", query = "SELECT i FROM InventoryOnline i WHERE i.skuId = :skuId AND i.size = :size"),
		@NamedQuery(name = "InventoryOnline.findByStoreId", query = "SELECT i FROM InventoryOnline i WHERE i.storeId = :storeId"),
		@NamedQuery(name = "InventoryOnline.findBySkuAndStoreId", query = "SELECT i FROM InventoryOnline i WHERE i.storeId = :storeId AND i.skuId = :skuId"),
		@NamedQuery(name = "InventoryOnline.findBySkuIds", query = "SELECT i FROM InventoryOnline i WHERE i.skuId IN (:skuId)"),
		@NamedQuery(name = "InventoryOnline.findAllByStoreIds", query = "SELECT i FROM InventoryOnline i WHERE i.storeId IN (:storeIds) order by i.storeId ASC"),
		@NamedQuery(name = "InventoryOnline.findBySkuAndStoreIds", query = "SELECT i.skuId, sum(i.stockLevel), i.size FROM InventoryOnline i WHERE i.skuId IN (:skuIds) AND i.storeId IN (:storeIds) group by i.skuId, i.size"),
		@NamedQuery(name = "InventoryOnline.count", query = "SELECT COUNT(i) FROM InventoryOnline i") })
@IdClass(InventoryOnlinePK.class)
public class InventoryOnline implements Serializable {
	private static final long serialVersionUID = 270081599261758764L;
	@Basic(optional = false)
	@Column(name = "TI_CVE_N")
	private Integer storeId;
	@Id
	@Basic(optional = false)
	@Column(name = "ID_ART")
	private Long skuId;
	@Basic(optional = true)
	@Column(name = "INVE_EXIST_N")
	private Long stockLevel;
	@Basic(optional = false)
	@Column(name = "TA_CVE_N")
	private Double size;

	public InventoryOnline() {
	}

	public InventoryOnline(Long sequence, Integer storeId, Integer boCveN, Long skuId, Double size, Integer exCantN) {
		this.storeId = storeId;
		this.skuId = skuId;
		this.size = size;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Long getStockLevel() {
		return this.stockLevel;
	}

	public void setStockLevel(Long stockLevel) {
		this.stockLevel = stockLevel;
	}

	public Long getSkuId() {
		return this.skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Double getSize() {
		return this.size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public int hashCode() {
		return Objects.hash(new Object[] { this.skuId, this.storeId, this.size, this.stockLevel });
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof InventoryOnline)) {
			return false;
		} else {
			InventoryOnline inventoryOnline = (InventoryOnline) obj;
			return this.skuId == inventoryOnline.skuId && Objects.equals(this.storeId, inventoryOnline.storeId)
					&& Objects.equals(this.size, inventoryOnline.size)
					&& Objects.equals(this.stockLevel, inventoryOnline.stockLevel);
		}
	}

	public String toString() {
		return String.format("com.priceshoes.rest.db_model.InventoryRetail[id#%s]",
				new Object[] { Integer.valueOf(this.hashCode()) });
	}
}