package com.priceshoes.rest.applications.order;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.consulta.PedidoConsulta;
import com.priceshoes.rest.applications.respuesta.PedidoRespuesta;
import com.priceshoes.rest.applications.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/order" })
public class OrderController extends AbstractRestController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = { "/saveOrder" }, method = { RequestMethod.POST })
	public ResponseEntity<PedidoRespuesta> savePedido(@RequestBody PedidoConsulta consulta) {
		PedidoRespuesta respuesta = null;

		try {
			respuesta = this.orderService.savePedido(consulta);
		} catch (Exception arg3) {
			respuesta = new PedidoRespuesta();
			respuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuesta.setMensaje(arg3.toString());
			this.logError(arg3.toString());
		}

		return ResponseEntity.ok(respuesta);
	}
}