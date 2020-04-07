/**
 * <p>Clase Java para Direccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Direccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_direccion_ps" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="calle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="colonia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipio_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ciudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo_postal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefono1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefono2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pais_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="estado_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.priceshoes.rest.applications.bean;

public class Direccion {
	protected Integer idDireccionPs;
	protected String calle;
	protected String numero;
	protected String colonia;
	protected Integer municipioId;
	protected String ciudad;
	protected String codigoPostal;
	protected String telefono1;
	protected String telefono2;
	protected Integer paisId;
	protected Integer estadoId;
	protected String observaciones;

	public Integer getIdDireccionPs() {
		return this.idDireccionPs;
	}

	public void setIdDireccionPs(Integer value) {
		this.idDireccionPs = value;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String value) {
		this.calle = value;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String value) {
		this.numero = value;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String value) {
		this.colonia = value;
	}

	public Integer getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(Integer value) {
		this.municipioId = value;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String value) {
		this.ciudad = value;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String value) {
		this.codigoPostal = value;
	}

	public String getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(String value) {
		this.telefono1 = value;
	}

	public String getTelefono2() {
		return this.telefono2;
	}

	public void setTelefono2(String value) {
		this.telefono2 = value;
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String value) {
		this.observaciones = value;
	}
}