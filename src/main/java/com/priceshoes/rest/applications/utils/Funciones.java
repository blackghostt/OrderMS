package com.priceshoes.rest.applications.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.hibernate.jdbc.Work;

public class Funciones implements Work {
	private String idSocio = null;
	private Long tienda = null;
	private static Logger log = Logger.getLogger(Funciones.class);

	public Funciones(Long tienda) {
		this.tienda = tienda;
	}

	public String getIdSocio() {
		return this.idSocio;
	}

	public void execute(Connection connection) throws SQLException {
		CallableStatement call = connection.prepareCall("{ ? = call WEBF_GET_NEXT_SOIDSTR(?) }");
		call.registerOutParameter(1, 12);
		call.setLong(2, this.tienda.longValue());
		call.execute();
		String result = call.getString(1);
		log.info("numero de socio generado:" + result);
		this.idSocio = result;
	}
}