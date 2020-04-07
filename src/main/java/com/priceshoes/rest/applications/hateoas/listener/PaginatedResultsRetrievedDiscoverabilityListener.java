package com.priceshoes.rest.applications.hateoas.listener;

import com.priceshoes.rest.applications.hateoas.event.PaginatedResultsRetrievedEvent;
import com.priceshoes.rest.applications.utils.LinkUtil;
import javax.servlet.http.HttpServletResponse;
import org.assertj.core.util.Preconditions;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PaginatedResultsRetrievedDiscoverabilityListener
		implements ApplicationListener<PaginatedResultsRetrievedEvent> {
	private static final String PAGE = "/pages";

	public final void onApplicationEvent(PaginatedResultsRetrievedEvent ev) {
		Preconditions.checkNotNull(ev);
		this.addLinkHeaderOnPagedResourceRetrieval(ev.getUriBuilder(), ev.getResponse(), ev.getClazz(), ev.getPage(),
				ev.getTotalPages(), ev.getPageSize());
	}

	final void addLinkHeaderOnPagedResourceRetrieval(UriComponentsBuilder uriBuilder, HttpServletResponse response,
			Class clazz, int page, int totalPages, int pageSize) {
		StringBuilder linkHeader = new StringBuilder();
		String uriForLastPage;
		if (this.hasNextPage(page, totalPages)) {
			uriForLastPage = this.constructNextPageUri(uriBuilder, page, pageSize);
			linkHeader.append(LinkUtil.createLinkHeader(uriForLastPage, "next"));
		}

		if (this.hasPreviousPage(page)) {
			uriForLastPage = this.constructPrevPageUri(uriBuilder, page, pageSize);
			this.appendCommaIfNecessary(linkHeader);
			linkHeader.append(LinkUtil.createLinkHeader(uriForLastPage, "prev"));
		}

		if (this.hasFirstPage(page)) {
			uriForLastPage = this.constructFirstPageUri(uriBuilder, pageSize);
			this.appendCommaIfNecessary(linkHeader);
			linkHeader.append(LinkUtil.createLinkHeader(uriForLastPage, "first"));
		}

		if (this.hasLastPage(page, totalPages)) {
			uriForLastPage = this.constructLastPageUri(uriBuilder, totalPages, pageSize);
			this.appendCommaIfNecessary(linkHeader);
			linkHeader.append(LinkUtil.createLinkHeader(uriForLastPage, "last"));
		}

		if (linkHeader.length() > 0) {
			response.addHeader("Link", linkHeader.toString());
		}

	}

	final String constructNextPageUri(UriComponentsBuilder uriBuilder, int page, int size) {
		return uriBuilder.replaceQueryParam("/pages", new Object[] { Integer.valueOf(page + 1) })
				.replaceQueryParam("size", new Object[] { Integer.valueOf(size) }).build().encode().toUriString();
	}

	final String constructPrevPageUri(UriComponentsBuilder uriBuilder, int page, int size) {
		return uriBuilder.replaceQueryParam("/pages", new Object[] { Integer.valueOf(page - 1) })
				.replaceQueryParam("size", new Object[] { Integer.valueOf(size) }).build().encode().toUriString();
	}

	final String constructFirstPageUri(UriComponentsBuilder uriBuilder, int size) {
		return uriBuilder.replaceQueryParam("/pages", new Object[] { Integer.valueOf(0) })
				.replaceQueryParam("size", new Object[] { Integer.valueOf(size) }).build().encode().toUriString();
	}

	final String constructLastPageUri(UriComponentsBuilder uriBuilder, int totalPages, int size) {
		return uriBuilder.replaceQueryParam("/pages", new Object[] { Integer.valueOf(totalPages) })
				.replaceQueryParam("size", new Object[] { Integer.valueOf(size) }).build().encode().toUriString();
	}

	final boolean hasNextPage(int page, int totalPages) {
		return page < totalPages - 1;
	}

	final boolean hasPreviousPage(int page) {
		return page > 0;
	}

	final boolean hasFirstPage(int page) {
		return this.hasPreviousPage(page);
	}

	final boolean hasLastPage(int page, int totalPages) {
		return totalPages > 1 && this.hasNextPage(page, totalPages);
	}

	final void appendCommaIfNecessary(StringBuilder linkHeader) {
		if (linkHeader.length() > 0) {
			linkHeader.append(", ");
		}

	}

	protected void plural(UriComponentsBuilder uriBuilder, Class clazz) {
		String resourceName = clazz.getSimpleName().toLowerCase() + "s";
		uriBuilder.path(resourceName);
	}
}