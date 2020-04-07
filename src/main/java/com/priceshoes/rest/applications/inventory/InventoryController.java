package com.priceshoes.rest.applications.inventory;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.entity.InventoryOnline;
import com.priceshoes.rest.applications.exceptions.RestResourceNotFoundException;
import com.priceshoes.rest.applications.hateoas.event.PaginatedResultsRetrievedEvent;
import com.priceshoes.rest.applications.hateoas.event.SingleResourceRetrievedEvent;
import com.priceshoes.rest.applications.service.InventoryService;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({ "/inventory" })
public class InventoryController extends AbstractRestController {
	private static final Class<InventoryController> REST_CONTROLLER_NAME = InventoryController.class;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping(method = { RequestMethod.GET }, path = { "/hello" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> hello(@RequestParam(value = "name", defaultValue = "World") String name,
			HttpServletResponse httpServletResponse) {
		this.logger.debug("Start: /hello RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Request Param: %s value: %s", new Object[] { "name", name }));
		}

		Link selfLink = ControllerLinkBuilder
				.linkTo(((InventoryController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.hello(name, httpServletResponse))
				.withSelfRel();
		HashMap body = new HashMap();
		body.put("data", String.format("Hello %s!", new Object[] { name }));
		body.put("_links", selfLink);
		this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
		this.logger.debug("End: /hello RESTful Service");
		return ResponseEntity.ok(body);
	}

	@RequestMapping(method = { RequestMethod.GET }, produces = { "application/json", "application/xml" })
	@ResponseBody
	public ResponseEntity<?> getInventory(@RequestParam("type") String type, HttpServletResponse httpServletResponse) {
		this.logger.debug("Starting: / RESTful Service");
		List inventoryList = null;
		HashMap body = new HashMap();
		if ("online".equals(type)) {
			inventoryList = (List) this.inventoryService.findAllOnline();
		} else if ("retail".equals(type)) {
			inventoryList = (List) this.inventoryService.findAllRetail();
		}

		if (null != inventoryList && !inventoryList.isEmpty()) {
			body.put("data", inventoryList);
			this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
		} else {
			body.put("data", (Object) null);
		}

		this.logger.debug("Ending: / RESTful Service");
		return ResponseEntity.ok(body);
	}

	@RequestMapping(method = { RequestMethod.GET }, path = { "/pages" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> getInventory(@RequestParam("type") String type,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse httpServletResponse)
			throws RestResourceNotFoundException {
		this.logger.debug("Starting: / RESTful Service");
		Page inventoryPage = null;
		HashMap body = new HashMap();
		if ("online".equals(type)) {
			inventoryPage = this.inventoryService.findAllOnline(page, size);
		} else if ("retail".equals(type)) {
			inventoryPage = this.inventoryService.findAllRetail(page, size);
		}

		if (null != inventoryPage && page <= inventoryPage.getTotalPages()) {
			body.put("data", body);
			this.eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent(InventoryOnline.class, uriBuilder,
					httpServletResponse, page, inventoryPage.getTotalPages(), size));
			this.logger.debug("Ending: / RESTful Service");
			return ResponseEntity.ok(body);
		} else {
			throw new RestResourceNotFoundException();
		}
	}
}