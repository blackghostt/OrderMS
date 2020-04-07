package com.priceshoes.rest.applications.inventory;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.exceptions.MemberNotFoundException;
import com.priceshoes.rest.applications.respuesta.CatalogRespuesta;
import com.priceshoes.rest.applications.service.CatalogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/catalog" })
public class CatalogInfoController extends AbstractRestController {
	@Autowired
	public CatalogInfoService catalogInfoService;

	@RequestMapping(method = { RequestMethod.GET }, value = { "/info/{memberId}" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<CatalogRespuesta> getInfo(@PathVariable("memberId") String memberId)
			throws MemberNotFoundException {
		CatalogRespuesta catalogRespuesta = this.catalogInfoService.getInfo(memberId);
		return ResponseEntity.ok(catalogRespuesta);
	}
}