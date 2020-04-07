package com.priceshoes.rest.applications.bean;

import com.priceshoes.rest.applications.bean.Direccion;
import java.util.ArrayList;
import java.util.List;

public class DireccionCollection {
	protected List<Direccion> direccion;

	public List<Direccion> getDireccion() {
		if (this.direccion == null) {
			this.direccion = new ArrayList();
		}

		return this.direccion;
	}

	public void set(List<Direccion> direcciones) {
		this.direccion = direcciones;
	}
}