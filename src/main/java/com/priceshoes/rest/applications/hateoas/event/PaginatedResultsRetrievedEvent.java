package com.priceshoes.rest.applications.hateoas.event;

import java.io.Serializable;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

public final class PaginatedResultsRetrievedEvent<T extends Serializable> extends ApplicationEvent {
	private static final long serialVersionUID = 1231052397052024599L;
	private final UriComponentsBuilder uriBuilder;
	private final HttpServletResponse response;
	private final int page;
	private final int totalPages;
	private final int pageSize;

	public PaginatedResultsRetrievedEvent(Class<T> clazz, UriComponentsBuilder uriBuilderToSet,
			HttpServletResponse responseToSet, int pageToSet, int totalPagesToSet, int pageSizeToSet) {
		super(clazz);
		this.uriBuilder = uriBuilderToSet;
		this.response = responseToSet;
		this.page = pageToSet;
		this.totalPages = totalPagesToSet;
		this.pageSize = pageSizeToSet;
	}

	public final UriComponentsBuilder getUriBuilder() {
		return this.uriBuilder;
	}

	public final HttpServletResponse getResponse() {
		return this.response;
	}

	public final int getPage() {
		return this.page;
	}

	public final int getTotalPages() {
		return this.totalPages;
	}

	public final int getPageSize() {
		return this.pageSize;
	}

	public final Class<T> getClazz() {
		return (Class) this.getSource();
	}
}