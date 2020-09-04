package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.consulta.CancelRequest;
import com.priceshoes.rest.applications.consulta.PedidoConsulta;
import com.priceshoes.rest.applications.repository.OrderRepository;
import com.priceshoes.rest.applications.respuesta.CancelResponse;
import com.priceshoes.rest.applications.respuesta.PedidoRespuesta;
import com.priceshoes.rest.applications.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService {
	@Autowired
	private OrderRepository orderRepository;

	public PedidoRespuesta savePedido(PedidoConsulta consulta) throws Exception {
		return this.orderRepository.savePedido(consulta);
	}

	public CancelResponse cancelOrder(CancelRequest consulta) {
		return this.orderRepository.cancelOrder(consulta);
	}
}