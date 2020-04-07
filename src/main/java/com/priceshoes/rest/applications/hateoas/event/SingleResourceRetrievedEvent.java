package com.priceshoes.rest.applications.hateoas.event;

import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;

public class SingleResourceRetrievedEvent extends ApplicationEvent {
	private static final long serialVersionUID = 5410022374684257617L;
	private final HttpServletResponse response;

	public SingleResourceRetrievedEvent(Object source, HttpServletResponse response) {
		super(source);
		this.response = response;
	}

	public HttpServletResponse getResponse() {
		return this.response;
	}
}