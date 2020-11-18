/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.priceshoes.rest.applications.inventory;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.bean.InventoryBean;
import com.priceshoes.rest.applications.entity.InventoryOnline;
import com.priceshoes.rest.applications.hateoas.event.PaginatedResultsRetrievedEvent;
import com.priceshoes.rest.applications.service.InventoryOnlineService;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({ "/inventory" })
public class InventoryOnlineController extends AbstractRestController {
	private static final Class<InventoryOnlineController> REST_CONTROLLER_NAME = InventoryOnlineController.class;
	@Value("${public.host}")
	private String host;
	@Autowired
	private InventoryOnlineService inventoryOnlineService;
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping(method = { RequestMethod.GET }, path = { "/online/pages" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> listInventoryOnline(
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			@RequestParam("storeIds") List<Integer> storeIds, UriComponentsBuilder uriBuilder,
			HttpServletRequest request, HttpServletResponse httpServletResponse)
			throws MissingServletRequestParameterException {
		this.logger.debug("Start: /pages RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Page", Integer.valueOf(page) }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Size", Integer.valueOf(size) }));
		}

		uriBuilder.host(this.host);
		uriBuilder.port((String) null);
		HashMap data = new HashMap();
		Page inventoryPage = this.inventoryOnlineService.findAllByStoreIds(storeIds, page, size);
		if (null != inventoryPage && inventoryPage.getSize() != 0) {
			data.put("page", Integer.valueOf(page));
			data.put("size", Integer.valueOf(size));
			data.put("totalSize", Long.valueOf(inventoryPage.getTotalElements()));
			data.put("totalPages", Integer.valueOf(inventoryPage.getTotalPages()));
			data.put("data", inventoryPage);
			this.eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent(InventoryOnline.class, uriBuilder,
					httpServletResponse, page, inventoryPage.getTotalPages(), size));
		} else {
			data.put("data", (Object) null);
		}

		this.logger.debug("Start: /pages RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.POST }, path = { "/online/sku" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> listInventory(@RequestBody InventoryBean inventoryBean)
			throws MissingServletRequestParameterException {
		Iterable inventory = this.inventoryOnlineService.findInventoryBySkuAndStoreIds(inventoryBean.skuIds,
				inventoryBean.storeIds);
		return ResponseEntity.ok(inventory);
	}
}