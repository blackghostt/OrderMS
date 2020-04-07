package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryPK implements Serializable {
	private static final long serialVersionUID = -1453418629030078273L;
	@Basic(optional = false)
	@Column(name = "TI_CVE_N")
	private Long storeId;
	@Basic(optional = false)
	@Column(name = "ID_ART")
	private Long skuId;
	@Basic(optional = false)
	@Column(name = "TA_CVE_N")
	private Double size;

	public InventoryPK() {
	}

	public InventoryPK(Long skuId) {
		this.skuId = skuId;
	}

	public InventoryPK(Long storeId, Long skuId, Double size) {
		this.storeId = storeId;
		this.skuId = skuId;
		this.size = size;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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
		return Objects.hash(new Object[] { this.storeId, this.skuId, this.size });
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof InventoryPK)) {
			return false;
		} else {
			InventoryPK primaryKey = (InventoryPK) obj;
			return this.skuId == primaryKey.skuId && Objects.equals(this.storeId, primaryKey.storeId)
					&& Objects.equals(this.size, primaryKey.size);
		}
	}

	public String toString() {
		return String.format("com.priceshoes.rest.db_model.InventoryPK[id#%s]",
				new Object[] { Integer.valueOf(this.hashCode()) });
	}
}