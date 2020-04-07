package com.priceshoes.rest.applications.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "P_WS_INSERTA_SALDO", query = "{call ppvmx.PCK_MAGENTO.P_WS_INSERTA_SALDO(?, :pedido,:socio,:monto) }", callable = true, resultClass = Procedure.class),
		@NamedNativeQuery(name = "P_WS_INSERTA_FORMAS_PAGO", query = "{call ppvmx.PCK_MAGENTO.P_WS_INSERTA_FORMAS_PAGO(?, :pedido,:socio,:monto) }", callable = true, resultClass = Procedure.class) })
public class Procedure {
	@Id
	@Column(name = "RESULTADO")
	private Long resultado;
	@Column(name = "ERR")
	private String err;

	public Long getResultado() {
		return this.resultado;
	}

	public void setResultado(Long resultado) {
		this.resultado = resultado;
	}

	public String getErr() {
		return this.err;
	}

	public void setErr(String err) {
		this.err = err;
	}
}