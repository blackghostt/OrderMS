package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "getSalary", procedureName = "PPVMX.PCK_MAGENTO.F_GET_SALDO_SOCIO", parameters = {
				@StoredProcedureParameter(name = "pSO_ID_STR", type = String.class, mode = ParameterMode.IN) }) })
@Entity
@Table(name = "PS_VALES")
@NamedQueries({ @NamedQuery(name = "Coupon.count", query = "SELECT COUNT(c) FROM Coupon c"),
		@NamedQuery(name = "Coupon.findAll", query = "SELECT c FROM Coupon c") })
public class Coupon implements Serializable {
	private static final long serialVersionUID = -7753544976745227913L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VA_NUM_N")
	private long vaNumN;
	@Column(name = "CJ_CVE_N")
	private BigDecimal cjCveN;
	@Column(name = "COR_NUM_N")
	private BigDecimal corNumN;
	@Column(name = "RE_NUM_N")
	private Integer reNumN;
	@Column(name = "SO_ID_STR")
	private String soIdStr;
	@Column(name = "TI_CVE_N")
	private BigDecimal tiCveN;
	@Column(name = "VA_EST_STR")
	private String vaEstStr;
	@Column(name = "VA_EXC_STR")
	private String vaExcStr;
	@Temporal(TemporalType.DATE)
	@Column(name = "VA_FEC_DT")
	private Date vaFecDt;
	@Column(name = "VA_MONTO_N")
	private Double vaMontoN;
	@Column(name = "VA_REFNVTA_N")
	private Integer vaRefnvtaN;
	@Column(name = "VA_TIPO_STR")
	private String vaTipoStr;
	@Column(name = "VA_VTMK_N")
	private Integer vaVtmkN;
	@Column(name = "VS_NUM_N")
	private BigDecimal vsNumN;

	public long getVaNumN() {
		return this.vaNumN;
	}

	public BigDecimal getCjCveN() {
		return this.cjCveN;
	}

	public BigDecimal getCorNumN() {
		return this.corNumN;
	}

	public Integer getReNumN() {
		return this.reNumN;
	}

	public String getSoIdStr() {
		return this.soIdStr;
	}

	public BigDecimal getTiCveN() {
		return this.tiCveN;
	}

	public String getVaEstStr() {
		return this.vaEstStr;
	}

	public String getVaExcStr() {
		return this.vaExcStr;
	}

	public Date getVaFecDt() {
		return this.vaFecDt;
	}

	public Double getVaMontoN() {
		return this.vaMontoN;
	}

	public Integer getVaRefnvtaN() {
		return this.vaRefnvtaN;
	}

	public String getVaTipoStr() {
		return this.vaTipoStr;
	}

	public Integer getVaVtmkN() {
		return this.vaVtmkN;
	}

	public BigDecimal getVsNumN() {
		return this.vsNumN;
	}

	public void setVaNumN(long vaNumN) {
		this.vaNumN = vaNumN;
	}

	public void setCjCveN(BigDecimal cjCveN) {
		this.cjCveN = cjCveN;
	}

	public void setCorNumN(BigDecimal corNumN) {
		this.corNumN = corNumN;
	}

