package com.priceshoes.rest.applications.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@NamedNativeQueries({
		@NamedNativeQuery(name = "findCorridas", query = "select * from precios where id_art in (:idArt) and (:talla between ta_cve_n_ini and ta_cve_n_fin)", resultClass = Precios.class) })
@Entity
@Table(name = "PRECIOS")
public class Precios {
	@Id
	@Column(name = "ID_ART")
	private Long idArt;
	@Column(name = "TA_CVE_N_INI")
	private Float tallaInicial;
	@Column(name = "TA_CVE_N_FIN")
	private Float tallaFinal;
	@Column(name = "CO_CVE_STR")
	private String corrida;

	public Long getIdArt() {
		return this.idArt;
	}

	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}

	public Float getTallaInicial() {
		return this.tallaInicial;
	}

	public void setTallaInicial(Float tallaInicial) {
		this.tallaInicial = tallaInicial;
	}

	public Float getTallaFinal() {
		return this.tallaFinal;
	}

	public void setTallaFinal(Float tallaFinal) {
		this.tallaFinal = tallaFinal;
	}

	public String getCorrida() {
		return this.corrida;
	}

	public void setCorrida(String corrida) {
		this.corrida = corrida;
	}
}