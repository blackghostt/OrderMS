package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.PsPedtmkPK;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PS_PEDTMK")
public class PsPedtmk implements Serializable {
	private static final long serialVersionUID = 1L;
	private PsPedtmkPK id = new PsPedtmkPK();
	private Long cjCveN;
	private Long nvNotaN;
	private Long pqIdN;
	private Double ptCosenvN;
	private Double ptDescN;
	private Long ptEnviowebN;
	private String ptEstStr;
	private Date ptFecDt;
	private String ptGuiaStr;
	private Double ptImporteN;
	private Long ptNimpN;
	private Long ptNresurN;
	private Long ptNumRelN;
	private Long ptParesN;
	private Double ptPesoN;
	private Long ptRefN;
	private Long ptResurN;
	private Double ptSegmensN;
	private Integer ptSodEnvN;
	private Integer ptSodFacN;
	private String ptTipStr;
	private Long ptTotpaqN;
	private String soIdStr;
	private String usrCvePstr;
	private Long ptOnlineN;

	@EmbeddedId
	public PsPedtmkPK getId() {
		return this.id;
	}

	public void setId(PsPedtmkPK id) {
		this.id = id;
	}

	@Column(name = "CJ_CVE_N")
	public Long getCjCveN() {
		return this.cjCveN;
	}

	public void setCjCveN(Long cjCveN) {
		this.cjCveN = cjCveN;
	}

	@Column(name = "NV_NOTA_N")
	public Long getNvNotaN() {
		return this.nvNotaN;
	}

	public void setNvNotaN(Long nvNotaN) {
		this.nvNotaN = nvNotaN;
	}

	@Column(name = "PQ_ID_N")
	public Long getPqIdN() {
		return this.pqIdN;
	}

	public void setPqIdN(Long pqIdN) {
		this.pqIdN = pqIdN;
	}

	@Column(name = "PT_COSENV_N")
	public Double getPtCosenvN() {
		return this.ptCosenvN;
	}

	public void setPtCosenvN(Double ptCosenvN) {
		this.ptCosenvN = ptCosenvN;
	}

	@Column(name = "PT_DESC_N")
	public Double getPtDescN() {
		return this.ptDescN;
	}

	public void setPtDescN(Double ptDescN) {
		this.ptDescN = ptDescN;
	}

	@Column(name = "PT_ENVIOWEB_N")
	public Long getPtEnviowebN() {
		return this.ptEnviowebN;
	}

	public void setPtEnviowebN(Long ptEnviowebN) {
		this.ptEnviowebN = ptEnviowebN;
	}

	@Column(name = "PT_EST_STR")
	public String getPtEstStr() {
		return this.ptEstStr;
	}

	public void setPtEstStr(String ptEstStr) {
		this.ptEstStr = ptEstStr;
	}

	@Column(name = "PT_FEC_DT")
	public Date getPtFecDt() {
		return this.ptFecDt;
	}

	public void setPtFecDt(Date ptFecDt) {
		this.ptFecDt = ptFecDt;
	}

	@Column(name = "PT_GUIA_STR")
	public String getPtGuiaStr() {
		return this.ptGuiaStr;
	}

	public void setPtGuiaStr(String ptGuiaStr) {
		this.ptGuiaStr = ptGuiaStr;
	}

	@Column(name = "PT_IMPORTE_N")
	public Double getPtImporteN() {
		return this.ptImporteN;
	}

	public void setPtImporteN(Double ptImporteN) {
		this.ptImporteN = ptImporteN;
	}

	@Column(name = "PT_NIMP_N")
	public Long getPtNimpN() {
		return this.ptNimpN;
	}

	public void setPtNimpN(Long ptNimpN) {
		this.ptNimpN = ptNimpN;
	}

	@Column(name = "PT_NRESUR_N")
	public Long getPtNresurN() {
		return this.ptNresurN;
	}

	public void setPtNresurN(Long ptNresurN) {
		this.ptNresurN = ptNresurN;
	}

	@Column(name = "PT_NUM_REL_N")
	public Long getPtNumRelN() {
		return this.ptNumRelN;
	}

	public void setPtNumRelN(Long ptNumRelN) {
		this.ptNumRelN = ptNumRelN;
	}

	@Column(name = "PT_PARES_N")
	public Long getPtParesN() {
		return this.ptParesN;
	}

	public void setPtParesN(Long ptParesN) {
		this.ptParesN = ptParesN;
	}

	@Column(name = "PT_PESO_N")
	public Double getPtPesoN() {
		return this.ptPesoN;
	}

	public void setPtPesoN(Double ptPesoN) {
		this.ptPesoN = ptPesoN;
	}

	@Column(name = "PT_REF_N")
	public Long getPtRefN() {
		return this.ptRefN;
	}

	public void setPtRefN(Long ptRefN) {
		this.ptRefN = ptRefN;
	}

	@Column(name = "PT_RESUR_N")
	public Long getPtResurN() {
		return this.ptResurN;
	}

	public void setPtResurN(Long ptResurN) {
		this.ptResurN = ptResurN;
	}

	@Column(name = "PT_SEGMENS_N")
	public Double getPtSegmensN() {
		return this.ptSegmensN;
	}

	public void setPtSegmensN(Double ptSegmensN) {
		this.ptSegmensN = ptSegmensN;
	}

	@Column(name = "PT_SOD_ENV_N")
	public Integer getPtSodEnvN() {
		return this.ptSodEnvN;
	}

	public void setPtSodEnvN(Integer ptSodEnvN) {
		this.ptSodEnvN = ptSodEnvN;
	}

	@Column(name = "PT_SOD_FAC_N")
	public Integer getPtSodFacN() {
		return this.ptSodFacN;
	}

	public void setPtSodFacN(Integer ptSodFacN) {
		this.ptSodFacN = ptSodFacN;
	}

	@Column(name = "PT_TIP_STR")
	public String getPtTipStr() {
		return this.ptTipStr;
	}

	public void setPtTipStr(String ptTipStr) {
		this.ptTipStr = ptTipStr;
	}

	@Column(name = "PT_TOTPAQ_N")
	public Long getPtTotpaqN() {
		return this.ptTotpaqN;
	}

	public void setPtTotpaqN(Long ptTotpaqN) {
		this.ptTotpaqN = ptTotpaqN;
	}

	@Column(name = "SO_ID_STR")
	public String getSoIdStr() {
		return this.soIdStr;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	@Column(name = "USR_CVE_PSTR")
	public String getUsrCvePstr() {
		return this.usrCvePstr;
	}

	public void setUsrCvePstr(String usrCvePstr) {
		this.usrCvePstr = usrCvePstr;
	}

	@Column(name = "PT_ONLINE_N")
	public Long getPtOnlineN() {
		return this.ptOnlineN;
	}

	public void setPtOnlineN(Long ptOnlineN) {
		this.ptOnlineN = ptOnlineN;
	}
}