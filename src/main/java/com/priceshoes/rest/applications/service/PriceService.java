package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.repository.PriceRepository;
import com.priceshoes.rest.applications.respuesta.PriceRespuesta;
import com.priceshoes.rest.applications.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService extends AbstractService {
	@Autowired
	private PriceRepository priceRepository;

	public PriceRespuesta getPrices(int days) {
		return this.priceRepository.getPrices(days);
	}
}