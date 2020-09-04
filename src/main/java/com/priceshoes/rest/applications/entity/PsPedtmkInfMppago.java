package com.priceshoes.rest.applications.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PPVMX.PS_PEDTMK_INF_MPPAGO")
public class PsPedtmkInfMppago 
{
	@EmbeddedId						private PsPedtmkInfMppagoPK id;
	@Column(name="PAG_TIPO_STR")	private String 	pagTipoStr;
	@Column(name="PAG_STATUS_STR")	private String 	pagStatusStr;
	@Column(name="PAG_MONTO_N")		private Double 	pagMontoN;
	@Column(name="PAG_PAGADO_N")	private Double 	pagPagadoN;
	@Column(name="PAG_FREG_DT")		private Date	pagFregDt;

	public PsPedtmkInfMppago(Long ptNumN, Integer tiCveN,String fpeCveStr)
	{
		this.id = new PsPedtmkInfMppagoPK(ptNumN,tiCveN,fpeCveStr);
	}
	public PsPedtmkInfMppagoPK getId() {
		return id;
	}
	public void setId(PsPedtmkInfMppagoPK id) {
		this.id = id;
	}
	public String getPagTipoStr() {
		return pagTipoStr;
	}
	public void setPagTipoStr(String pagTipoStr) {
		this.pagTipoStr = pagTipoStr;
	}
	public String getPagStatusStr() {
		return pagStatusStr;
	}
	public void setPagStatusStr(String pagStatusStr) {
		this.pagStatusStr = pagStatusStr;
	}
	public Double getPagMontoN() {
		return pagMontoN;
	}
	public void setPagMontoN(Double pagMontoN) {
		this.pagMontoN = pagMontoN;
	}
	public Double getPagPagadoN() {
		return pagPagadoN;
	}
	public void setPagPagadoN(Double pagPagadoN) {
		this.pagPagadoN = pagPagadoN;
	}
	public Date getPagFregDt() {
		return pagFregDt;
	}
	public void setPagFregDt(Date pagFregDt) {
		this.pagFregDt = pagFregDt;
	}
	
}
