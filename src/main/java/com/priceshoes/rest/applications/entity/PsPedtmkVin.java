package com.priceshoes.rest.applications.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PS_PEDTMK_VIN")
public class PsPedtmkVin 
{
	@EmbeddedId 				private PsPedtmkVinPK id;
	@Column(name="PTV_IMP_N") 	private Double ptvImpN;
	@Column(name="PTV_EST_STR") private String ptvEstStr;
	
	public PsPedtmkVin(Long pedido, Long sucursal, Double cantidad, String status) 
	{
		this.id = new PsPedtmkVinPK();
		this.id.setPtNumN(pedido);
		this.id.setTiCveN(sucursal);
		this.ptvEstStr=status;
		this.ptvImpN = cantidad;
	}

	public PsPedtmkVinPK getId() {
		return id;
	}
	public void setId(PsPedtmkVinPK id) {
		this.id = id;
	}
	public Double getPtvImpN() {
		return ptvImpN;
	}
	public void setPtvImpN(Double ptvImpN) {
		this.ptvImpN = ptvImpN;
	}
	public String getPtvEstStr() {
		return ptvEstStr;
	}
	public void setPtvEstStr(String ptvEstStr) {
		this.ptvEstStr = ptvEstStr;
	}
	
}
