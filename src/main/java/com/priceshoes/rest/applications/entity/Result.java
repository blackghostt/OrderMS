package com.priceshoes.rest.applications.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQuery
(
	name = "P_TRANSFIERE_SALDO",
	query = "{ call PKG_SALDOS.P_TRANSFIERE_SALDO(?,:socio,:origen,:destino,:monto) }",
	callable = true,
	resultClass = Result.class 
)
public class Result 
{
	@Id
	@Column	private String id;
	@Column private String value;
}
