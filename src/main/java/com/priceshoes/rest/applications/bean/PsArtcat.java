package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.PsArtcatPK;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "V_PS_ARTCAT2")
public class PsArtcat implements Serializable {
	private static final long serialVersionUID = 1L;
	private PsArtcatPK id = new PsArtcatPK();

	@EmbeddedId
	public PsArtcatPK getId() {
		return this.id;
	}

	public void setId(PsArtcatPK id) {
		this.id = id;
	}
}