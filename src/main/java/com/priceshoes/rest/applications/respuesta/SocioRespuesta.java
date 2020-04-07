package com.priceshoes.rest.applications.respuesta;

import com.priceshoes.rest.applications.bean.Direccion;
import com.priceshoes.rest.applications.bean.Saldo;
import com.priceshoes.rest.applications.entity.Member;
import com.priceshoes.rest.applications.entity.MemberAddress;
import com.priceshoes.rest.applications.respuesta.Respuesta;
import java.util.List;

public class SocioRespuesta extends Respuesta {
	private String socioId;
	private List<Member> socios;
	private Member socio;
	private byte[] socioImage;
	private List<Direccion> direccion;
	private int camposModificados;
	private boolean direccionInvalida;
	private Saldo saldo;
	private List<MemberAddress> psDirecciones;
	private String status;

	public byte[] getSocioImage() {
		return this.socioImage;
	}

	public void setSocioImage(byte[] socioImage) {
		this.socioImage = socioImage;
	}

	public String getSocioId() {
		return this.socioId;
	}

	public void setSocioId(String socioId) {
		this.socioId = socioId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Member> getSocios() {
		return this.socios;
	}

	public void setSocios(List<Member> socios) {
		this.socios = socios;
	}

	public Member getSocio() {
		return this.socio;
	}

	public void setSocio(Member socio) {
		this.socio = socio;
	}

	public List<Direccion> getDireccion() {
		return this.direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

	public int getCamposModificados() {
		return this.camposModificados;
	}

	public void setCamposModificados(int camposModificados) {
		this.camposModificados = camposModificados;
	}

	public boolean isDireccionInvalida() {
		return this.direccionInvalida;
	}

	public void setDireccionInvalida(boolean direccionInvalida) {
		this.direccionInvalida = direccionInvalida;
	}

	public Saldo getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	public List<MemberAddress> getPsDirecciones() {
		return this.psDirecciones;
	}

	public void setPsDirecciones(List<MemberAddress> psDirecciones) {
		this.psDirecciones = psDirecciones;
	}
}