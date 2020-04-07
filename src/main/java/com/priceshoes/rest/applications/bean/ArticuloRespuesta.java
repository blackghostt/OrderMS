package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.PsArtcat;
import com.priceshoes.rest.applications.bean.PsInventarioEcomm;
import com.priceshoes.rest.applications.bean.Tienda;
import com.priceshoes.rest.applications.bean.VPsExist;
import com.priceshoes.rest.applications.respuesta.Respuesta;
import java.util.List;

public class ArticuloRespuesta extends Respuesta {
	private List<PsInventarioEcomm> psInventarioEcomm;
	private List<VPsExist> vPsExist;
	private List<PsArtcat> psArtcat;
	private List<Tienda> tiendas;
	private String[] corridas;

	public List<PsInventarioEcomm> getPsInventarioEcomm() {
		return this.psInventarioEcomm;
	}

	public void setPsInventarioEcomm(List<PsInventarioEcomm> psInventarioEcomm) {
		this.psInventarioEcomm = psInventarioEcomm;
	}

	public List<VPsExist> getvPsExist() {
		return this.vPsExist;
	}

	public void setvPsExist(List<VPsExist> vPsExist) {
		this.vPsExist = vPsExist;
	}

	public List<PsArtcat> getPsArtcat() {
		return this.psArtcat;
	}

	public void setPsArtcat(List<PsArtcat> psArtcat) {
		this.psArtcat = psArtcat;
	}

	public List<Tienda> getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public String[] getCorridas() {
		return this.corridas;
	}

	public void setCorridas(String[] corridas) {
		this.corridas = corridas;
	}
}