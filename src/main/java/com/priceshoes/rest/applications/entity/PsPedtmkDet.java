package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.PsPedtmkDetPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PS_PEDTMK_DET")
public class PsPedtmkDet implements Serializable {
	private static final long serialVersionUID = 1L;
	private PsPedtmkDetPK id = new PsPedtmkDetPK();
	private Long idArt;
	private Long psTiCveN;
	private Long ptdCantN;
	private Long ptdConsecN;
	private Long ptdCotN;
	private String ptdCveStr;
	private Double ptdDescN;
	private String ptdEstStr;
	private Long ptdExconN;
	private Date ptdFecDt;
	private Long ptdOferN;
	private Long ptdOpcN;
	private Double ptdPrecN;
	private Long ptdPromN;
	private Double taCveN;

	@EmbeddedId
	public PsPedtmkDetPK getId() {
		return this.id;
	}

	public void setId(PsPedtmkDetPK id) {
		this.id = id;
	}

	@Column(name = "ID_ART")
	public Long getIdArt() {
		return this.idArt;
	}

	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}

	@Column(name = "PS_TI_CVE_N")
	public Long getPsTiCveN() {
		return this.psTiCveN;
	}

	public void setPsTiCveN(Long psTiCveN) {
		this.psTiCveN = psTiCveN;
	}

	@Column(name = "PTD_CANT_N")
	public Long getPtdCantN() {
		return this.ptdCantN;
	}

	public void setPtdCantN(Long ptdCantN) {
		this.ptdCantN = ptdCantN;
	}

	@Column(name = "PTD_CONSEC_N")
	public Long getPtdConsecN() {
		return this.ptdConsecN;
	}

	public void setPtdConsecN(Long ptdConsecN) {
		this.ptdConsecN = ptdConsecN;
	}

	@Column(name = "PTD_COT_N")
	public Long getPtdCotN() {
		return this.ptdCotN;
	}

	public void setPtdCotN(Long ptdCotN) {
		this.ptdCotN = ptdCotN;
	}

	@Column(name = "PTD_CVE_STR")
	public String getPtdCveStr() {
		return this.ptdCveStr;
	}

	public void setPtdCveStr(String ptdCveStr) {
		this.ptdCveStr = ptdCveStr;
	}

	@Column(name = "PTD_DESC_N")
	public Double getPtdDescN() {
		return this.ptdDescN;
	}

	public void setPtdDescN(Double ptdDescN) {
		this.ptdDescN = ptdDescN;
	}

	@Column(name = "PTD_EST_STR")
	public String getPtdEstStr() {
		return this.ptdEstStr;
	}

	public void setPtdEstStr(String ptdEstStr) {
		this.ptdEstStr = ptdEstStr;
	}

	@Column(name = "PTD_EXCON_N")
	public Long getPtdExconN() {
		return this.ptdExconN;
	}

	public void setPtdExconN(Long ptdExconN) {
		this.ptdExconN = ptdExconN;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PTD_FEC_DT")
	public Date getPtdFecDt() {
		return this.ptdFecDt;
	}

	public void setPtdFecDt(Date ptdFecDt) {
		this.ptdFecDt = ptdFecDt;
	}

	@Column(name = "PTD_OFER_N")
	public Long getPtdOferN() {
		return this.ptdOferN;
	}

	public void setPtdOferN(Long ptdOferN) {
		this.ptdOferN = ptdOferN;
	}

	@Column(name = "PTD_OPC_N")
	public Long getPtdOpcN() {
		return this.ptdOpcN;
	}

	public void setPtdOpcN(Long ptdOpcN) {
		this.ptdOpcN = ptdOpcN;
	}

	@Column(name = "PTD_PREC_N")
	public Double getPtdPrecN() {
		return this.ptdPrecN;
	}

	public void setPtdPrecN(Double ptdPrecN) {
		this.ptdPrecN = ptdPrecN;
	}

	@Column(name = "PTD_PROM_N")
	public Long getPtdPromN() {
		return this.ptdPromN;
	}

	public void setPtdPromN(Long ptdPromN) {
		this.ptdPromN = ptdPromN;
	}

	@Column(name = "TA_CVE_N")
	public Double getTaCveN() {
		return this.taCveN;
	}

	public void setTaCveN(Double taCveN) {
		this.taCveN = taCveN;
	}
}