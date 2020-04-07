package com.priceshoes.rest.applications.hateoas.listener;

import com.google.common.base.Preconditions;
import com.priceshoes.rest.applications.hateoas.event.ResourceCreatedEvent;
import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
class ResourceCreatedDiscoverabilityListener implements ApplicationListener<ResourceCreatedEvent> {
	public void onApplicationEvent(ResourceCreatedEvent resourceCreatedEvent) {
		Preconditions.checkNotNull(resourceCreatedEvent);
		HttpServletResponse response = resourceCreatedEvent.getResponse();
		long idOfNewResource = resourceCreatedEvent.getIdOfNewResource();
		this.addLinkHeaderOnResourceCreation(response, idOfNewResource);
	}

	void addLinkHeaderOnResourceCreation(HttpServletResponse response, long idOfNewResource) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idOfNewResource}")
				.buildAndExpand(new Object[] { Long.valueOf(idOfNewResource) }).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
}