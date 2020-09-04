package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.consulta.CancelRequest;
import com.priceshoes.rest.applications.consulta.PedidoConsulta;
import com.priceshoes.rest.applications.respuesta.CancelResponse;
import com.priceshoes.rest.applications.respuesta.PedidoRespuesta;

public interface OrderRepository {
	PedidoRespuesta savePedido(PedidoConsulta arg0) throws Exception;

	PedidoRespuesta guardaPedido(PedidoConsulta arg0) throws Exception;

	CancelResponse cancelOrder(CancelRequest consulta);
}