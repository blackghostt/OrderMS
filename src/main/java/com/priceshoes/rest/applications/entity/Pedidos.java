package com.priceshoes.rest.applications.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PS_PEDIDOS")
public class Pedidos implements Serializable {
	private static final long serialVersionUID = -416386011895947516L;
	@Id
	@Column(name = "RECD_PEDIDO_N")
	private String recdPedidoN;
	@Column(name = "PE_TIPO_STR")
	private String peTipoStr;
	@Column(name = "PE_FECHA_DT")
	private Date peFechaDt;

	public String getRecdPedidoN() {
		return this.recdPedidoN;
	}

	public void setRecdPedidoN(String recdPedidoN) {
		this.recdPedidoN = recdPedidoN;
	}

	public String getPeTipoStr() {
		return this.peTipoStr;
	}

	public void setPeTipoStr(String peTipoStr) {
		this.peTipoStr = peTipoStr;
	}

	public Date getPeFechaDt() {
		return this.peFechaDt;
	}

	public void setPeFechaDt(Date peFechaDt) {
		this.peFechaDt = peFechaDt;
	}
}