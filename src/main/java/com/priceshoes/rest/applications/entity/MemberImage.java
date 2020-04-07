package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PS_SOFOTO")
public class MemberImage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SO_ID_STR")
	private String soIdStr;
	@Column(name = "TI_CVE_N")
	private Integer storeId;
	@Lob
	@Column(name = "SO_FOTO_B", columnDefinition = "BLOB NOT NULL")
	private byte[] photo;

	public String getSoIdStr() {
		return this.soIdStr;
	}

	public void setSoIdStr(String soIdStr) {
		this.soIdStr = soIdStr;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}