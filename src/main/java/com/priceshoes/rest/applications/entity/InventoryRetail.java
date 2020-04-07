package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.InventoryRetailPK;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name = "PS_INVENTARIO_ECOMM")
@NamedQueries({ @NamedQuery(name = "InventoryRetail.findAll", query = "SELECT i FROM InventoryRetail i"),
		@NamedQuery(name = "InventoryRetail.findBySkuId", query = "SELECT i FROM InventoryRetail i WHERE i.skuId = :skuId order by i.storeId ASC"),
		@NamedQuery(name = "InventoryRetail.findBySkuAndSizeId", query = "SELECT i FROM InventoryRetail i WHERE i.skuId = :skuId AND i.size = :size"),
		@NamedQuery(name = "InventoryRetail.findByStoreId", query = "SELECT i FROM InventoryRetail i WHERE i.storeId = :storeId"),
		@NamedQuery(name = "InventoryRetail.findBySkuAndStoreId", query = "SELECT i FROM InventoryRetail i WHERE i.skuId = :skuId AND i.storeId = :storeId"),
		@NamedQuery(name = "InventoryRetail.findBySkuIds", query = "SELECT i FROM InventoryRetail i WHERE i.skuId IN (:skuId)"),
		@NamedQuery(name = "InventoryRetail.findAllByStoreIds", query = "SELECT i FROM InventoryOnline i WHERE i.storeId IN (:storeIds) ORDER BY i.storeId ASC"),
		@NamedQuery(name = "InventoryRetail.findBySkuAndStoreIds", query = "SELECT i FROM InventoryRetail i WHERE i.skuId IN (:skuIds) AND i.storeId IN (:storeIds)"),
		@NamedQuery(name = "InventoryRetail.count", query = "SELECT COUNT(i) FROM InventoryRetail i") })
@IdClass(InventoryRetailPK.class)
public class InventoryRetail extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 5423665875470202881L;
	@Basic(optional = false)
	@Column(name = "TI_CVE_N")
	private Integer storeId;
	@Id
	@Basic(optional = false)
	@Column(name = "ID_ART")
	private Long skuId;
	@Basic(optional = false)
	@Column(name = "CO_CVE_STR")
	private String sizeDefinition;
	@Basic(optional = false)
	@Column(name = "TA_CVE_N")
	private Double size;
	@Basic(optional = true)
	@Column(name = "INVE_EXIST_N")
	private Long stockLevel;
	@Basic(optional = true)
	@Column(name = "INVE_SUGVTA_N")
	private Double suggestedSell;
	@Basic(optional = true)
	@Column(name = "INVE_DIASINV_N")
	private Long inventoryTurns;
	@Basic(optional = false)
	@Column(name = "INVE_FEC_DT")
	private Date updatedOn;
	@Basic(optional = false)
	@Column(name = "INVE_EST_STR")
	private String status;

	public InventoryRetail() {
	}

	public InventoryRetail(Long skuId) {
		this.skuId = skuId;
	}

	public InventoryRetail(Integer storeId, Long skuId, String sizeDefinition, Double size, Long stockLevel,
			Double suggestedSell, Long inventoryTurns, Date updatedOn, String status) {
		this.storeId = storeId;
		this.skuId = skuId;
		this.sizeDefinition = sizeDefinition;
		this.size = size;
		this.stockLevel = stockLevel;
		this.suggestedSell = suggestedSell;
		this.inventoryTurns = inventoryTurns;
		this.updatedOn = updatedOn;
		this.status = status;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Long getSkuId() {
		return this.skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public String getSizeDefinition() {
		return this.sizeDefinition;
	}

	public void setSizeDefinition(String sizeDefinition) {
		this.sizeDefinition = sizeDefinition;
	}

	public Double getSize() {
		return this.size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Long getStockLevel() {
		return this.stockLevel;
	}

	public void setStockLevel(Long stockLevel) {
		this.stockLevel = stockLevel;
	}

	public Double getSuggestedSell() {
		return this.suggestedSell;
	}

	public void setSuggestedSell(Double suggestedSell) {
		this.suggestedSell = suggestedSell;
	}

	public Long getInventoryTurns() {
		return this.inventoryTurns;
	}

	public void setInventoryTurns(Long inventoryTurns) {
		this.inventoryTurns = inventoryTurns;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int hashCode() {
		return Objects.hash(new Object[] { this.storeId, this.skuId, this.sizeDefinition, this.size, this.stockLevel,
				this.suggestedSell, this.inventoryTurns, this.updatedOn, this.status });
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof InventoryRetail)) {
			return false;
		} else {
			InventoryRetail inventoryRetail = (InventoryRetail) obj;
			return this.skuId == inventoryRetail.skuId && Objects.equals(this.storeId, inventoryRetail.storeId)
					&& Objects.equals(this.sizeDefinition, inventoryRetail.sizeDefinition)
					&& Objects.equals(this.size, inventoryRetail.size)
					&& Objects.equals(this.stockLevel, inventoryRetail.stockLevel)
					&& Objects.equals(this.suggestedSell, inventoryRetail.suggestedSell)
					&& Objects.equals(this.inventoryTurns, inventoryRetail.inventoryTurns)
					&& Objects.equals(this.updatedOn, inventoryRetail.updatedOn)
					&& Objects.equals(this.status, inventoryRetail.status);
		}
	}

	public String toString() {
		return String.format("com.priceshoes.rest.db_model.InventoryRetail[id#%s]",
				new Object[] { Integer.valueOf(this.hashCode()) });
	}
}