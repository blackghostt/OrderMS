package com.priceshoes.rest.applications.hateoas.event;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

public class ResourceCreatedEvent extends ApplicationEvent {
	private static final long serialVersionUID = 8855006564549324966L;
	private final HttpServletResponse response;
	private final long idOfNewResource;

	public ResourceCreatedEvent(Object source, HttpServletResponse response, long idOfNewResource) {
		super(source);
		this.response = response;
		this.idOfNewResource = idOfNewResource;
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}

	public long getIdOfNewResource() {
		return this.idOfNewResource;
	}
}