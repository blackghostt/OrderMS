package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PS_SOCIOS")
@NamedQueries({ @NamedQuery(name = "Member.count", query = "SELECT COUNT(m) FROM Member m") })
public class Member implements Serializable {
	private static final long serialVersionUID = -2124540708383630264L;
	@Id
	@Column(name = "SO_ID_STR")
	private String soIdStr;
	@Column(name = "CLL_NUMLLAM_N")
	private Long cllNumllamN;
	@Column(name = "ED_CVE_N")
	private Integer edCveN;
	@Column(name = "MU_CVE_N")
	private Integer muCveN;
	@Column(name = "PA_CVE_N")
	private Integer paCveN;
	@Column(name = "PRT_ID_N")
	private Long prtIdN;
	@Column(name = "PS_SO_ID_STR")
	private String psSoIdStr;
	@Column(name = "SAPS_CVE_STR")
	private String sapsCveStr;
	@Column(name = "SE_COM_STR")
	private String seComStr;
	@Column(name = "SO_AMAT_STR")
	private String soAmatStr;
	@Column(name = "SO_APAT_STR")
	private String soApatStr;
	@Column(name = "SO_CALLE_STR")
	private String soCalleStr;
	@Column(name = "SO_CCOMP_N")
	private Long soCcompN;
	@Column(name = "SO_CD_STR")
	private String soCdStr;
	@Column(name = "SO_COL_STR")
	private String soColStr;
	@Column(name = "SO_CONTMK_STR")
	private String soContmkStr;
	@Column(name = "SO_CP_STR")
	private String soCpStr;
	@Column(name = "SO_CVE1_STR")
	private String soCve1Str;
	@Column(name = "SO_CVE2_STR")
	private String soCve2Str;
	@Column(name = "SO_CVE3_STR")
	private String soCve3Str;
	@Column(name = "SO_CVE4_STR")
	private String soCve4Str;
	@Column(name = "SO_CVE5_STR")
	private String soCve5Str;
	@Column(name = "SO_CVE6_STR")
	private String soCve6Str;
	@Column(name = "SO_CVEELECTOR_STR")
	private String soCveelectorStr;
	@Column(name = "SO_DG_STR")
	private String soDgStr;
	@Column(name = "SO_DIRGR_STR")
	private String soDirgrStr;
	@Column(name = "SO_DV_STR")
	private String soDvStr;
	@Column(name = "SO_EMAIL_STR")
	private String soEmailStr;
	@Column(name = "SO_EST_STR")
	private String soEstStr;
	@Column(name = "SO_EXT4_STR")
	private String soExt4Str;
	@Column(name = "SO_EXT5_STR")
	private String soExt5Str;
	@Column(name = "SO_FALTA_DT")
	private Date soFaltaDt;
	@Column(name = "SO_FNAC_DT")
	private Timestamp soFnacDt;
	@Column(name = "SO_FREG_DT")
	private Date soFregDt;
	@Column(name = "SO_HOR1_N")
	private Long soHor1N;
	@Column(name = "SO_HOR2_N")
	private Long soHor2N;
	@Column(name = "SO_HOR3_N")
	private Long soHor3N;
	@Column(name = "SO_HOR4_N")
	private Long soHor4N;
	@Column(name = "SO_HOR5_N")
	private Long soHor5N;
	@Column(name = "SO_IDPADRE_STR")
	private String soIdpadreStr;
	@Column(name = "SO_IDRECOM_STR")
	private String soIdrecomStr;
	@Column(name = "SO_INTERIOR_STR")
	private String soInteriorStr;
	@Column(name = "SO_LADA1_STR")
	private String soLada1Str;
	@Column(name = "SO_LADA2_STR")
	private String soLada2Str;
	@Column(name = "SO_LADA3_STR")
	private String soLada3Str;
	@Column(name = "SO_LADA4_STR")
	private String soLada4Str;
	@Column(name = "SO_LADA5_STR")
	private String soLada5Str;
	@Column(name = "SO_LADA6_STR")
	private String soLada6Str;
	@Column(name = "SO_LOTE_STR")
	private String soLoteStr;
	@Column(name = "SO_MANZANA_STR")
	private String soManzanaStr;
	@Column(name = "SO_MUNIC_STR")
	private String soMunicStr;
	@Column(name = "SO_NCRED_N")
	private Long soNcredN;
	@Column(name = "SO_NIVEL_STR")
	private String soNivelStr;
	@Column(name = "SO_NOM_STR")
	private String soNomStr;
	@Column(name = "SO_NOMINA_N")
	private Long soNominaN;
	@Column(name = "SO_NUM_STR")
	private String soNumStr;
	@Column(name = "SO_NUMINT_STR")
	private String soNumintStr;
	@Column(name = "SO_NVOSOC_DT")
	private Date soNvosocDt;
	@Column(name = "SO_REF_STR")
	private String soRefStr;
	@Column(name = "SO_SALD_N\t")
	private Double soSaldN;
	@Column(name = "SO_SALDANT_N")
	private Double soSaldantN;
	@Column(name = "SO_SEXO_STR")
	private String soSexoStr;
	@Column(name = "SO_TEL1_STR")
	private String soTel1Str;
	@Column(name = "SO_TEL2_STR")
	private String soTel2Str;
	@Column(name = "SO_TEL3_STR")
	private String soTel3Str;
	@Column(name = "SO_TEL4_STR")
	private String soTel4Str;
	@Column(name = "SO_TEL5_STR")
	private String soTel5Str;
	@Column(name = "SO_TEL6_STR")
	private String soTel6Str;
	@Column(name = "SO_TIPO_STR")
	private String soTipoStr;
	@Column(name = "SO_VIG_DT")
	private Date soVigDt;
	@Column(name = "TI_CVE_N")
	private Integer tiCveN;
	@Column(name = "TS_CVE_N")
	private Long tsCveN;
	@Column(name = "USR_CVE_PSTR")
	private String usrCvePstr;

