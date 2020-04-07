package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.ArticuloPedido;
import java.util.ArrayList;
import java.util.List;

public class ArticuloPedidoCollection {
	protected List<ArticuloPedido> item;

	public List<ArticuloPedido> getItem() {
		if (this.item == null) {
			this.item = new ArrayList();
		}

		return this.item;
	}

	public void setItem(List<ArticuloPedido> item) {
		this.item = item;
	}
}