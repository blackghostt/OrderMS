package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.FormaPagoPedido;
import java.util.ArrayList;
import java.util.List;

public class FormasPagoPedidoCollection {
	protected List<FormaPagoPedido> item;

	public List<FormaPagoPedido> getItem() {
		if (this.item == null) {
			this.item = new ArrayList();
		}

		return this.item;
	}

	public void setItem(List<FormaPagoPedido> item) {
		this.item = item;
	}
}