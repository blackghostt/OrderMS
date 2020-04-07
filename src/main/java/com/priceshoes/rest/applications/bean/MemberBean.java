package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.Socio;
import com.priceshoes.rest.applications.entity.Member;
import com.priceshoes.rest.applications.entity.MemberAddress;
import java.util.List;

public class MemberBean {
	private Member psSocio;
	private Socio socio;
	private byte[] image;
	private List<MemberAddress> addresses;

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Member getPsSocio() {
		return this.psSocio;
	}

	public void setPsSocio(Member psSocio) {
		this.psSocio = psSocio;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<MemberAddress> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<MemberAddress> addresses) {
		this.addresses = addresses;
	}
}