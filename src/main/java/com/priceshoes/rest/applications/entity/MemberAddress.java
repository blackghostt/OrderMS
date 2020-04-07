package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.MemberAddressPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PS_SOCIOS_DIR", uniqueConstraints = { @UniqueConstraint(name = "id_uc", columnNames = { "SO_ID_STR" }) })
public class MemberAddress implements Serializable {
	private static final long serialVersionUID = -8403043627870008796L;
	@EmbeddedId
	private MemberAddressPK id = new MemberAddressPK();
	@Column(name = "ED_CVE_N")
	private Integer edCveN;
	@Column(name = "MU_CVE_N")
	private Integer muCveN;
	@Column(name = "PA_CVE_N")
	private Integer paCveN;
	@Column(name = "SOD_CALLE_STR")
	private String sodCalleStr;
	@Column(name = "SOD_CD_STR")
	private String sodCdStr;
	@Column(name = "SOD_COL_STR")
	private String sodColStr;
	@Column(name = "SOD_CP_STR")
	private String sodCpStr;
	@Column(name = "SOD_EST_STR")
	private String sodEstStr;
	@Column(name = "SOD_NUM_STR")
	private String sodNumStr;
	@Column(name = "SOD_OBS_STR")
	private String sodObsStr;
	@Column(name = "SOD_TEL1_STR")
	private String sodTel1Str;
	@Column(name = "SOD_TEL2_STR")
	private String sodTel2Str;

	public MemberAddressPK getId() {
		return this.id;
	}

