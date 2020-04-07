package com.priceshoes.rest.applications.inventory;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.entity.InventoryRetail;
import com.priceshoes.rest.applications.exceptions.InventoryNotFoundException;
import com.priceshoes.rest.applications.hateoas.event.PaginatedResultsRetrievedEvent;
import com.priceshoes.rest.applications.hateoas.event.SingleResourceRetrievedEvent;
import com.priceshoes.rest.applications.service.InventoryRetailService;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({ "/inventory" })
public class InventoryRetailController extends AbstractRestController {
	private static final Class<InventoryRetailController> REST_CONTROLLER_NAME = InventoryRetailController.class;
	@Autowired
	private InventoryRetailService inventoryRetailService;
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/hello" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> hello(@RequestParam(value = "name", defaultValue = "World") String name,
			HttpServletResponse httpServletResponse) {
		this.logger.debug("Start: /hello RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Request Param: %s value: %s", new Object[] { "name", name }));
		}

		Link selfLink = ControllerLinkBuilder.linkTo(
				((InventoryRetailController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.hello(name, httpServletResponse))
				.withSelfRel();
		HashMap data = new HashMap();
		data.put("data", String.format("Hello %s!", new Object[] { name }));
		data.put("data", selfLink);
		this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
		this.logger.debug("End: /hello RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/count" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> count(HttpServletResponse httpServletResponse) {
		this.logger.debug("Starting: /count RESTful Service");
		long count = this.inventoryRetailService.count();
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Number of records: %d", new Object[] { Long.valueOf(count) }));
		}

		Link selfLink = ControllerLinkBuilder.linkTo(
				((InventoryRetailController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.count(httpServletResponse))
				.withSelfRel();
		HashMap data = new HashMap();
		data.put("data", Long.valueOf(count));
		data.put("_links", selfLink);
		this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
		this.logger.debug("Ending: /count RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> listInventory(HttpServletResponse httpServletResponse) throws InventoryNotFoundException {
		this.logger.debug("Starting: / RESTful Service");
		HashMap data = new HashMap();
		List inventoryList = (List) this.inventoryRetailService.findAll();
		if (null == inventoryList) {
			throw new InventoryNotFoundException();
		} else {
			if (!inventoryList.isEmpty()) {
				data.put("data", inventoryList);
				this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
			}

			this.logger.debug("Ending: / RESTful Service");
			return ResponseEntity.ok(data);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/pages" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> listInventory(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse httpServletResponse)
			throws InventoryNotFoundException {
		this.logger.debug("Start: /pages RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Page", Integer.valueOf(page) }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Size", Integer.valueOf(size) }));
		}

		Page inventoryPage = this.inventoryRetailService.findAll(page, size);
		HashMap data = new HashMap();
		if (null == inventoryPage) {
			throw new InventoryNotFoundException("Inventory Not Found");
		} else {
			if (inventoryPage.getSize() != 0) {
				data.put("data", inventoryPage.getContent());
				this.eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent(InventoryRetail.class, uriBuilder,
						httpServletResponse, page, inventoryPage.getTotalPages(), size));
			}

			this.logger.debug("Start: /pages RESTful Service");
			return ResponseEntity.ok(data);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/{id}" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> getRetailInventoryBySkuId(@PathVariable("id") Long id,
			@RequestParam(value = "size", required = false) Double size) throws InventoryNotFoundException {
		this.logger.debug("Starting: /id RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Request Parameter: %s value: %f", new Object[] { "size", size }));
		}

		List inventoryList = null;
		HashMap data = new HashMap();
		if (null == size || size.isNaN() && size.doubleValue() != 0.0D) {
			inventoryList = (List) this.inventoryRetailService.findInventoryBySkuId(id.longValue());
		} else {
			inventoryList = (List) this.inventoryRetailService.findInventoryBySkuAndSizeId(id.longValue(),
					size.doubleValue());
		}

		if (null == inventoryList) {
			throw new InventoryNotFoundException();
		} else {
			if (!inventoryList.isEmpty()) {
				data.put("data", inventoryList);
			}

			this.logger.debug("Ending: /id RESTful Service");
			return ResponseEntity.ok(data);
		}
	}

	@RequestMapping(method = { RequestMethod.POST }, value = { "/retail/list/" }, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<?> getRetailInventoryByIds(@RequestBody List<Long> skuIds) {
		this.logger.debug("Starting: /list RESTful Service");
		HashMap data = new HashMap();
		if (null != skuIds && !skuIds.isEmpty()) {
			List inventoryList = (List) this.inventoryRetailService.findInventoryBySkuIds(skuIds);
			if (null != inventoryList && !inventoryList.isEmpty()) {
				data.put("data", inventoryList);
			} else {
				data.put("data", (Object) null);
			}
		}

		this.logger.debug("Starting: /list RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/stores/{storeId}" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getRetailInventoryByStoreId(@PathVariable("storeId") Long storeId) {
		this.logger.debug("Starting: /stores/storeId RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Request Parameter: %s value: %d", new Object[] { "storeId", storeId }));
		}

		HashMap data = new HashMap();
		List inventoryList = (List) this.inventoryRetailService.findInventoryByStoreId(storeId);
		if (null != inventoryList && !inventoryList.isEmpty()) {
			data.put("data", inventoryList);
		} else {
			data.put("data", (Object) null);
		}

		this.logger.debug("Ending:/stores/storeId RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/stores/{storeId}/pages" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<?> getRetailInventoryByStoreId(@PathVariable("storeId") Integer storeId,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size) {
		this.logger.debug("Starting: /stores/storeId/pages RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Request Parameter: %s value: %d", new Object[] { "storeId", storeId }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "page", Integer.valueOf(page) }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "size", Integer.valueOf(size) }));
		}

		HashMap data = new HashMap();
		Page inventoryPage = this.inventoryRetailService.findInventoryByStoreId(storeId, page, size);
		if (null != inventoryPage && inventoryPage.getNumber() != 0) {
			data.put("data", inventoryPage);
		} else {
			data.put("data", (Object) null);
		}

		this.logger.debug("Ending: /stores/storeId/pages RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/retail/{id}/{storeId}" }, produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<?> getRetailInventoryBySkuAndStoreId(@PathVariable("id") Long skuId,
			@PathVariable("storeId") Integer storeId) {
		this.logger.debug("Starting: /id/storeId RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Path Variable: %s value: %d", new Object[] { "skuId", skuId }));
			this.logger.debug(String.format("Path Variable: %s value: %d", new Object[] { "storeId", storeId }));
		}

		HashMap data = new HashMap();
		List inventoryList = (List) this.inventoryRetailService.findInventoryBySkuAndStoreId(skuId, storeId);
		if (null != inventoryList && !inventoryList.isEmpty()) {
			data.put("data", inventoryList);
		} else {
			data.put("data", (Object) null);
		}

		this.logger.debug("Starting: /id/storeId/ RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.GET }, path = { "/retail/{id}/{storeId}/pages" }, produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<?> getRetailInventoryBySkuAndStoreId(@PathVariable Long skuId, @PathVariable Integer storeId,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size) {
		this.logger.debug("Starting: /id/storeId/pages RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Request Parameter: %s value: %d", new Object[] { "skuId", skuId }));
			this.logger.debug(String.format("Request Parameter: %s value: %d", new Object[] { "storeId", storeId }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "page", Integer.valueOf(page) }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "size", Integer.valueOf(size) }));
		}

		HashMap data = new HashMap();
		Page inventoryPage = this.inventoryRetailService.findInventoryBySkuAndStoreId(skuId, storeId, page, size);
		if (null != inventoryPage && inventoryPage.getSize() != 0) {
			data.put("data", inventoryPage);
		} else {
			data.put("data", (Object) null);
		}

		this.logger.debug("Starting: /id/storeId/pages RESTful Service");
		return ResponseEntity.ok(data);
	}
}