package com.priceshoes.rest.applications.hateoas.listener;

import com.priceshoes.rest.applications.hateoas.event.SingleResourceRetrievedEvent;
import com.priceshoes.rest.applications.utils.LinkUtil;
import javax.servlet.http.HttpServletResponse;
import org.assertj.core.util.Preconditions;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
class SingleResourceRetrievedDiscoverabilityListener implements ApplicationListener<SingleResourceRetrievedEvent> {
	public void onApplicationEvent(SingleResourceRetrievedEvent resourceRetrievedEvent) {
		Preconditions.checkNotNull(resourceRetrievedEvent);
		HttpServletResponse response = resourceRetrievedEvent.getResponse();
		this.addLinkHeaderOnSingleResourceRetrieval(response);
	}

	void addLinkHeaderOnSingleResourceRetrieval(HttpServletResponse response) {
		String requestURL = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri().toASCIIString();
		int positionOfLastSlash = requestURL.lastIndexOf("/");
		String uriForResourceCreation = requestURL.substring(0, positionOfLastSlash);
		String linkHeaderValue = LinkUtil.createLinkHeader(uriForResourceCreation, "collection");
		response.addHeader("Link", linkHeaderValue);
	}
}