	public void setReNumN(Integer reNumN) {
		this.reNumN = reNumN;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	public void setTiCveN(BigDecimal tiCveN) {
		this.tiCveN = tiCveN;
	}

	public void setVaEstStr(String vaEstStr) {
		this.vaEstStr = vaEstStr;
	}

	public void setVaExcStr(String vaExcStr) {
		this.vaExcStr = vaExcStr;
	}

	public void setVaFecDt(Date vaFecDt) {
		this.vaFecDt = vaFecDt;
	}

	public void setVaMontoN(Double vaMontoN) {
		this.vaMontoN = vaMontoN;
	}

	public void setVaRefnvtaN(Integer vaRefnvtaN) {
		this.vaRefnvtaN = vaRefnvtaN;
	}

	public void setVaTipoStr(String vaTipoStr) {
		this.vaTipoStr = vaTipoStr;
	}

	public void setVaVtmkN(Integer vaVtmkN) {
		this.vaVtmkN = vaVtmkN;
	}

	public void setVsNumN(BigDecimal vsNumN) {
		this.vsNumN = vsNumN;
	}

	public String toString() {
		return "Coupon(vaNumN=" + this.getVaNumN() + ", cjCveN=" + this.getCjCveN() + ", corNumN=" + this.getCorNumN()
				+ ", reNumN=" + this.getReNumN() + ", soIdStr=" + this.getSoIdStr() + ", tiCveN=" + this.getTiCveN()
				+ ", vaEstStr=" + this.getVaEstStr() + ", vaExcStr=" + this.getVaExcStr() + ", vaFecDt="
				+ this.getVaFecDt() + ", vaMontoN=" + this.getVaMontoN() + ", vaRefnvtaN=" + this.getVaRefnvtaN()
				+ ", vaTipoStr=" + this.getVaTipoStr() + ", vaVtmkN=" + this.getVaVtmkN() + ", vsNumN="
				+ this.getVsNumN() + ")";
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Coupon)) {
			return false;
		} else {
			Coupon other = (Coupon) o;
			if (!other.canEqual(this)) {
				return false;
			} else if (this.getVaNumN() != other.getVaNumN()) {
				return false;
			} else {
				label169: {
					BigDecimal this$cjCveN = this.getCjCveN();
					BigDecimal other$cjCveN = other.getCjCveN();
					if (this$cjCveN == null) {
						if (other$cjCveN == null) {
							break label169;
						}
					} else if (this$cjCveN.equals(other$cjCveN)) {
						break label169;
					}

					return false;
				}

				BigDecimal this$corNumN = this.getCorNumN();
				BigDecimal other$corNumN = other.getCorNumN();
				if (this$corNumN == null) {
					if (other$corNumN != null) {
						return false;
					}
				} else if (!this$corNumN.equals(other$corNumN)) {
					return false;
				}

				label155: {
					Integer this$reNumN = this.getReNumN();
					Integer other$reNumN = other.getReNumN();
					if (this$reNumN == null) {
						if (other$reNumN == null) {
							break label155;
						}
					} else if (this$reNumN.equals(other$reNumN)) {
						break label155;
					}

					return false;
				}

				String this$soIdStr = this.getSoIdStr();
				String other$soIdStr = other.getSoIdStr();
				if (this$soIdStr == null) {
					if (other$soIdStr != null) {
						return false;
					}
				} else if (!this$soIdStr.equals(other$soIdStr)) {
					return false;
				}

				BigDecimal this$tiCveN = this.getTiCveN();
				BigDecimal other$tiCveN = other.getTiCveN();
				if (this$tiCveN == null) {
					if (other$tiCveN != null) {
						return false;
					}
				} else if (!this$tiCveN.equals(other$tiCveN)) {
					return false;
				}

				label134: {
					String this$vaEstStr = this.getVaEstStr();
					String other$vaEstStr = other.getVaEstStr();
					if (this$vaEstStr == null) {
						if (other$vaEstStr == null) {
							break label134;
						}
					} else if (this$vaEstStr.equals(other$vaEstStr)) {
						break label134;
					}

					return false;
				}

				label127: {
					String this$vaExcStr = this.getVaExcStr();
					String other$vaExcStr = other.getVaExcStr();
					if (this$vaExcStr == null) {
						if (other$vaExcStr == null) {
							break label127;
						}
					} else if (this$vaExcStr.equals(other$vaExcStr)) {
						break label127;
					}

					return false;
				}

				Date this$vaFecDt = this.getVaFecDt();
				Date other$vaFecDt = other.getVaFecDt();
				if (this$vaFecDt == null) {
					if (other$vaFecDt != null) {
						return false;
					}
				} else if (!this$vaFecDt.equals(other$vaFecDt)) {
					return false;
				}

				Double this$vaMontoN = this.getVaMontoN();
				Double other$vaMontoN = other.getVaMontoN();
				if (this$vaMontoN == null) {
					if (other$vaMontoN != null) {
						return false;
					}
				} else if (!this$vaMontoN.equals(other$vaMontoN)) {
					return false;
				}

				label106: {
					Integer this$vaRefnvtaN = this.getVaRefnvtaN();
					Integer other$vaRefnvtaN = other.getVaRefnvtaN();
					if (this$vaRefnvtaN == null) {
						if (other$vaRefnvtaN == null) {
							break label106;
						}
					} else if (this$vaRefnvtaN.equals(other$vaRefnvtaN)) {
						break label106;
					}

					return false;
				}

				label99: {
					String this$vaTipoStr = this.getVaTipoStr();
					String other$vaTipoStr = other.getVaTipoStr();
					if (this$vaTipoStr == null) {
						if (other$vaTipoStr == null) {
							break label99;
						}
					} else if (this$vaTipoStr.equals(other$vaTipoStr)) {
						break label99;
					}

					return false;
				}

				Integer this$vaVtmkN = this.getVaVtmkN();
				Integer other$vaVtmkN = other.getVaVtmkN();
				if (this$vaVtmkN == null) {
					if (other$vaVtmkN != null) {
						return false;
					}
				} else if (!this$vaVtmkN.equals(other$vaVtmkN)) {
					return false;
				}

				BigDecimal this$vsNumN = this.getVsNumN();
				BigDecimal other$vsNumN = other.getVsNumN();
				if (this$vsNumN == null) {
					if (other$vsNumN != null) {
						return false;
					}
				} else if (!this$vsNumN.equals(other$vsNumN)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof Coupon;
	}

	public int hashCode() {
		boolean PRIME = true;
		byte result = 1;
		long $vaNumN = this.getVaNumN();
		int result1 = result * 59 + (int) ($vaNumN >>> 32 ^ $vaNumN);
		BigDecimal $cjCveN = this.getCjCveN();
		result1 = result1 * 59 + ($cjCveN == null ? 43 : $cjCveN.hashCode());
		BigDecimal $corNumN = this.getCorNumN();
		result1 = result1 * 59 + ($corNumN == null ? 43 : $corNumN.hashCode());
		Integer $reNumN = this.getReNumN();
		result1 = result1 * 59 + ($reNumN == null ? 43 : $reNumN.hashCode());
		String $soIdStr = this.getSoIdStr();
		result1 = result1 * 59 + ($soIdStr == null ? 43 : $soIdStr.hashCode());
		BigDecimal $tiCveN = this.getTiCveN();
		result1 = result1 * 59 + ($tiCveN == null ? 43 : $tiCveN.hashCode());
		String $vaEstStr = this.getVaEstStr();
		result1 = result1 * 59 + ($vaEstStr == null ? 43 : $vaEstStr.hashCode());
		String $vaExcStr = this.getVaExcStr();
		result1 = result1 * 59 + ($vaExcStr == null ? 43 : $vaExcStr.hashCode());
		Date $vaFecDt = this.getVaFecDt();
		result1 = result1 * 59 + ($vaFecDt == null ? 43 : $vaFecDt.hashCode());
		Double $vaMontoN = this.getVaMontoN();
		result1 = result1 * 59 + ($vaMontoN == null ? 43 : $vaMontoN.hashCode());
		Integer $vaRefnvtaN = this.getVaRefnvtaN();
		result1 = result1 * 59 + ($vaRefnvtaN == null ? 43 : $vaRefnvtaN.hashCode());
		String $vaTipoStr = this.getVaTipoStr();
		result1 = result1 * 59 + ($vaTipoStr == null ? 43 : $vaTipoStr.hashCode());
		Integer $vaVtmkN = this.getVaVtmkN();
		result1 = result1 * 59 + ($vaVtmkN == null ? 43 : $vaVtmkN.hashCode());
		BigDecimal $vsNumN = this.getVsNumN();
		result1 = result1 * 59 + ($vsNumN == null ? 43 : $vsNumN.hashCode());
		return result1;
	}
}