	public void setId(MemberAddressPK id) {
		this.id = id;
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

	public String getSodCalleStr() {
		return this.sodCalleStr;
	}

	public void setSodCalleStr(String sodCalleStr) {
		this.sodCalleStr = sodCalleStr;
	}

	public String getSodCdStr() {
		return this.sodCdStr;
	}

	public void setSodCdStr(String sodCdStr) {
		this.sodCdStr = sodCdStr;
	}

	public String getSodColStr() {
		return this.sodColStr;
	}

	public void setSodColStr(String sodColStr) {
		this.sodColStr = sodColStr;
	}

	public String getSodCpStr() {
		return this.sodCpStr;
	}

	public void setSodCpStr(String sodCpStr) {
		this.sodCpStr = sodCpStr;
	}

	public String getSodEstStr() {
		return this.sodEstStr;
	}

	public void setSodEstStr(String sodEstStr) {
		this.sodEstStr = sodEstStr;
	}

	public String getSodNumStr() {
		return this.sodNumStr;
	}

	public void setSodNumStr(String sodNumStr) {
		this.sodNumStr = sodNumStr;
	}

	public String getSodObsStr() {
		return this.sodObsStr;
	}

	public void setSodObsStr(String sodObsStr) {
		this.sodObsStr = sodObsStr;
	}

	public String getSodTel1Str() {
		return this.sodTel1Str;
	}

	public void setSodTel1Str(String sodTel1Str) {
		this.sodTel1Str = sodTel1Str;
	}

	public String getSodTel2Str() {
		return this.sodTel2Str;
	}

	public void setSodTel2Str(String sodTel2Str) {
		this.sodTel2Str = sodTel2Str;
	}

	public String toString() {
		return "MemberAddress(id=" + this.getId() + ", edCveN=" + this.getEdCveN() + ", muCveN=" + this.getMuCveN()
				+ ", paCveN=" + this.getPaCveN() + ", sodCalleStr=" + this.getSodCalleStr() + ", sodCdStr="
				+ this.getSodCdStr() + ", sodColStr=" + this.getSodColStr() + ", sodCpStr=" + this.getSodCpStr()
				+ ", sodEstStr=" + this.getSodEstStr() + ", sodNumStr=" + this.getSodNumStr() + ", sodObsStr="
				+ this.getSodObsStr() + ", sodTel1Str=" + this.getSodTel1Str() + ", sodTel2Str=" + this.getSodTel2Str()
				+ ")";
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof MemberAddress)) {
			return false;
		} else {
			MemberAddress other = (MemberAddress) o;
			if (!other.canEqual(this)) {
				return false;
			} else {
				label167: {
					MemberAddressPK this$id = this.getId();
					MemberAddressPK other$id = other.getId();
					if (this$id == null) {
						if (other$id == null) {
							break label167;
						}
					} else if (this$id.equals(other$id)) {
						break label167;
					}

					return false;
				}

				Integer this$edCveN = this.getEdCveN();
				Integer other$edCveN = other.getEdCveN();
				if (this$edCveN == null) {
					if (other$edCveN != null) {
						return false;
					}
				} else if (!this$edCveN.equals(other$edCveN)) {
					return false;
				}

				label153: {
					Integer this$muCveN = this.getMuCveN();
					Integer other$muCveN = other.getMuCveN();
					if (this$muCveN == null) {
						if (other$muCveN == null) {
							break label153;
						}
					} else if (this$muCveN.equals(other$muCveN)) {
						break label153;
					}

					return false;
				}

				Integer this$paCveN = this.getPaCveN();
				Integer other$paCveN = other.getPaCveN();
				if (this$paCveN == null) {
					if (other$paCveN != null) {
						return false;
					}
				} else if (!this$paCveN.equals(other$paCveN)) {
					return false;
				}

				label139: {
					String this$sodCalleStr = this.getSodCalleStr();
					String other$sodCalleStr = other.getSodCalleStr();
					if (this$sodCalleStr == null) {
						if (other$sodCalleStr == null) {
							break label139;
						}
					} else if (this$sodCalleStr.equals(other$sodCalleStr)) {
						break label139;
					}

					return false;
				}

				String this$sodCdStr = this.getSodCdStr();
				String other$sodCdStr = other.getSodCdStr();
				if (this$sodCdStr == null) {
					if (other$sodCdStr != null) {
						return false;
					}
				} else if (!this$sodCdStr.equals(other$sodCdStr)) {
					return false;
				}

				label125: {
					String this$sodColStr = this.getSodColStr();
					String other$sodColStr = other.getSodColStr();
					if (this$sodColStr == null) {
						if (other$sodColStr == null) {
							break label125;
						}
					} else if (this$sodColStr.equals(other$sodColStr)) {
						break label125;
					}

					return false;
				}

				label118: {
					String this$sodCpStr = this.getSodCpStr();
					String other$sodCpStr = other.getSodCpStr();
					if (this$sodCpStr == null) {
						if (other$sodCpStr == null) {
							break label118;
						}
					} else if (this$sodCpStr.equals(other$sodCpStr)) {
						break label118;
					}

					return false;
				}

				String this$sodEstStr = this.getSodEstStr();
				String other$sodEstStr = other.getSodEstStr();
				if (this$sodEstStr == null) {
					if (other$sodEstStr != null) {
						return false;
					}
				} else if (!this$sodEstStr.equals(other$sodEstStr)) {
					return false;
				}

				label104: {
					String this$sodNumStr = this.getSodNumStr();
					String other$sodNumStr = other.getSodNumStr();
					if (this$sodNumStr == null) {
						if (other$sodNumStr == null) {
							break label104;
						}
					} else if (this$sodNumStr.equals(other$sodNumStr)) {
						break label104;
					}

					return false;
				}

				label97: {
					String this$sodObsStr = this.getSodObsStr();
					String other$sodObsStr = other.getSodObsStr();
					if (this$sodObsStr == null) {
						if (other$sodObsStr == null) {
							break label97;
						}
					} else if (this$sodObsStr.equals(other$sodObsStr)) {
						break label97;
					}

					return false;
				}

				String this$sodTel1Str = this.getSodTel1Str();
				String other$sodTel1Str = other.getSodTel1Str();
				if (this$sodTel1Str == null) {
					if (other$sodTel1Str != null) {
						return false;
					}
				} else if (!this$sodTel1Str.equals(other$sodTel1Str)) {
					return false;
				}

				String this$sodTel2Str = this.getSodTel2Str();
				String other$sodTel2Str = other.getSodTel2Str();
				if (this$sodTel2Str == null) {
					if (other$sodTel2Str != null) {
						return false;
					}
				} else if (!this$sodTel2Str.equals(other$sodTel2Str)) {
					return false;
				}

				return true;
			}
		}
	}

	protected boolean canEqual(Object other) {
		return other instanceof MemberAddress;
	}

	public int hashCode() {
		boolean PRIME = true;
		byte result = 1;
		MemberAddressPK $id = this.getId();
		int result1 = result * 59 + ($id == null ? 43 : $id.hashCode());
		Integer $edCveN = this.getEdCveN();
		result1 = result1 * 59 + ($edCveN == null ? 43 : $edCveN.hashCode());
		Integer $muCveN = this.getMuCveN();
		result1 = result1 * 59 + ($muCveN == null ? 43 : $muCveN.hashCode());
		Integer $paCveN = this.getPaCveN();
		result1 = result1 * 59 + ($paCveN == null ? 43 : $paCveN.hashCode());
		String $sodCalleStr = this.getSodCalleStr();
		result1 = result1 * 59 + ($sodCalleStr == null ? 43 : $sodCalleStr.hashCode());
		String $sodCdStr = this.getSodCdStr();
		result1 = result1 * 59 + ($sodCdStr == null ? 43 : $sodCdStr.hashCode());
		String $sodColStr = this.getSodColStr();
		result1 = result1 * 59 + ($sodColStr == null ? 43 : $sodColStr.hashCode());
		String $sodCpStr = this.getSodCpStr();
		result1 = result1 * 59 + ($sodCpStr == null ? 43 : $sodCpStr.hashCode());
		String $sodEstStr = this.getSodEstStr();
		result1 = result1 * 59 + ($sodEstStr == null ? 43 : $sodEstStr.hashCode());
		String $sodNumStr = this.getSodNumStr();
		result1 = result1 * 59 + ($sodNumStr == null ? 43 : $sodNumStr.hashCode());
		String $sodObsStr = this.getSodObsStr();
		result1 = result1 * 59 + ($sodObsStr == null ? 43 : $sodObsStr.hashCode());
		String $sodTel1Str = this.getSodTel1Str();
		result1 = result1 * 59 + ($sodTel1Str == null ? 43 : $sodTel1Str.hashCode());
		String $sodTel2Str = this.getSodTel2Str();
		result1 = result1 * 59 + ($sodTel2Str == null ? 43 : $sodTel2Str.hashCode());
		return result1;
	}
}