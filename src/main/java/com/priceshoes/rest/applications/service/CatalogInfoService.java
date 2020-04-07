package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.exceptions.MemberNotFoundException;
import com.priceshoes.rest.applications.repository.CatalogInfoRepository;
import com.priceshoes.rest.applications.respuesta.CatalogRespuesta;
import com.priceshoes.rest.applications.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogInfoService extends AbstractService {
	@Autowired
	public CatalogInfoRepository catalogInfoRepository;

	public CatalogRespuesta getInfo(String memberId) throws MemberNotFoundException {
		return this.catalogInfoRepository.getInfo(memberId);
	}
}