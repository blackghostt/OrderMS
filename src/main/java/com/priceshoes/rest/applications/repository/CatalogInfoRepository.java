package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.exceptions.MemberNotFoundException;
import com.priceshoes.rest.applications.respuesta.CatalogRespuesta;

public interface CatalogInfoRepository {
	CatalogRespuesta getInfo(String arg0) throws MemberNotFoundException;
}