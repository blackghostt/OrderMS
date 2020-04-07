package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.respuesta.PriceRespuesta;

public interface PriceRepository {
	PriceRespuesta getPrices(int arg0);
}