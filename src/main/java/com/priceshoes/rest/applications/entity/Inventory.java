package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.InventoryPK;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PS_INVENTARIO_ECOMM")
@NamedQueries({ @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i") })
public class Inventory implements Serializable {
	private static final long serialVersionUID = 7333556083208555426L;
	@EmbeddedId
	InventoryPK primaryKey;
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

	public Inventory() {
		this.primaryKey = new InventoryPK();
	}

	public Inventory(InventoryPK primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Inventory(InventoryPK primaryKey, Long stockLevel, Double suggestedSell, Long inventoryTurns, Date updatedOn,
			String status) {
		this.primaryKey = primaryKey;
		this.stockLevel = stockLevel;
		this.suggestedSell = suggestedSell;
		this.inventoryTurns = inventoryTurns;
		this.updatedOn = updatedOn;
		this.status = status;
	}

	public InventoryPK getPrimaryKey() {
		return this.primaryKey;
	}

	public void setPrimaryKey(InventoryPK primaryKey) {
		this.primaryKey = primaryKey;
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

	public Date getUpdated() {
		return this.updatedOn;
	}

	public void setUpdated(Date updated) {
		this.updatedOn = updated;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int hashCode() {
		return Objects.hash(new Object[] { this.primaryKey, this.stockLevel, this.suggestedSell, this.inventoryTurns,
				this.updatedOn, this.status });
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Inventory)) {
			return false;
		} else {
			Inventory inventory = (Inventory) obj;
			return this.primaryKey.equals(inventory.primaryKey)
					&& Objects.equals(this.suggestedSell, inventory.suggestedSell)
					&& Objects.equals(this.inventoryTurns, inventory.inventoryTurns)
					&& Objects.equals(this.updatedOn, inventory.updatedOn)
					&& Objects.equals(this.status, inventory.status);
		}
	}

	public String toString() {
		return String.format("com.priceshoes.rest.db_model.Inventory[id#%s]",
				new Object[] { Integer.valueOf(this.hashCode()) });
	}
}