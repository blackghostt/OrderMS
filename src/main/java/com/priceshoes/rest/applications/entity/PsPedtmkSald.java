package com.priceshoes.rest.applications.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PS_PEDTMK_SALD")
public class PsPedtmkSald 
{
	@EmbeddedId					private PsPedtmkVinPK id;
	@Column(name="SO_ID_STR")	private String soIdStr;
	@Column(name="PTS_SALD_N")	private Double ptsSaldN;
	@Column(name="PTS_EST_STR")	private String ptsEstStr;
	
	public PsPedtmkSald() {}
	public PsPedtmkSald(Long sucursal, Long pedido) 
	{
		this.id = new PsPedtmkVinPK();
		this.id.setPtNumN(pedido);
		this.id.setTiCveN(sucursal);
	}
	public PsPedtmkVinPK getId() {
		return id;
	}
	public void setId(PsPedtmkVinPK id) {
		this.id = id;
	}
	public String getSoIdStr() {
		return soIdStr;
	}
	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}
	public Double getPtsSaldN() {
		return ptsSaldN;
	}
	public void setPtsSaldN(Double ptsSaldN) {
		this.ptsSaldN = ptsSaldN;
	}
	public String getPtsEstStr() {
		return ptsEstStr;
	}
	public void setPtsEstStr(String ptsEstStr) {
		this.ptsEstStr = ptsEstStr;
	}
	
	
}