	public String getSoIdStr() {
		return this.soIdStr;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	public Long getCllNumllamN() {
		return this.cllNumllamN;
	}

	public void setCllNumllamN(Long cllNumllamN) {
		this.cllNumllamN = cllNumllamN;
	}

	public Integer getEdCveN() {
		return this.edCveN;
	}

	public void setEdCveN(Integer edCveN) {
		this.edCveN = edCveN;
	}

	public Integer getMuCveN() {
		return this.muCveN;
	}

	public void setMuCveN(Integer muCveN) {
		this.muCveN = muCveN;
	}

	public Integer getPaCveN() {
		return this.paCveN;
	}

	public void setPaCveN(Integer paCveN) {
		this.paCveN = paCveN;
	}

	public Long getPrtIdN() {
		return this.prtIdN;
	}

	public void setPrtIdN(Long prtIdN) {
		this.prtIdN = prtIdN;
	}

	public String getPsSoIdStr() {
		return this.psSoIdStr;
	}

	public void setPsSoIdStr(String psSoIdStr) {
		this.psSoIdStr = psSoIdStr;
	}

	public String getSapsCveStr() {
		return this.sapsCveStr;
	}

	public void setSapsCveStr(String sapsCveStr) {
		this.sapsCveStr = sapsCveStr;
	}

	public String getSeComStr() {
		return this.seComStr;
	}

	public void setSeComStr(String seComStr) {
		this.seComStr = seComStr;
	}

	public String getSoAmatStr() {
		return this.soAmatStr;
	}

	public void setSoAmatStr(String soAmatStr) {
		this.soAmatStr = soAmatStr;
	}

	public String getSoApatStr() {
		return this.soApatStr;
	}

	public void setSoApatStr(String soApatStr) {
		this.soApatStr = soApatStr;
	}

	public String getSoCalleStr() {
		return this.soCalleStr;
	}

	public void setSoCalleStr(String soCalleStr) {
		this.soCalleStr = soCalleStr;
	}

	public Long getSoCcompN() {
		return this.soCcompN;
	}

	public void setSoCcompN(Long soCcompN) {
		this.soCcompN = soCcompN;
	}

	public String getSoCdStr() {
		return this.soCdStr;
	}

	public void setSoCdStr(String soCdStr) {
		this.soCdStr = soCdStr;
	}

	public String getSoColStr() {
		return this.soColStr;
	}

	public void setSoColStr(String soColStr) {
		this.soColStr = soColStr;
	}

	public String getSoContmkStr() {
		return this.soContmkStr;
	}

	public void setSoContmkStr(String soContmkStr) {
		this.soContmkStr = soContmkStr;
	}

	public String getSoCpStr() {
		return this.soCpStr;
	}

	public void setSoCpStr(String soCpStr) {
		this.soCpStr = soCpStr;
	}

	public String getSoCve1Str() {
		return this.soCve1Str;
	}

	public void setSoCve1Str(String soCve1Str) {
		this.soCve1Str = soCve1Str;
	}

	public String getSoCve2Str() {
		return this.soCve2Str;
	}

	public void setSoCve2Str(String soCve2Str) {
		this.soCve2Str = soCve2Str;
	}

	public String getSoCve3Str() {
		return this.soCve3Str;
	}

	public void setSoCve3Str(String soCve3Str) {
		this.soCve3Str = soCve3Str;
	}

	public String getSoCve4Str() {
		return this.soCve4Str;
	}

	public void setSoCve4Str(String soCve4Str) {
		this.soCve4Str = soCve4Str;
	}

	public String getSoCve5Str() {
		return this.soCve5Str;
	}

	public void setSoCve5Str(String soCve5Str) {
		this.soCve5Str = soCve5Str;
	}

	public String getSoCve6Str() {
		return this.soCve6Str;
	}

	public void setSoCve6Str(String soCve6Str) {
		this.soCve6Str = soCve6Str;
	}

	public String getSoCveelectorStr() {
		return this.soCveelectorStr;
	}

	public void setSoCveelectorStr(String soCveelectorStr) {
		this.soCveelectorStr = soCveelectorStr;
	}

	public String getSoDgStr() {
		return this.soDgStr;
	}

	public void setSoDgStr(String soDgStr) {
		this.soDgStr = soDgStr;
	}

	public String getSoDirgrStr() {
		return this.soDirgrStr;
	}

	public void setSoDirgrStr(String soDirgrStr) {
		this.soDirgrStr = soDirgrStr;
	}

	public String getSoDvStr() {
		return this.soDvStr;
	}

	public void setSoDvStr(String soDvStr) {
		this.soDvStr = soDvStr;
	}

	public String getSoEmailStr() {
		return this.soEmailStr;
	}

	public void setSoEmailStr(String soEmailStr) {
		this.soEmailStr = soEmailStr;
	}

	public String getSoEstStr() {
		return this.soEstStr;
	}

	public void setSoEstStr(String soEstStr) {
		this.soEstStr = soEstStr;
	}

	public String getSoExt4Str() {
		return this.soExt4Str;
	}

	public void setSoExt4Str(String soExt4Str) {
		this.soExt4Str = soExt4Str;
	}

	public String getSoExt5Str() {
		return this.soExt5Str;
	}

	public void setSoExt5Str(String soExt5Str) {
		this.soExt5Str = soExt5Str;
	}

	public Date getSoFaltaDt() {
		return this.soFaltaDt;
	}

	public void setSoFaltaDt(Date soFaltaDt) {
		this.soFaltaDt = soFaltaDt;
	}

	public Timestamp getSoFnacDt() {
		return this.soFnacDt;
	}

	public void setSoFnacDt(Timestamp soFnacDt) {
		this.soFnacDt = soFnacDt;
	}

	public Date getSoFregDt() {
		return this.soFregDt;
	}

	public void setSoFregDt(Date soFregDt) {
		this.soFregDt = soFregDt;
	}

	public Long getSoHor1N() {
		return this.soHor1N;
	}

	public void setSoHor1N(Long soHor1N) {
		this.soHor1N = soHor1N;
	}

	public Long getSoHor2N() {
		return this.soHor2N;
	}

	public void setSoHor2N(Long soHor2N) {
		this.soHor2N = soHor2N;
	}

	public Long getSoHor3N() {
		return this.soHor3N;
	}

	public void setSoHor3N(Long soHor3N) {
		this.soHor3N = soHor3N;
	}

	public Long getSoHor4N() {
		return this.soHor4N;
	}

	public void setSoHor4N(Long soHor4N) {
		this.soHor4N = soHor4N;
	}

	public Long getSoHor5N() {
		return this.soHor5N;
	}

	public void setSoHor5N(Long soHor5N) {
		this.soHor5N = soHor5N;
	}

	public String getSoIdpadreStr() {
		return this.soIdpadreStr;
	}

	public void setSoIdpadreStr(String soIdpadreStr) {
		this.soIdpadreStr = soIdpadreStr;
	}

	public String getSoIdrecomStr() {
		return this.soIdrecomStr;
	}

	public void setSoIdrecomStr(String soIdrecomStr) {
		this.soIdrecomStr = soIdrecomStr;
	}

	public String getSoInteriorStr() {
		return this.soInteriorStr;
	}

	public void setSoInteriorStr(String soInteriorStr) {
		this.soInteriorStr = soInteriorStr;
	}

	public String getSoLada1Str() {
		return this.soLada1Str;
	}

	public void setSoLada1Str(String soLada1Str) {
		this.soLada1Str = soLada1Str;
	}

	public String getSoLada2Str() {
		return this.soLada2Str;
	}

	public void setSoLada2Str(String soLada2Str) {
		this.soLada2Str = soLada2Str;
	}

	public String getSoLada3Str() {
		return this.soLada3Str;
	}

	public void setSoLada3Str(String soLada3Str) {
		this.soLada3Str = soLada3Str;
	}

	public String getSoLada4Str() {
		return this.soLada4Str;
	}

	public void setSoLada4Str(String soLada4Str) {
		this.soLada4Str = soLada4Str;
	}

	public String getSoLada5Str() {
		return this.soLada5Str;
	}

	public void setSoLada5Str(String soLada5Str) {
		this.soLada5Str = soLada5Str;
	}

	public String getSoLada6Str() {
		return this.soLada6Str;
	}

	public void setSoLada6Str(String soLada6Str) {
		this.soLada6Str = soLada6Str;
	}

	public String getSoLoteStr() {
		return this.soLoteStr;
	}

	public void setSoLoteStr(String soLoteStr) {
		this.soLoteStr = soLoteStr;
	}

	public String getSoManzanaStr() {
		return this.soManzanaStr;
	}

	public void setSoManzanaStr(String soManzanaStr) {
		this.soManzanaStr = soManzanaStr;
	}

	public String getSoMunicStr() {
		return this.soMunicStr;
	}

	public void setSoMunicStr(String soMunicStr) {
		this.soMunicStr = soMunicStr;
	}

	public Long getSoNcredN() {
		return this.soNcredN;
	}

	public void setSoNcredN(Long soNcredN) {
		this.soNcredN = soNcredN;
	}

	public String getSoNivelStr() {
		return this.soNivelStr;
	}

	public void setSoNivelStr(String soNivelStr) {
		this.soNivelStr = soNivelStr;
	}

	public String getSoNomStr() {
		return this.soNomStr;
	}

	public void setSoNomStr(String soNomStr) {
		this.soNomStr = soNomStr;
	}

	public Long getSoNominaN() {
		return this.soNominaN;
	}

	public void setSoNominaN(Long soNominaN) {
		this.soNominaN = soNominaN;
	}

	public String getSoNumStr() {
		return this.soNumStr;
	}

	public void setSoNumStr(String soNumStr) {
		this.soNumStr = soNumStr;
	}

	public String getSoNumintStr() {
		return this.soNumintStr;
	}

	public void setSoNumintStr(String soNumintStr) {
		this.soNumintStr = soNumintStr;
	}

	public Date getSoNvosocDt() {
		return this.soNvosocDt;
	}

	public void setSoNvosocDt(Date soNvosocDt) {
		this.soNvosocDt = soNvosocDt;
	}

	public String getSoRefStr() {
		return this.soRefStr;
	}

	public void setSoRefStr(String soRefStr) {
		this.soRefStr = soRefStr;
	}

	public Double getSoSaldN() {
		return this.soSaldN;
	}

	public void setSoSaldN(Double soSaldN) {
		this.soSaldN = soSaldN;
	}

	public Double getSoSaldantN() {
		return this.soSaldantN;
	}

	public void setSoSaldantN(Double soSaldantN) {
		this.soSaldantN = soSaldantN;
	}

	public String getSoSexoStr() {
		return this.soSexoStr;
	}

	public void setSoSexoStr(String soSexoStr) {
		this.soSexoStr = soSexoStr;
	}

	public String getSoTel1Str() {
		return this.soTel1Str;
	}

	public void setSoTel1Str(String soTel1Str) {
		this.soTel1Str = soTel1Str;
	}

	public String getSoTel2Str() {
		return this.soTel2Str;
	}

	public void setSoTel2Str(String soTel2Str) {
		this.soTel2Str = soTel2Str;
	}

	public String getSoTel3Str() {
		return this.soTel3Str;
	}

	public void setSoTel3Str(String soTel3Str) {
		this.soTel3Str = soTel3Str;
	}

	public String getSoTel4Str() {
		return this.soTel4Str;
	}

	public void setSoTel4Str(String soTel4Str) {
		this.soTel4Str = soTel4Str;
	}

	public String getSoTel5Str() {
		return this.soTel5Str;
	}

	public void setSoTel5Str(String soTel5Str) {
		this.soTel5Str = soTel5Str;
	}

	public String getSoTel6Str() {
		return this.soTel6Str;
	}

	public void setSoTel6Str(String soTel6Str) {
		this.soTel6Str = soTel6Str;
	}

	public String getSoTipoStr() {
		return this.soTipoStr;
	}

	public void setSoTipoStr(String soTipoStr) {
		this.soTipoStr = soTipoStr;
	}

	public Date getSoVigDt() {
		return this.soVigDt;
	}

	public void setSoVigDt(Date soVigDt) {
		this.soVigDt = soVigDt;
	}

	public Integer getTiCveN() {
		return this.tiCveN;
	}

	public void setTiCveN(Integer tiCveN) {
		this.tiCveN = tiCveN;
	}

	public Long getTsCveN() {
		return this.tsCveN;
	}

	public void setTsCveN(Long tsCveN) {
		this.tsCveN = tsCveN;
	}

	public String getUsrCvePstr() {
		return this.usrCvePstr;
	}

	public void setUsrCvePstr(String usrCvePstr) {
		this.usrCvePstr = usrCvePstr;
	}

	public String toString() {
		return "Member(soIdStr=" + this.getSoIdStr() + ", cllNumllamN=" + this.getCllNumllamN() + ", edCveN="
				+ this.getEdCveN() + ", muCveN=" + this.getMuCveN() + ", paCveN=" + this.getPaCveN() + ", prtIdN="
				+ this.getPrtIdN() + ", psSoIdStr=" + this.getPsSoIdStr() + ", sapsCveStr=" + this.getSapsCveStr()
				+ ", seComStr=" + this.getSeComStr() + ", soAmatStr=" + this.getSoAmatStr() + ", soApatStr="
				+ this.getSoApatStr() + ", soCalleStr=" + this.getSoCalleStr() + ", soCcompN=" + this.getSoCcompN()
				+ ", soCdStr=" + this.getSoCdStr() + ", soColStr=" + this.getSoColStr() + ", soContmkStr="
				+ this.getSoContmkStr() + ", soCpStr=" + this.getSoCpStr() + ", soCve1Str=" + this.getSoCve1Str()
				+ ", soCve2Str=" + this.getSoCve2Str() + ", soCve3Str=" + this.getSoCve3Str() + ", soCve4Str="
				+ this.getSoCve4Str() + ", soCve5Str=" + this.getSoCve5Str() + ", soCve6Str=" + this.getSoCve6Str()
				+ ", soCveelectorStr=" + this.getSoCveelectorStr() + ", soDgStr=" + this.getSoDgStr() + ", soDirgrStr="
				+ this.getSoDirgrStr() + ", soDvStr=" + this.getSoDvStr() + ", soEmailStr=" + this.getSoEmailStr()
				+ ", soEstStr=" + this.getSoEstStr() + ", soExt4Str=" + this.getSoExt4Str() + ", soExt5Str="
				+ this.getSoExt5Str() + ", soFaltaDt=" + this.getSoFaltaDt() + ", soFnacDt=" + this.getSoFnacDt()
				+ ", soFregDt=" + this.getSoFregDt() + ", soHor1N=" + this.getSoHor1N() + ", soHor2N="
				+ this.getSoHor2N() + ", soHor3N=" + this.getSoHor3N() + ", soHor4N=" + this.getSoHor4N() + ", soHor5N="
				+ this.getSoHor5N() + ", soIdpadreStr=" + this.getSoIdpadreStr() + ", soIdrecomStr="
				+ this.getSoIdrecomStr() + ", soInteriorStr=" + this.getSoInteriorStr() + ", soLada1Str="
				+ this.getSoLada1Str() + ", soLada2Str=" + this.getSoLada2Str() + ", soLada3Str=" + this.getSoLada3Str()
				+ ", soLada4Str=" + this.getSoLada4Str() + ", soLada5Str=" + this.getSoLada5Str() + ", soLada6Str="
				+ this.getSoLada6Str() + ", soLoteStr=" + this.getSoLoteStr() + ", soManzanaStr="
				+ this.getSoManzanaStr() + ", soMunicStr=" + this.getSoMunicStr() + ", soNcredN=" + this.getSoNcredN()
				+ ", soNivelStr=" + this.getSoNivelStr() + ", soNomStr=" + this.getSoNomStr() + ", soNominaN="
				+ this.getSoNominaN() + ", soNumStr=" + this.getSoNumStr() + ", soNumintStr=" + this.getSoNumintStr()
				+ ", soNvosocDt=" + this.getSoNvosocDt() + ", soRefStr=" + this.getSoRefStr() + ", soSaldN="
				+ this.getSoSaldN() + ", soSaldantN=" + this.getSoSaldantN() + ", soSexoStr=" + this.getSoSexoStr()
				+ ", soTel1Str=" + this.getSoTel1Str() + ", soTel2Str=" + this.getSoTel2Str() + ", soTel3Str="
				+ this.getSoTel3Str() + ", soTel4Str=" + this.getSoTel4Str() + ", soTel5Str=" + this.getSoTel5Str()
				+ ", soTel6Str=" + this.getSoTel6Str() + ", soTipoStr=" + this.getSoTipoStr() + ", soVigDt="
				+ this.getSoVigDt() + ", tiCveN=" + this.getTiCveN() + ", tsCveN=" + this.getTsCveN() + ", usrCvePstr="
				+ this.getUsrCvePstr() + ")";
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Member)) {
			return false;
		} else {
			Member other = (Member) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label887: {
					String this$soIdStr = this.getSoIdStr();
					String other$soIdStr = other.getSoIdStr();
					if (this$soIdStr == null) {
						if (other$soIdStr == null) {
							break label887;
						}
					} else if (this$soIdStr.equals(other$soIdStr)) {
						break label887;
					}

					return false;
				}

				Long this$cllNumllamN = this.getCllNumllamN();
				Long other$cllNumllamN = other.getCllNumllamN();
				if (this$cllNumllamN == null) {
					if (other$cllNumllamN != null) {
						return false;
					}
				} else if (!this$cllNumllamN.equals(other$cllNumllamN)) {
					return false;
				}

				label873: {
					Integer this$edCveN = this.getEdCveN();
					Integer other$edCveN = other.getEdCveN();
					if (this$edCveN == null) {
						if (other$edCveN == null) {
							break label873;
						}
					} else if (this$edCveN.equals(other$edCveN)) {
						break label873;
					}

					return false;
				}

				Integer this$muCveN = this.getMuCveN();
				Integer other$muCveN = other.getMuCveN();
				if (this$muCveN == null) {
					if (other$muCveN != null) {
						return false;
					}
				} else if (!this$muCveN.equals(other$muCveN)) {
					return false;
				}

				label859: {
					Integer this$paCveN = this.getPaCveN();
					Integer other$paCveN = other.getPaCveN();
					if (this$paCveN == null) {
						if (other$paCveN == null) {
							break label859;
						}
					} else if (this$paCveN.equals(other$paCveN)) {
						break label859;
					}

					return false;
				}

				Long this$prtIdN = this.getPrtIdN();
				Long other$prtIdN = other.getPrtIdN();
				if (this$prtIdN == null) {
					if (other$prtIdN != null) {
						return false;
					}
				} else if (!this$prtIdN.equals(other$prtIdN)) {
					return false;
				}

				label845: {
					String this$psSoIdStr = this.getPsSoIdStr();
					String other$psSoIdStr = other.getPsSoIdStr();
					if (this$psSoIdStr == null) {
						if (other$psSoIdStr == null) {
							break label845;
						}
					} else if (this$psSoIdStr.equals(other$psSoIdStr)) {
						break label845;
					}

					return false;
				}

				label838: {
					String this$sapsCveStr = this.getSapsCveStr();
					String other$sapsCveStr = other.getSapsCveStr();
					if (this$sapsCveStr == null) {
						if (other$sapsCveStr == null) {
							break label838;
						}
					} else if (this$sapsCveStr.equals(other$sapsCveStr)) {
						break label838;
					}

					return false;
				}

				String this$seComStr = this.getSeComStr();
				String other$seComStr = other.getSeComStr();
				if (this$seComStr == null) {
					if (other$seComStr != null) {
						return false;
					}
				} else if (!this$seComStr.equals(other$seComStr)) {
					return false;
				}

				label824: {
					String this$soAmatStr = this.getSoAmatStr();
					String other$soAmatStr = other.getSoAmatStr();
					if (this$soAmatStr == null) {
						if (other$soAmatStr == null) {
							break label824;
						}
					} else if (this$soAmatStr.equals(other$soAmatStr)) {
						break label824;
					}

					return false;
				}

				label817: {
					String this$soApatStr = this.getSoApatStr();
					String other$soApatStr = other.getSoApatStr();
					if (this$soApatStr == null) {
						if (other$soApatStr == null) {
							break label817;
						}
					} else if (this$soApatStr.equals(other$soApatStr)) {
						break label817;
					}

					return false;
				}

				String this$soCalleStr = this.getSoCalleStr();
				String other$soCalleStr = other.getSoCalleStr();
				if (this$soCalleStr == null) {
					if (other$soCalleStr != null) {
						return false;
					}
				} else if (!this$soCalleStr.equals(other$soCalleStr)) {
					return false;
				}

				Long this$soCcompN = this.getSoCcompN();
				Long other$soCcompN = other.getSoCcompN();
				if (this$soCcompN == null) {
					if (other$soCcompN != null) {
						return false;
					}
				} else if (!this$soCcompN.equals(other$soCcompN)) {
					return false;
				}

				label796: {
					String this$soCdStr = this.getSoCdStr();
					String other$soCdStr = other.getSoCdStr();
					if (this$soCdStr == null) {
						if (other$soCdStr == null) {
							break label796;
						}
					} else if (this$soCdStr.equals(other$soCdStr)) {
						break label796;
					}

					return false;
				}

				String this$soColStr = this.getSoColStr();
				String other$soColStr = other.getSoColStr();
				if (this$soColStr == null) {
					if (other$soColStr != null) {
						return false;
					}
				} else if (!this$soColStr.equals(other$soColStr)) {
					return false;
				}

				String this$soContmkStr = this.getSoContmkStr();
				String other$soContmkStr = other.getSoContmkStr();
				if (this$soContmkStr == null) {
					if (other$soContmkStr != null) {
						return false;
					}
				} else if (!this$soContmkStr.equals(other$soContmkStr)) {
					return false;
				}

				label775: {
					String this$soCpStr = this.getSoCpStr();
					String other$soCpStr = other.getSoCpStr();
					if (this$soCpStr == null) {
						if (other$soCpStr == null) {
							break label775;
						}
					} else if (this$soCpStr.equals(other$soCpStr)) {
						break label775;
					}

					return false;
				}

				String this$soCve1Str = this.getSoCve1Str();
				String other$soCve1Str = other.getSoCve1Str();
				if (this$soCve1Str == null) {
					if (other$soCve1Str != null) {
						return false;
					}
				} else if (!this$soCve1Str.equals(other$soCve1Str)) {
					return false;
				}

				label761: {
					String this$soCve2Str = this.getSoCve2Str();
					String other$soCve2Str = other.getSoCve2Str();
					if (this$soCve2Str == null) {
						if (other$soCve2Str == null) {
							break label761;
						}
					} else if (this$soCve2Str.equals(other$soCve2Str)) {
						break label761;
					}

					return false;
				}

				String this$soCve3Str = this.getSoCve3Str();
				String other$soCve3Str = other.getSoCve3Str();
				if (this$soCve3Str == null) {
					if (other$soCve3Str != null) {
						return false;
					}
				} else if (!this$soCve3Str.equals(other$soCve3Str)) {
					return false;
				}

				label747: {
					String this$soCve4Str = this.getSoCve4Str();
					String other$soCve4Str = other.getSoCve4Str();
					if (this$soCve4Str == null) {
						if (other$soCve4Str == null) {
							break label747;
						}
					} else if (this$soCve4Str.equals(other$soCve4Str)) {
						break label747;
					}

					return false;
				}

				String this$soCve5Str = this.getSoCve5Str();
				String other$soCve5Str = other.getSoCve5Str();
				if (this$soCve5Str == null) {
					if (other$soCve5Str != null) {
						return false;
					}
				} else if (!this$soCve5Str.equals(other$soCve5Str)) {
					return false;
				}

				label733: {
					String this$soCve6Str = this.getSoCve6Str();
					String other$soCve6Str = other.getSoCve6Str();
					if (this$soCve6Str == null) {
						if (other$soCve6Str == null) {
							break label733;
						}
					} else if (this$soCve6Str.equals(other$soCve6Str)) {
						break label733;
					}

					return false;
				}

				label726: {
					String this$soCveelectorStr = this.getSoCveelectorStr();
					String other$soCveelectorStr = other.getSoCveelectorStr();
					if (this$soCveelectorStr == null) {
						if (other$soCveelectorStr == null) {
							break label726;
						}
					} else if (this$soCveelectorStr.equals(other$soCveelectorStr)) {
						break label726;
					}

					return false;
				}

				String this$soDgStr = this.getSoDgStr();
				String other$soDgStr = other.getSoDgStr();
				if (this$soDgStr == null) {
					if (other$soDgStr != null) {
						return false;
					}
				} else if (!this$soDgStr.equals(other$soDgStr)) {
					return false;
				}

				label712: {
					String this$soDirgrStr = this.getSoDirgrStr();
					String other$soDirgrStr = other.getSoDirgrStr();
					if (this$soDirgrStr == null) {
						if (other$soDirgrStr == null) {
							break label712;
						}
					} else if (this$soDirgrStr.equals(other$soDirgrStr)) {
						break label712;
					}

					return false;
				}

				label705: {
					String this$soDvStr = this.getSoDvStr();
					String other$soDvStr = other.getSoDvStr();
					if (this$soDvStr == null) {
						if (other$soDvStr == null) {
							break label705;
						}
					} else if (this$soDvStr.equals(other$soDvStr)) {
						break label705;
					}

					return false;
				}

				String this$soEmailStr = this.getSoEmailStr();
				String other$soEmailStr = other.getSoEmailStr();
				if (this$soEmailStr == null) {
					if (other$soEmailStr != null) {
						return false;
					}
				} else if (!this$soEmailStr.equals(other$soEmailStr)) {
					return false;
				}

				String this$soEstStr = this.getSoEstStr();
				String other$soEstStr = other.getSoEstStr();
				if (this$soEstStr == null) {
					if (other$soEstStr != null) {
						return false;
					}
				} else if (!this$soEstStr.equals(other$soEstStr)) {
					return false;
				}

				label684: {
					String this$soExt4Str = this.getSoExt4Str();
					String other$soExt4Str = other.getSoExt4Str();
					if (this$soExt4Str == null) {
						if (other$soExt4Str == null) {
							break label684;
						}
					} else if (this$soExt4Str.equals(other$soExt4Str)) {
						break label684;
					}

					return false;
				}

				String this$soExt5Str = this.getSoExt5Str();
				String other$soExt5Str = other.getSoExt5Str();
				if (this$soExt5Str == null) {
					if (other$soExt5Str != null) {
						return false;
					}
				} else if (!this$soExt5Str.equals(other$soExt5Str)) {
					return false;
				}

				Date this$soFaltaDt = this.getSoFaltaDt();
				Date other$soFaltaDt = other.getSoFaltaDt();
				if (this$soFaltaDt == null) {
					if (other$soFaltaDt != null) {
						return false;
					}
				} else if (!this$soFaltaDt.equals(other$soFaltaDt)) {
					return false;
				}

				label663: {
					Timestamp this$soFnacDt = this.getSoFnacDt();
					Timestamp other$soFnacDt = other.getSoFnacDt();
					if (this$soFnacDt == null) {
						if (other$soFnacDt == null) {
							break label663;
						}
					} else if (this$soFnacDt.equals(other$soFnacDt)) {
						break label663;
					}

					return false;
				}

				Date this$soFregDt = this.getSoFregDt();
				Date other$soFregDt = other.getSoFregDt();
				if (this$soFregDt == null) {
					if (other$soFregDt != null) {
						return false;
					}
				} else if (!this$soFregDt.equals(other$soFregDt)) {
					return false;
				}

				label649: {
					Long this$soHor1N = this.getSoHor1N();
					Long other$soHor1N = other.getSoHor1N();
					if (this$soHor1N == null) {
						if (other$soHor1N == null) {
							break label649;
						}
					} else if (this$soHor1N.equals(other$soHor1N)) {
						break label649;
					}

					return false;
				}

				Long this$soHor2N = this.getSoHor2N();
				Long other$soHor2N = other.getSoHor2N();
				if (this$soHor2N == null) {
					if (other$soHor2N != null) {
						return false;
					}
				} else if (!this$soHor2N.equals(other$soHor2N)) {
					return false;
				}

				label635: {
					Long this$soHor3N = this.getSoHor3N();
					Long other$soHor3N = other.getSoHor3N();
					if (this$soHor3N == null) {
						if (other$soHor3N == null) {
							break label635;
						}
					} else if (this$soHor3N.equals(other$soHor3N)) {
						break label635;
					}

					return false;
				}

				Long this$soHor4N = this.getSoHor4N();
				Long other$soHor4N = other.getSoHor4N();
				if (this$soHor4N == null) {
					if (other$soHor4N != null) {
						return false;
					}
				} else if (!this$soHor4N.equals(other$soHor4N)) {
					return false;
				}

				label621: {
					Long this$soHor5N = this.getSoHor5N();
					Long other$soHor5N = other.getSoHor5N();
					if (this$soHor5N == null) {
						if (other$soHor5N == null) {
							break label621;
						}
					} else if (this$soHor5N.equals(other$soHor5N)) {
						break label621;
					}

					return false;
				}

				label614: {
					String this$soIdpadreStr = this.getSoIdpadreStr();
					String other$soIdpadreStr = other.getSoIdpadreStr();
					if (this$soIdpadreStr == null) {
						if (other$soIdpadreStr == null) {
							break label614;
						}
					} else if (this$soIdpadreStr.equals(other$soIdpadreStr)) {
						break label614;
					}

					return false;
				}

				String this$soIdrecomStr = this.getSoIdrecomStr();
				String other$soIdrecomStr = other.getSoIdrecomStr();
				if (this$soIdrecomStr == null) {
					if (other$soIdrecomStr != null) {
						return false;
					}
				} else if (!this$soIdrecomStr.equals(other$soIdrecomStr)) {
					return false;
				}

				label600: {
					String this$soInteriorStr = this.getSoInteriorStr();
					String other$soInteriorStr = other.getSoInteriorStr();
					if (this$soInteriorStr == null) {
						if (other$soInteriorStr == null) {
							break label600;
						}
					} else if (this$soInteriorStr.equals(other$soInteriorStr)) {
						break label600;
					}

					return false;
				}

				label593: {
					String this$soLada1Str = this.getSoLada1Str();
					String other$soLada1Str = other.getSoLada1Str();
					if (this$soLada1Str == null) {
						if (other$soLada1Str == null) {
							break label593;
						}
					} else if (this$soLada1Str.equals(other$soLada1Str)) {
						break label593;
					}

					return false;
				}

				String this$soLada2Str = this.getSoLada2Str();
				String other$soLada2Str = other.getSoLada2Str();
				if (this$soLada2Str == null) {
					if (other$soLada2Str != null) {
						return false;
					}
				} else if (!this$soLada2Str.equals(other$soLada2Str)) {
					return false;
				}

				String this$soLada3Str = this.getSoLada3Str();
				String other$soLada3Str = other.getSoLada3Str();
				if (this$soLada3Str == null) {
					if (other$soLada3Str != null) {
						return false;
					}
				} else if (!this$soLada3Str.equals(other$soLada3Str)) {
					return false;
				}

				label572: {
					String this$soLada4Str = this.getSoLada4Str();
					String other$soLada4Str = other.getSoLada4Str();
					if (this$soLada4Str == null) {
						if (other$soLada4Str == null) {
							break label572;
						}
					} else if (this$soLada4Str.equals(other$soLada4Str)) {
						break label572;
					}

					return false;
				}

				String this$soLada5Str = this.getSoLada5Str();
				String other$soLada5Str = other.getSoLada5Str();
				if (this$soLada5Str == null) {
					if (other$soLada5Str != null) {
						return false;
					}
				} else if (!this$soLada5Str.equals(other$soLada5Str)) {
					return false;
				}

				String this$soLada6Str = this.getSoLada6Str();
				String other$soLada6Str = other.getSoLada6Str();
				if (this$soLada6Str == null) {
					if (other$soLada6Str != null) {
						return false;
					}
				} else if (!this$soLada6Str.equals(other$soLada6Str)) {
					return false;
				}

				label551: {
					String this$soLoteStr = this.getSoLoteStr();
					String other$soLoteStr = other.getSoLoteStr();
					if (this$soLoteStr == null) {
						if (other$soLoteStr == null) {
							break label551;
						}
					} else if (this$soLoteStr.equals(other$soLoteStr)) {
						break label551;
					}

					return false;
				}

				String this$soManzanaStr = this.getSoManzanaStr();
				String other$soManzanaStr = other.getSoManzanaStr();
				if (this$soManzanaStr == null) {
					if (other$soManzanaStr != null) {
						return false;
					}
				} else if (!this$soManzanaStr.equals(other$soManzanaStr)) {
					return false;
				}

				label537: {
					String this$soMunicStr = this.getSoMunicStr();
					String other$soMunicStr = other.getSoMunicStr();
					if (this$soMunicStr == null) {
						if (other$soMunicStr == null) {
							break label537;
						}
					} else if (this$soMunicStr.equals(other$soMunicStr)) {
						break label537;
					}

					return false;
				}

				Long this$soNcredN = this.getSoNcredN();
				Long other$soNcredN = other.getSoNcredN();
				if (this$soNcredN == null) {
					if (other$soNcredN != null) {
						return false;
					}
				} else if (!this$soNcredN.equals(other$soNcredN)) {
					return false;
				}

				label523: {
					String this$soNivelStr = this.getSoNivelStr();
					String other$soNivelStr = other.getSoNivelStr();
					if (this$soNivelStr == null) {
						if (other$soNivelStr == null) {
							break label523;
						}
					} else if (this$soNivelStr.equals(other$soNivelStr)) {
						break label523;
					}

					return false;
				}

				String this$soNomStr = this.getSoNomStr();
				String other$soNomStr = other.getSoNomStr();
				if (this$soNomStr == null) {
					if (other$soNomStr != null) {
						return false;
					}
				} else if (!this$soNomStr.equals(other$soNomStr)) {
					return false;
				}

				label509: {
					Long this$soNominaN = this.getSoNominaN();
					Long other$soNominaN = other.getSoNominaN();
					if (this$soNominaN == null) {
						if (other$soNominaN == null) {
							break label509;
						}
					} else if (this$soNominaN.equals(other$soNominaN)) {
						break label509;
					}

					return false;
				}

				label502: {
					String this$soNumStr = this.getSoNumStr();
					String other$soNumStr = other.getSoNumStr();
					if (this$soNumStr == null) {
						if (other$soNumStr == null) {
							break label502;
						}
					} else if (this$soNumStr.equals(other$soNumStr)) {
						break label502;
					}

					return false;
				}

				String this$soNumintStr = this.getSoNumintStr();
				String other$soNumintStr = other.getSoNumintStr();
				if (this$soNumintStr == null) {
					if (other$soNumintStr != null) {
						return false;
					}
				} else if (!this$soNumintStr.equals(other$soNumintStr)) {
					return false;
				}

				label488: {
					Date this$soNvosocDt = this.getSoNvosocDt();
					Date other$soNvosocDt = other.getSoNvosocDt();
					if (this$soNvosocDt == null) {
						if (other$soNvosocDt == null) {
							break label488;
						}
					} else if (this$soNvosocDt.equals(other$soNvosocDt)) {
						break label488;
					}

					return false;
				}

				label481: {
					String this$soRefStr = this.getSoRefStr();
					String other$soRefStr = other.getSoRefStr();
					if (this$soRefStr == null) {
						if (other$soRefStr == null) {
							break label481;
						}
					} else if (this$soRefStr.equals(other$soRefStr)) {
						break label481;
					}

					return false;
				}

				Double this$soSaldN = this.getSoSaldN();
				Double other$soSaldN = other.getSoSaldN();
				if (this$soSaldN == null) {
					if (other$soSaldN != null) {
						return false;
					}
				} else if (!this$soSaldN.equals(other$soSaldN)) {
					return false;
				}

				Double this$soSaldantN = this.getSoSaldantN();
				Double other$soSaldantN = other.getSoSaldantN();
				if (this$soSaldantN == null) {
					if (other$soSaldantN != null) {
						return false;
					}
				} else if (!this$soSaldantN.equals(other$soSaldantN)) {
					return false;
				}

				label460: {
					String this$soSexoStr = this.getSoSexoStr();
					String other$soSexoStr = other.getSoSexoStr();
					if (this$soSexoStr == null) {
						if (other$soSexoStr == null) {
							break label460;
						}
					} else if (this$soSexoStr.equals(other$soSexoStr)) {
						break label460;
					}

					return false;
				}

				String this$soTel1Str = this.getSoTel1Str();
				String other$soTel1Str = other.getSoTel1Str();
				if (this$soTel1Str == null) {
					if (other$soTel1Str != null) {
						return false;
					}
				} else if (!this$soTel1Str.equals(other$soTel1Str)) {
					return false;
				}

				String this$soTel2Str = this.getSoTel2Str();
				String other$soTel2Str = other.getSoTel2Str();
				if (this$soTel2Str == null) {
					if (other$soTel2Str != null) {
						return false;
					}
				} else if (!this$soTel2Str.equals(other$soTel2Str)) {
					return false;
				}

				label439: {
					String this$soTel3Str = this.getSoTel3Str();
					String other$soTel3Str = other.getSoTel3Str();
					if (this$soTel3Str == null) {
						if (other$soTel3Str == null) {
							break label439;
						}
					} else if (this$soTel3Str.equals(other$soTel3Str)) {
						break label439;
					}

					return false;
				}

				String this$soTel4Str = this.getSoTel4Str();
				String other$soTel4Str = other.getSoTel4Str();
				if (this$soTel4Str == null) {
					if (other$soTel4Str != null) {
						return false;
					}
				} else if (!this$soTel4Str.equals(other$soTel4Str)) {
					return false;
				}

				label425: {
					String this$soTel5Str = this.getSoTel5Str();
					String other$soTel5Str = other.getSoTel5Str();
					if (this$soTel5Str == null) {
						if (other$soTel5Str == null) {
							break label425;
						}
					} else if (this$soTel5Str.equals(other$soTel5Str)) {
						break label425;
					}

					return false;
				}

				String this$soTel6Str = this.getSoTel6Str();
				String other$soTel6Str = other.getSoTel6Str();
				if (this$soTel6Str == null) {
					if (other$soTel6Str != null) {
						return false;
					}
				} else if (!this$soTel6Str.equals(other$soTel6Str)) {
					return false;
				}

				label411: {
					String this$soTipoStr = this.getSoTipoStr();
					String other$soTipoStr = other.getSoTipoStr();
					if (this$soTipoStr == null) {
						if (other$soTipoStr == null) {
							break label411;
						}
					} else if (this$soTipoStr.equals(other$soTipoStr)) {
						break label411;
					}

					return false;
				}

				Date this$soVigDt = this.getSoVigDt();
				Date other$soVigDt = other.getSoVigDt();
				if (this$soVigDt == null) {
					if (other$soVigDt != null) {
						return false;
					}
				} else if (!this$soVigDt.equals(other$soVigDt)) {
					return false;
				}

				label397: {
					Integer this$tiCveN = this.getTiCveN();
					Integer other$tiCveN = other.getTiCveN();
					if (this$tiCveN == null) {
						if (other$tiCveN == null) {
							break label397;
						}
					} else if (this$tiCveN.equals(other$tiCveN)) {
						break label397;
					}

					return false;
				}

				label390: {
					Long this$tsCveN = this.getTsCveN();
					Long other$tsCveN = other.getTsCveN();
					if (this$tsCveN == null) {
						if (other$tsCveN == null) {
							break label390;
						}
					} else if (this$tsCveN.equals(other$tsCveN)) {
						break label390;
					}

					return false;
				}

				String this$usrCvePstr = this.getUsrCvePstr();
				String other$usrCvePstr = other.getUsrCvePstr();
				if (this$usrCvePstr == null) {
					if (other$usrCvePstr != null) {
						return false;
					}
				} else if (!this$usrCvePstr.equals(other$usrCvePstr)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof Member;
	}

	public int hashCode() {
		boolean PRIME = true;
		byte result = 1;
		String $soIdStr = this.getSoIdStr();
		int result1 = result * 59 + ($soIdStr == null ? 43 : $soIdStr.hashCode());
		Long $cllNumllamN = this.getCllNumllamN();
		result1 = result1 * 59 + ($cllNumllamN == null ? 43 : $cllNumllamN.hashCode());
		Integer $edCveN = this.getEdCveN();
		result1 = result1 * 59 + ($edCveN == null ? 43 : $edCveN.hashCode());
		Integer $muCveN = this.getMuCveN();
		result1 = result1 * 59 + ($muCveN == null ? 43 : $muCveN.hashCode());
		Integer $paCveN = this.getPaCveN();
		result1 = result1 * 59 + ($paCveN == null ? 43 : $paCveN.hashCode());
		Long $prtIdN = this.getPrtIdN();
		result1 = result1 * 59 + ($prtIdN == null ? 43 : $prtIdN.hashCode());
		String $psSoIdStr = this.getPsSoIdStr();
		result1 = result1 * 59 + ($psSoIdStr == null ? 43 : $psSoIdStr.hashCode());
		String $sapsCveStr = this.getSapsCveStr();
		result1 = result1 * 59 + ($sapsCveStr == null ? 43 : $sapsCveStr.hashCode());
		String $seComStr = this.getSeComStr();
		result1 = result1 * 59 + ($seComStr == null ? 43 : $seComStr.hashCode());
		String $soAmatStr = this.getSoAmatStr();
		result1 = result1 * 59 + ($soAmatStr == null ? 43 : $soAmatStr.hashCode());
		String $soApatStr = this.getSoApatStr();
		result1 = result1 * 59 + ($soApatStr == null ? 43 : $soApatStr.hashCode());
		String $soCalleStr = this.getSoCalleStr();
		result1 = result1 * 59 + ($soCalleStr == null ? 43 : $soCalleStr.hashCode());
		Long $soCcompN = this.getSoCcompN();
		result1 = result1 * 59 + ($soCcompN == null ? 43 : $soCcompN.hashCode());
		String $soCdStr = this.getSoCdStr();
		result1 = result1 * 59 + ($soCdStr == null ? 43 : $soCdStr.hashCode());
		String $soColStr = this.getSoColStr();
		result1 = result1 * 59 + ($soColStr == null ? 43 : $soColStr.hashCode());
		String $soContmkStr = this.getSoContmkStr();
		result1 = result1 * 59 + ($soContmkStr == null ? 43 : $soContmkStr.hashCode());
		String $soCpStr = this.getSoCpStr();
		result1 = result1 * 59 + ($soCpStr == null ? 43 : $soCpStr.hashCode());
		String $soCve1Str = this.getSoCve1Str();
		result1 = result1 * 59 + ($soCve1Str == null ? 43 : $soCve1Str.hashCode());
		String $soCve2Str = this.getSoCve2Str();
		result1 = result1 * 59 + ($soCve2Str == null ? 43 : $soCve2Str.hashCode());
		String $soCve3Str = this.getSoCve3Str();
		result1 = result1 * 59 + ($soCve3Str == null ? 43 : $soCve3Str.hashCode());
		String $soCve4Str = this.getSoCve4Str();
		result1 = result1 * 59 + ($soCve4Str == null ? 43 : $soCve4Str.hashCode());
		String $soCve5Str = this.getSoCve5Str();
		result1 = result1 * 59 + ($soCve5Str == null ? 43 : $soCve5Str.hashCode());
		String $soCve6Str = this.getSoCve6Str();
		result1 = result1 * 59 + ($soCve6Str == null ? 43 : $soCve6Str.hashCode());
		String $soCveelectorStr = this.getSoCveelectorStr();
		result1 = result1 * 59 + ($soCveelectorStr == null ? 43 : $soCveelectorStr.hashCode());
		String $soDgStr = this.getSoDgStr();
		result1 = result1 * 59 + ($soDgStr == null ? 43 : $soDgStr.hashCode());
		String $soDirgrStr = this.getSoDirgrStr();
		result1 = result1 * 59 + ($soDirgrStr == null ? 43 : $soDirgrStr.hashCode());
		String $soDvStr = this.getSoDvStr();
		result1 = result1 * 59 + ($soDvStr == null ? 43 : $soDvStr.hashCode());
		String $soEmailStr = this.getSoEmailStr();
		result1 = result1 * 59 + ($soEmailStr == null ? 43 : $soEmailStr.hashCode());
		String $soEstStr = this.getSoEstStr();
		result1 = result1 * 59 + ($soEstStr == null ? 43 : $soEstStr.hashCode());
		String $soExt4Str = this.getSoExt4Str();
		result1 = result1 * 59 + ($soExt4Str == null ? 43 : $soExt4Str.hashCode());
		String $soExt5Str = this.getSoExt5Str();
		result1 = result1 * 59 + ($soExt5Str == null ? 43 : $soExt5Str.hashCode());
		Date $soFaltaDt = this.getSoFaltaDt();
		result1 = result1 * 59 + ($soFaltaDt == null ? 43 : $soFaltaDt.hashCode());
		Timestamp $soFnacDt = this.getSoFnacDt();
		result1 = result1 * 59 + ($soFnacDt == null ? 43 : $soFnacDt.hashCode());
		Date $soFregDt = this.getSoFregDt();
		result1 = result1 * 59 + ($soFregDt == null ? 43 : $soFregDt.hashCode());
		Long $soHor1N = this.getSoHor1N();
		result1 = result1 * 59 + ($soHor1N == null ? 43 : $soHor1N.hashCode());
		Long $soHor2N = this.getSoHor2N();
		result1 = result1 * 59 + ($soHor2N == null ? 43 : $soHor2N.hashCode());
		Long $soHor3N = this.getSoHor3N();
		result1 = result1 * 59 + ($soHor3N == null ? 43 : $soHor3N.hashCode());
		Long $soHor4N = this.getSoHor4N();
		result1 = result1 * 59 + ($soHor4N == null ? 43 : $soHor4N.hashCode());
		Long $soHor5N = this.getSoHor5N();
		result1 = result1 * 59 + ($soHor5N == null ? 43 : $soHor5N.hashCode());
		String $soIdpadreStr = this.getSoIdpadreStr();
		result1 = result1 * 59 + ($soIdpadreStr == null ? 43 : $soIdpadreStr.hashCode());
		String $soIdrecomStr = this.getSoIdrecomStr();
		result1 = result1 * 59 + ($soIdrecomStr == null ? 43 : $soIdrecomStr.hashCode());
		String $soInteriorStr = this.getSoInteriorStr();
		result1 = result1 * 59 + ($soInteriorStr == null ? 43 : $soInteriorStr.hashCode());
		String $soLada1Str = this.getSoLada1Str();
		result1 = result1 * 59 + ($soLada1Str == null ? 43 : $soLada1Str.hashCode());
		String $soLada2Str = this.getSoLada2Str();
		result1 = result1 * 59 + ($soLada2Str == null ? 43 : $soLada2Str.hashCode());
		String $soLada3Str = this.getSoLada3Str();
		result1 = result1 * 59 + ($soLada3Str == null ? 43 : $soLada3Str.hashCode());
		String $soLada4Str = this.getSoLada4Str();
		result1 = result1 * 59 + ($soLada4Str == null ? 43 : $soLada4Str.hashCode());
		String $soLada5Str = this.getSoLada5Str();
		result1 = result1 * 59 + ($soLada5Str == null ? 43 : $soLada5Str.hashCode());
		String $soLada6Str = this.getSoLada6Str();
		result1 = result1 * 59 + ($soLada6Str == null ? 43 : $soLada6Str.hashCode());
		String $soLoteStr = this.getSoLoteStr();
		result1 = result1 * 59 + ($soLoteStr == null ? 43 : $soLoteStr.hashCode());
		String $soManzanaStr = this.getSoManzanaStr();
		result1 = result1 * 59 + ($soManzanaStr == null ? 43 : $soManzanaStr.hashCode());
		String $soMunicStr = this.getSoMunicStr();
		result1 = result1 * 59 + ($soMunicStr == null ? 43 : $soMunicStr.hashCode());
		Long $soNcredN = this.getSoNcredN();
		result1 = result1 * 59 + ($soNcredN == null ? 43 : $soNcredN.hashCode());
		String $soNivelStr = this.getSoNivelStr();
		result1 = result1 * 59 + ($soNivelStr == null ? 43 : $soNivelStr.hashCode());
		String $soNomStr = this.getSoNomStr();
		result1 = result1 * 59 + ($soNomStr == null ? 43 : $soNomStr.hashCode());
		Long $soNominaN = this.getSoNominaN();
		result1 = result1 * 59 + ($soNominaN == null ? 43 : $soNominaN.hashCode());
		String $soNumStr = this.getSoNumStr();
		result1 = result1 * 59 + ($soNumStr == null ? 43 : $soNumStr.hashCode());
		String $soNumintStr = this.getSoNumintStr();
		result1 = result1 * 59 + ($soNumintStr == null ? 43 : $soNumintStr.hashCode());
		Date $soNvosocDt = this.getSoNvosocDt();
		result1 = result1 * 59 + ($soNvosocDt == null ? 43 : $soNvosocDt.hashCode());
		String $soRefStr = this.getSoRefStr();
		result1 = result1 * 59 + ($soRefStr == null ? 43 : $soRefStr.hashCode());
		Double $soSaldN = this.getSoSaldN();
		result1 = result1 * 59 + ($soSaldN == null ? 43 : $soSaldN.hashCode());
		Double $soSaldantN = this.getSoSaldantN();
		result1 = result1 * 59 + ($soSaldantN == null ? 43 : $soSaldantN.hashCode());
		String $soSexoStr = this.getSoSexoStr();
		result1 = result1 * 59 + ($soSexoStr == null ? 43 : $soSexoStr.hashCode());
		String $soTel1Str = this.getSoTel1Str();
		result1 = result1 * 59 + ($soTel1Str == null ? 43 : $soTel1Str.hashCode());
		String $soTel2Str = this.getSoTel2Str();
		result1 = result1 * 59 + ($soTel2Str == null ? 43 : $soTel2Str.hashCode());
		String $soTel3Str = this.getSoTel3Str();
		result1 = result1 * 59 + ($soTel3Str == null ? 43 : $soTel3Str.hashCode());
		String $soTel4Str = this.getSoTel4Str();
		result1 = result1 * 59 + ($soTel4Str == null ? 43 : $soTel4Str.hashCode());
		String $soTel5Str = this.getSoTel5Str();
		result1 = result1 * 59 + ($soTel5Str == null ? 43 : $soTel5Str.hashCode());
		String $soTel6Str = this.getSoTel6Str();
		result1 = result1 * 59 + ($soTel6Str == null ? 43 : $soTel6Str.hashCode());
		String $soTipoStr = this.getSoTipoStr();
		result1 = result1 * 59 + ($soTipoStr == null ? 43 : $soTipoStr.hashCode());
		Date $soVigDt = this.getSoVigDt();
		result1 = result1 * 59 + ($soVigDt == null ? 43 : $soVigDt.hashCode());
		Integer $tiCveN = this.getTiCveN();
		result1 = result1 * 59 + ($tiCveN == null ? 43 : $tiCveN.hashCode());
		Long $tsCveN = this.getTsCveN();
		result1 = result1 * 59 + ($tsCveN == null ? 43 : $tsCveN.hashCode());
		String $usrCvePstr = this.getUsrCvePstr();
		result1 = result1 * 59 + ($usrCvePstr == null ? 43 : $usrCvePstr.hashCode());
		return result1;
	}
}