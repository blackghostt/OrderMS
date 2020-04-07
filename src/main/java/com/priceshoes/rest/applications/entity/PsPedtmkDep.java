/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.PsPedtmkDepPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PS_PEDTMK_DEP")
public class PsPedtmkDep implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private PsPedtmkDepPK id = new PsPedtmkDepPK();
	@Column(name = "PTDEP_EST_STR")
	private String ptdepEstStr;

	public PsPedtmkDepPK getId() {
		return this.id;
	}

	public void setId(PsPedtmkDepPK id) {
		this.id = id;
	}

	public String getPtdepEstStr() {
		return this.ptdepEstStr;
	}

	public void setPtdepEstStr(String ptdepEstStr) {
		this.ptdepEstStr = ptdepEstStr;
	}
}