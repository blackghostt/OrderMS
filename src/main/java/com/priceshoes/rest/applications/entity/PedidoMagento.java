package com.priceshoes.rest.applications.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PS_PEDTMK_MAGENTO")
public class PedidoMagento 
{
	@Id
	@Column(name="PTM_MAGENTO_STR") 
	private String ptmMagentoStr;
	
	@Column(name="TI_CVE_N") 		
	private Long tiCveN;
	
	@Column(name="PT_NUM_N") 		
	private Long ptNumN;
	
	@Column(name="PTM_FEC_DT", insertable = false) 	
	@Temporal(TemporalType.TIMESTAMP)	
	private Date ptmFecDt;
	
	@Column(name="PTM_EST_STR", insertable = false) 	
	private String ptmEStStr;
	
	public Long getTiCveN() {
		return tiCveN;
	}
	public void setTiCveN(Long tiCveN) {
		this.tiCveN = tiCveN;
	}
	public Long getPtNumN() {
		return ptNumN;
	}
	public void setPtNumN(Long ptNumN) {
		this.ptNumN = ptNumN;
	}
	public String getPtmMagentoStr() {
		return ptmMagentoStr;
	}
	public void setPtmMagentoStr(String ptmMagentoStr) {
		this.ptmMagentoStr = ptmMagentoStr;
	}
	public Date getPtmFecDt() {
		return ptmFecDt;
	}
	public void setPtmFecDt(Date ptmFecDt) {
		this.ptmFecDt = ptmFecDt;
	}
	public String getPtmEStStr() {
		return ptmEStStr;
	}
	public void setPtmEStStr(String ptmEStStr) {
		this.ptmEStStr = ptmEStStr;
	}
	
	
}
