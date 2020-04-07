package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.DireccionCollection;
import javax.xml.datatype.XMLGregorianCalendar;

public class Socio {
	protected String socioIdPs;
	protected String socioId;
	protected String nombre;
	protected Integer paisId;
	protected Long dateLong;
	protected Integer estadoId;
	protected String apellidoPaterno;
	protected String apellidoMaterno;
	protected Integer medioId;
	protected Integer submedioId;
	protected String tipoSocio;
	protected String sexo;
	protected DireccionCollection direcciones;
	protected String email;
	protected String soTel1Str;
	protected String soTel2Str;
	protected XMLGregorianCalendar dob;
	protected String activo;
	protected Integer anioAfiliacion;
	protected Integer sucursalAfiliacion;
	protected String tipoSocioCliente;

	public String getSocioIdPs() {
		return this.socioIdPs;
	}

	public void setSocioIdPs(String value) {
		this.socioIdPs = value;
	}

	public String getSocioId() {
		return this.socioId;
	}

	public void setSocioId(String socioId) {
		this.socioId = socioId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String value) {
		this.nombre = value;
	}

	public Integer getPaisId() {
		return this.paisId;
	}

	public void setPaisId(Integer value) {
		this.paisId = value;
	}

	public Integer getEstadoId() {
		return this.estadoId;
	}

	public void setEstadoId(Integer value) {
		this.estadoId = value;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String value) {
		this.apellidoPaterno = value;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String value) {
		this.apellidoMaterno = value;
	}

	public Integer getMedioId() {
		return this.medioId;
	}

	public void setMedioId(Integer value) {
		this.medioId = value;
	}

	public Integer getSubmedioId() {
		return this.submedioId;
	}

	public void setSubmedioId(Integer value) {
		this.submedioId = value;
	}

	public String getTipoSocio() {
		return this.tipoSocio;
	}

	public void setTipoSocio(String value) {
		this.tipoSocio = value;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String value) {
		this.sexo = value;
	}

	public DireccionCollection getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(DireccionCollection value) {
		this.direcciones = value;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public XMLGregorianCalendar getDob() {
		return this.dob;
	}

	public void setDob(XMLGregorianCalendar value) {
		this.dob = value;
	}

	public String isActivo() {
		return this.activo;
	}

	public void setActivo(String value) {
		this.activo = value;
	}

	public Integer getAnioAfiliacion() {
		return this.anioAfiliacion;
	}

	public void setAnioAfiliacion(Integer anioAfiliacion) {
		this.anioAfiliacion = anioAfiliacion;
	}

	public Integer getSucursalAfiliacion() {
		return this.sucursalAfiliacion;
	}

	public void setSucursalAfiliacion(Integer sucursalAfiliacion) {
		this.sucursalAfiliacion = sucursalAfiliacion;
	}

	public String getTipoSocioCliente() {
		return this.tipoSocioCliente;
	}

	public void setTipoSocioCliente(String tipoSocioCliente) {
		this.tipoSocioCliente = tipoSocioCliente;
	}

	public String getSoTel1Str() {
		return this.soTel1Str;
	}

	public void setSoTel1Str(String soTel1Str) {
		this.soTel1Str = soTel1Str;
	}

	public String getSoTel2Str() {
		return this.soTel2Str;
	}

	public void setSoTel2Str(String soTel2Str) {
		this.soTel2Str = soTel2Str;
	}

	public String getActivo() {
		return this.activo;
	}

	public Long getDateLong() {
		return this.dateLong;
	}

	public void setDateLong(Long dateLong) {
		this.dateLong = dateLong;
	}
}