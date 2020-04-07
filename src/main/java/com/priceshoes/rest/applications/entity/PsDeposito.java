package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PS_DEPOSITOS database table.
 * 
 */
@Entity
@Table(name="PS_DEPOSITOS")
public class PsDeposito implements Serializable {
	private static final long serialVersionUID = 1L;
	private PsDepositoPK id;
	private String autUsrCvePstr;
	private Long baCveN;
	private Long bapNumN;
	private String canUsrCvePstr;
	private Long cjCveN;
	private Integer depComisN;
	private String depDestStr;
	private String depEstStr;
	private Date depFautDt;
	private Date depFcanDt;
	private Date depFcaptDt;
	private Date depFechaDt;
	private Double depImpN;
	private String depNautStr;
	private Integer depPedN;
	private String depRefStr;
	private String depTipoStr;
	private Integer depcRegN;
	private Long nvNotaN;
	private String soIdStr;
	private String usrAutorizaCvePstr;
	private String usrCvePstr;
	private String fpeCveStr;	

	public PsDeposito() 
	{
		this.id = new PsDepositoPK();
	}


	@EmbeddedId
	public PsDepositoPK getId() 
	{
		return this.id;
	}

	public void setId(PsDepositoPK id) 
	{
		this.id = id;
	}


	@Column(name="AUT_USR_CVE_PSTR")
	public String getAutUsrCvePstr() 
	{
		return this.autUsrCvePstr;
	}

	public void setAutUsrCvePstr(String autUsrCvePstr) 
	{
		this.autUsrCvePstr = autUsrCvePstr;
	}


	@Column(name="BA_CVE_N")
	public Long getBaCveN() 
	{
		return this.baCveN;
	}

	public void setBaCveN(Long baCveN) 
	{
		this.baCveN = baCveN;
	}


	@Column(name="BAP_NUM_N")
	public Long getBapNumN() 
	{
		return this.bapNumN;
	}

	public void setBapNumN(Long bapNumN) 
	{
		this.bapNumN = bapNumN;
	}


	@Column(name="CAN_USR_CVE_PSTR")
	public String getCanUsrCvePstr() 
	{
		return this.canUsrCvePstr;
	}

	public void setCanUsrCvePstr(String canUsrCvePstr) 
	{
		this.canUsrCvePstr = canUsrCvePstr;
	}


	@Column(name="CJ_CVE_N")
	public Long getCjCveN() 
	{
		return this.cjCveN;
	}

	public void setCjCveN(Long cjCveN) 
	{
		this.cjCveN = cjCveN;
	}


	@Column(name="DEP_COMIS_N")
	public Integer getDepComisN() 
	{
		return this.depComisN;
	}

	public void setDepComisN(Integer depComisN) 
	{
		this.depComisN = depComisN;
	}


	@Column(name="DEP_DEST_STR")
	public String getDepDestStr() 
	{
		return this.depDestStr;
	}

	public void setDepDestStr(String depDestStr) 
	{
		this.depDestStr = depDestStr;
	}


	@Column(name="DEP_EST_STR")
	public String getDepEstStr() 
	{
		return this.depEstStr;
	}

	public void setDepEstStr(String depEstStr) 
	{
		this.depEstStr = depEstStr;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DEP_FAUT_DT")
	public Date getDepFautDt() 
	{
		return this.depFautDt;
	}

	public void setDepFautDt(Date depFautDt) 
	{
		this.depFautDt = depFautDt;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DEP_FCAN_DT")
	public Date getDepFcanDt() 
	{
		return this.depFcanDt;
	}

	public void setDepFcanDt(Date depFcanDt) 
	{
		this.depFcanDt = depFcanDt;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DEP_FCAPT_DT")
	public Date getDepFcaptDt() {
		return this.depFcaptDt;
	}

	public void setDepFcaptDt(Date depFcaptDt) 
	{
		this.depFcaptDt = depFcaptDt;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DEP_FECHA_DT")
	public Date getDepFechaDt()
	{
		return this.depFechaDt;
	}

	public void setDepFechaDt(Date depFechaDt) 
	{
		this.depFechaDt = depFechaDt;
	}


	@Column(name="DEP_IMP_N")
	public Double getDepImpN() 
	{
		return this.depImpN;
	}

	public void setDepImpN(Double depImpN) 
	{
		this.depImpN = depImpN;
	}


	@Column(name="DEP_NAUT_STR")
	public String getDepNautStr() 
	{
		return this.depNautStr;
	}

	public void setDepNautStr(String depNautStr) 
	{
		this.depNautStr = depNautStr;
	}


	@Column(name="DEP_PED_N")
	public Integer getDepPedN() 
	{
		return this.depPedN;
	}

	public void setDepPedN(Integer depPedN) 
	{
		this.depPedN = depPedN;
	}


	@Column(name="DEP_REF_STR")
	public String getDepRefStr() 
	{
		return this.depRefStr;
	}

	public void setDepRefStr(String depRefStr) 
	{
		this.depRefStr = depRefStr;
	}


	@Column(name="DEP_TIPO_STR")
	public String getDepTipoStr() 
	{
		return this.depTipoStr;
	}

	public void setDepTipoStr(String depTipoStr) 
	{
		this.depTipoStr = depTipoStr;
	}


	@Column(name="DEPC_REG_N")
	public Integer getDepcRegN() 
	{
		return this.depcRegN;
	}

	public void setDepcRegN(Integer depcRegN) 
	{
		this.depcRegN = depcRegN;
	}


	@Column(name="NV_NOTA_N")
	public Long getNvNotaN() 
	{
		return this.nvNotaN;
	}

	public void setNvNotaN(Long nvNotaN) 
	{
		this.nvNotaN = nvNotaN;
	}


	@Column(name="SO_ID_STR")
	public String getSoIdStr() 
	{
		return this.soIdStr;
	}

	public void setSoIdStr(String soIdStr) 
	{
		this.soIdStr = soIdStr;
	}


	@Column(name="USR_AUTORIZA_CVE_PSTR")
	public String getUsrAutorizaCvePstr() 
	{
		return this.usrAutorizaCvePstr;
	}

	public void setUsrAutorizaCvePstr(String usrAutorizaCvePstr) 
	{
		this.usrAutorizaCvePstr = usrAutorizaCvePstr;
	}


	@Column(name="USR_CVE_PSTR")
	public String getUsrCvePstr() 
	{
		return this.usrCvePstr;
	}

	public void setUsrCvePstr(String usrCvePstr) 
	{
		this.usrCvePstr = usrCvePstr;
	}
	
	@Column(name="FPE_CVE_STR")
	public String getFpeCveStr() 
	{
		return this.fpeCveStr;
	}

	public void setFpeCveStr(String fpeCveStr) 
	{
		this.fpeCveStr = fpeCveStr;
	}

}