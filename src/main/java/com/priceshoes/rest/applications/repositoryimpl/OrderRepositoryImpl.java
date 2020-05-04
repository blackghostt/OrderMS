package com.priceshoes.rest.applications.repositoryimpl;

import com.google.gson.Gson;
import com.priceshoes.rest.applications.bean.ArticuloPedido;
import com.priceshoes.rest.applications.bean.FormaPagoPedido;
import com.priceshoes.rest.applications.bean.Pedido;
import com.priceshoes.rest.applications.consulta.PedidoConsulta;
import com.priceshoes.rest.applications.entity.MemberAddress;
import com.priceshoes.rest.applications.entity.PedidoMagento;
import com.priceshoes.rest.applications.entity.Procedure;
import com.priceshoes.rest.applications.entity.PsDeposito;
import com.priceshoes.rest.applications.entity.PsFPagoEcomm;
import com.priceshoes.rest.applications.entity.PsPedtmk;
import com.priceshoes.rest.applications.entity.PsPedtmkAplval;
import com.priceshoes.rest.applications.entity.PsPedtmkDep;
import com.priceshoes.rest.applications.entity.PsPedtmkDet;
import com.priceshoes.rest.applications.entity.PsPedtmkDetPK;
import com.priceshoes.rest.applications.entity.PsPedtmkVin;
import com.priceshoes.rest.applications.repository.OrderRepository;
import com.priceshoes.rest.applications.respuesta.PedidoRespuesta;
import com.priceshoes.rest.applications.utils.Constantes;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
	private static Logger log = Logger.getLogger(OrderRepositoryImpl.class);
	@Autowired	private SessionFactory sessionFactory;
	@Autowired 	private Environment env;
	
	@Transactional(readOnly = false, rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public PedidoRespuesta savePedido(PedidoConsulta consulta) {
		PedidoRespuesta respuesta = new PedidoRespuesta();

		try 
		{
			respuesta = this.guardaPedido(consulta);
		} catch (Exception arg3) {
			log.info((new Gson()).toJson(consulta));
			log.error(arg3.getMessage(), arg3);
			respuesta.setMensaje(arg3.getMessage());
		}

		return respuesta;
	}

	// Modificacion de proceso - Onofre - 07/04/2020
	// Se actualizo el metodo para soportar transacciones concurrentes ya que el pool se está agotando
	@SuppressWarnings("rawtypes")
	public PedidoRespuesta guardaPedido(PedidoConsulta consulta) throws Exception 
	{
		Long SUCURSAL = Long.valueOf( env.getProperty("price.sucursal"));
		PedidoRespuesta respuesta = new PedidoRespuesta();
		Pedido pedidoAlta = consulta.getPedido();
		Long consecutivo = Long.valueOf(1L);
		Long value = Long.valueOf(0L);
		boolean errorConocido = false;
		String soIdStr = pedidoAlta.getSocioIdPs().trim();
		log.info("Entrando a método guardaPedido");
		log.info("************ INPUT JSON *************");
		log.info((new Gson()).toJson(consulta));
		log.info("********** BUSCAR PEDIDO MAGENTO EN EL SOFT **********");
		log.info("Numero de Socio: " + soIdStr);
		log.info("Numero de Pedido Magento: " + consulta.getPedido().getPedidoMagento());
		
		try
		{
			String query =" select PPVMX.PCK_MAGENTO.F_GET_PEDIDO_MAGENTO(:pedidoMagento) from dual ";
			BigDecimal result = (BigDecimal) sessionFactory.getCurrentSession().createSQLQuery(query)
					.setParameter("pedidoMagento", pedidoAlta.getPedidoMagento()).uniqueResult();

			if (result != null && result.longValue() > 0L)
			{	errorConocido = true;
				respuesta.setCodigo(99);
				respuesta.setMensaje("El pedido Magento ya fue replicado al Soft, Pedido Soft: " + result.longValue());
				log.warn( new Gson().toJson(respuesta) );
				return respuesta;
			}
		}catch (Exception e){
			log.error(e.getMessage(),e);
			respuesta.setCodigo(99);
			respuesta.setMensaje(e.getMessage());
			return respuesta;
		}

		log.info(" == Inicia proceso de registro de orden ");

		Session sess = sessionFactory.openSession();
		Transaction tx = null;

		try
		{	tx = sess.beginTransaction();
			Integer[] idDirecciones = new Integer[] { pedidoAlta.getDireccionEnvio().getIdDireccionPs(),pedidoAlta.getDireccionPago().getIdDireccionPs() };
			Iterator altaPed;
			if (pedidoAlta.getFormasPagos() != null)
			{
				if (pedidoAlta.getFormasPagos().getItem().size() == 0)
				{	errorConocido = true;
					respuesta.setCodigo(Constantes.COD_ERROR_ENTRADA_INSUFICIENTE);
					respuesta.setMensaje("Todos los datos de la forma de pago son requeridos.");
					log.error(new Gson().toJson(respuesta));
					return respuesta;
				}

				altaPed = pedidoAlta.getFormasPagos().getItem().iterator();

				label874: while (true)
				{	while (true)
				{
					if (!altaPed.hasNext())
					{  break label874; }

					FormaPagoPedido iter = (FormaPagoPedido) altaPed.next();
					if (((FormaPagoPedido) pedidoAlta.getFormasPagos().getItem().get(0)).getFormaPago() != null &&
							((FormaPagoPedido) pedidoAlta.getFormasPagos().getItem().get(0)).getCantidad()  != null )
					{
						String query = iter.getFormaPago();
						log.info("iter.getFormaPago " + query );
						String iterUser = "";
						iterUser = iterUser + "SELECT CLAVE ";
						iterUser = iterUser + "  FROM (SELECT ROWNUM AS CONSE, CLAVE";
						iterUser = iterUser + " \t       FROM (SELECT FPE_CVE_STR AS CLAVE";
						iterUser = iterUser + "                  FROM PS_FPAGO_ECOMM";
						iterUser = iterUser + "                 WHERE FPE_CVE_STR = \'" + query + "\'";
						iterUser = iterUser + "                 UNION";
						iterUser = iterUser + "                 SELECT \'0\' FROM DUAL)";
						iterUser = iterUser + "           ORDER BY 1)";
						iterUser = iterUser + " WHERE CONSE = 2";
						SQLQuery usuario = sess.createSQLQuery(iterUser);
						query = (String) usuario.uniqueResult();
						log.info("Forma pago " + query );
						if (query.equals("0"))
						{	errorConocido = true;
							respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
							respuesta.setMensaje("La forma de pago es incorrecta.");
							break label874;
						}
					} else {
						errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_ENTRADA_INSUFICIENTE);
						respuesta.setMensaje("Todos los datos de la forma de pago son requeridos.");
					}

				}//end while
				}//label874
			}//if getFormasPagos

			altaPed = pedidoAlta.getItems().getItem().iterator();

			while (altaPed.hasNext())
			{	ArticuloPedido arg47 = (ArticuloPedido) altaPed.next();
				if (arg47.getArticulo().getIdArticuloPs() == null)
				{	errorConocido = true;
					respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_ARTICULO);
					respuesta.setMensaje("El id art es obligatorio.");
				} else if (arg47.getArticulo().getTalla() == null)
				{	errorConocido = true;
					respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_ARTICULO);
					respuesta.setMensaje("La talla del articulo es obligatoria.");
				} else if (arg47.getArticulo().getPrecio() == null)
				{	errorConocido = true;
					respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_ARTICULO);
					respuesta.setMensaje("El precio del articulo es obligatorio.");
				}
			}//end while

			if (errorConocido)
			{ 	log.error(new Gson().toJson(respuesta));
				return respuesta;
			}

			for (int arg46 = 0; arg46 < idDirecciones.length; ++arg46)
			{
				Criteria arg50 = sess.createCriteria(MemberAddress.class);
				arg50.add(Restrictions.eq("id.soIdStr", soIdStr ))
						.add(Restrictions.eq("id.sodConsN", Long.valueOf(idDirecciones[arg46].longValue())));

				MemberAddress arg52 = (MemberAddress) arg50.uniqueResult();
				MemberAddress arg56 = new MemberAddress();
				log.info("Verificando Dir " + idDirecciones[arg46]);

				if (arg52 == null)
				{
					log.info("Creando Dir");
					log.info("MemberAddress" + new Gson().toJson(arg52));
					log.info("pedidoAlta.getSocioIdPs " +new Gson().toJson(soIdStr));
					arg56.getId().setSoIdStr(soIdStr);
					arg56.getId().setSodConsN(Long.valueOf(idDirecciones[arg46].longValue()));
					arg56.setSodEstStr("A");

					if (pedidoAlta.getDireccionEnvio().getPaisId() != null) {
						arg56.setPaCveN(arg46 == 0 ? pedidoAlta.getDireccionEnvio().getPaisId()	: pedidoAlta.getDireccionPago().getPaisId());
					} else
					{	errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
						respuesta.setMensaje("El Pais es obligario.");
					}

					if (pedidoAlta.getDireccionEnvio().getEstadoId() != null){
						arg56.setEdCveN(arg46 == 0 ? pedidoAlta.getDireccionEnvio().getEstadoId() : pedidoAlta.getDireccionPago().getEstadoId());
					} else
					{	errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
						respuesta.setMensaje("El estado es obligario.");
					}

					arg56.setMuCveN(arg46 == 0 ? pedidoAlta.getDireccionEnvio().getMunicipioId() : pedidoAlta.getDireccionPago().getMunicipioId());

					if (pedidoAlta.getDireccionEnvio().getCiudad() != null	&& !pedidoAlta.getDireccionEnvio().getCiudad().trim().equals("")){
						arg56.setSodCdStr(arg46 == 0 ? pedidoAlta.getDireccionEnvio().getCiudad().toUpperCase(): pedidoAlta.getDireccionPago().getCiudad().toUpperCase());
					} else
					{	errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
						respuesta.setMensaje("La Ciudad es obligaria.");
					}

					if (pedidoAlta.getDireccionEnvio().getCalle() != null && !pedidoAlta.getDireccionEnvio().getCalle().trim().equals("")) {
						arg56.setSodCalleStr( arg46 == 0 ? pedidoAlta.getDireccionEnvio().getCalle().toUpperCase(): pedidoAlta.getDireccionPago().getCalle().toUpperCase());
					} else
					{	errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
						respuesta.setMensaje("El Municipio es obligario.");
					}

					if (pedidoAlta.getDireccionEnvio().getCodigoPostal() != null && !pedidoAlta.getDireccionEnvio().getCodigoPostal().trim().equals("")) {
						arg56.setSodCpStr(arg46 == 0 ? pedidoAlta.getDireccionEnvio().getCodigoPostal()	: pedidoAlta.getDireccionPago().getCodigoPostal());
					} else
					{	errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
						respuesta.setMensaje("El Código postal es obligario.");
					}

					if (pedidoAlta.getDireccionEnvio().getNumero() != null && !pedidoAlta.getDireccionEnvio().getNumero().trim().equals("")) {
						arg56.setSodNumStr(pedidoAlta.getDireccionEnvio().getNumero());
					} else
					{	errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
						respuesta.setMensaje("El Numero es obligario.");
					}

					if (pedidoAlta.getDireccionEnvio().getColonia() != null && !pedidoAlta.getDireccionEnvio().getColonia().trim().equals("")) {
						arg56.setSodColStr(pedidoAlta.getDireccionEnvio().getColonia());
					} else
					{	errorConocido = true;
						respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_DIRECCION);
						respuesta.setMensaje("El Colonia es obligario.");
					}

					if (pedidoAlta.getDireccionEnvio().getTelefono1() != null && !pedidoAlta.getDireccionEnvio().getTelefono1().trim().equals("")) {
						arg56.setSodTel1Str(arg46 == 0 ? pedidoAlta.getDireccionEnvio().getTelefono1() : pedidoAlta.getDireccionPago().getTelefono1());
					}

					if (pedidoAlta.getDireccionEnvio().getTelefono2() != null && !pedidoAlta.getDireccionEnvio().getTelefono2().equals("")) {
						arg56.setSodTel2Str(arg46 == 0 ? pedidoAlta.getDireccionEnvio().getTelefono2() : pedidoAlta.getDireccionPago().getTelefono2());
					}

					if (pedidoAlta.getDireccionEnvio().getObservaciones() != null && !pedidoAlta.getDireccionEnvio().getObservaciones().trim().equals(""))
					{
						log.info("DireccionEnvio:" + new Gson().toJson(pedidoAlta.getDireccionEnvio()));
						log.info("DireccionPago:" +  new Gson().toJson(pedidoAlta.getDireccionPago()));
						if (pedidoAlta.getDireccionPago().getObservaciones() == null) {
							pedidoAlta.getDireccionPago().setObservaciones("");
						}
						arg56.setSodObsStr( arg46 == 0 ? pedidoAlta.getDireccionEnvio().getObservaciones().toUpperCase() : pedidoAlta.getDireccionPago().getObservaciones().toUpperCase());
					}

					if (errorConocido)
					{	log.error(new Gson().toJson(respuesta));
						return respuesta;
					}

					log.info("MemberAddress " +new Gson().toJson(arg56));
					sess.save(arg56);
				} //end if arg52
				else
				{
					log.info("Existe");
					switch (arg46)
					{
						case 0:	if (pedidoAlta.getDireccionEnvio().getEstadoId() != null)
						{ arg52.setEdCveN(pedidoAlta.getDireccionEnvio().getEstadoId()); }
							if (pedidoAlta.getDireccionEnvio().getCiudad() != null 	&& !pedidoAlta.getDireccionEnvio().getCiudad().trim().equals(""))
							{ arg52.setSodCdStr(pedidoAlta.getDireccionEnvio().getCiudad().toUpperCase());}
							if (pedidoAlta.getDireccionEnvio().getCalle() != null && !pedidoAlta.getDireccionEnvio().getCalle().trim().equals(""))
							{ arg52.setSodCalleStr(pedidoAlta.getDireccionEnvio().getCalle().toUpperCase());}
							if (pedidoAlta.getDireccionEnvio().getCodigoPostal() != null && !pedidoAlta.getDireccionEnvio().getCodigoPostal().trim().equals(""))
							{ arg52.setSodCpStr(pedidoAlta.getDireccionEnvio().getCodigoPostal()); }
							if (pedidoAlta.getDireccionEnvio().getNumero() != null	&& !pedidoAlta.getDireccionEnvio().getNumero().trim().equals(""))
							{ arg52.setSodNumStr(pedidoAlta.getDireccionEnvio().getNumero().toUpperCase());}
							if (pedidoAlta.getDireccionEnvio().getColonia() != null	&& !pedidoAlta.getDireccionEnvio().getColonia().trim().equals(""))
							{ arg52.setSodColStr(pedidoAlta.getDireccionEnvio().getColonia().toUpperCase());}
							if (pedidoAlta.getDireccionEnvio().getTelefono1() != null && !pedidoAlta.getDireccionEnvio().getTelefono1().trim().equals(""))
							{ arg52.setSodTel1Str(pedidoAlta.getDireccionEnvio().getTelefono1());}
							if (pedidoAlta.getDireccionEnvio().getTelefono2() != null && !pedidoAlta.getDireccionEnvio().getTelefono2().equals(""))
							{ arg52.setSodTel2Str(pedidoAlta.getDireccionEnvio().getTelefono2());}
							if (pedidoAlta.getDireccionEnvio().getObservaciones() != null && !pedidoAlta.getDireccionEnvio().getObservaciones().trim().equals(""))
							{ arg52.setSodObsStr(pedidoAlta.getDireccionEnvio().getObservaciones().toUpperCase()); }
							break;
						default:
							if (pedidoAlta.getDireccionPago().getEstadoId() != null)
							{ arg52.setEdCveN(pedidoAlta.getDireccionPago().getEstadoId()); }
							if (pedidoAlta.getDireccionPago().getMunicipioId() != null && pedidoAlta.getDireccionPago().getMunicipioId().intValue() > 0)
							{ arg52.setMuCveN(pedidoAlta.getDireccionPago().getMunicipioId()); }
							if (pedidoAlta.getDireccionPago().getCiudad() != null && !pedidoAlta.getDireccionPago().getCiudad().trim().equals(""))
							{ arg52.setSodCdStr(pedidoAlta.getDireccionPago().getCiudad().toUpperCase()); }
							if (pedidoAlta.getDireccionPago().getCalle() != null && !pedidoAlta.getDireccionPago().getCalle().trim().equals(""))
							{ arg52.setSodCalleStr(pedidoAlta.getDireccionPago().getCalle().toUpperCase()); }
							if (pedidoAlta.getDireccionPago().getCodigoPostal() != null	&& !pedidoAlta.getDireccionPago().getCodigoPostal().trim().equals(""))
							{ arg52.setSodCpStr(pedidoAlta.getDireccionPago().getCodigoPostal());}
							if (pedidoAlta.getDireccionPago().getNumero() != null && !pedidoAlta.getDireccionPago().getNumero().trim().equals(""))
							{ arg52.setSodNumStr(pedidoAlta.getDireccionPago().getNumero().toUpperCase()); }
							if (pedidoAlta.getDireccionPago().getColonia() != null && !pedidoAlta.getDireccionPago().getColonia().trim().equals(""))
							{ arg52.setSodColStr(pedidoAlta.getDireccionPago().getColonia().toUpperCase()); }
							if (pedidoAlta.getDireccionPago().getTelefono1() != null && !pedidoAlta.getDireccionPago().getTelefono1().trim().equals(""))
							{ arg52.setSodTel1Str(pedidoAlta.getDireccionPago().getTelefono1());}
							if (pedidoAlta.getDireccionPago().getTelefono2() != null && !pedidoAlta.getDireccionPago().getTelefono2().equals(""))
							{ arg52.setSodTel2Str(pedidoAlta.getDireccionPago().getTelefono2()); }
							if (pedidoAlta.getDireccionPago().getObservaciones() != null && !pedidoAlta.getDireccionPago().getObservaciones().trim().equals(""))
							{ arg52.setSodObsStr(pedidoAlta.getDireccionPago().getObservaciones().toUpperCase()); }
					}//end switch
				}//end else
			}// end for idDirecciones

			PsPedtmk arg48 = new PsPedtmk();
			SQLQuery arg53 = sess.createSQLQuery("SELECT PPVMX.SEQ_PS_PEDTMK.NEXTVAL FROM DUAL");
			Iterator arg51 = arg53.list().iterator();
			value = Long.valueOf(((BigDecimal) arg51.next()).longValue());
			arg53 = sess.createSQLQuery("SELECT USER FROM DUAL");
			Iterator arg57 = arg53.list().iterator();
			String arg55 = (String) arg57.next();
			arg53 = sess.createSQLQuery("SELECT SYSDATE FROM DUAL");
			Iterator iterDate = arg53.list().iterator();
			Date fechaServ = (Date) iterDate.next();
			arg48.getId().setPtNumN(value);
			arg48.setPtRefN(value);
			arg48.setSoIdStr(soIdStr);
			arg48.getId().setTiCveN(SUCURSAL);
			arg48.setPtFecDt(fechaServ);
			arg48.setUsrCvePstr(arg55);
			arg48.setPtImporteN(pedidoAlta.getImporteTotal());
			arg48.setPtCosenvN(pedidoAlta.getGastosEnvio());
			arg48.setPtSegmensN(pedidoAlta.getSeguroMensajeria());
			arg48.setPtDescN(Double.valueOf(0.0D));
			arg48.setPtEstStr("A");
			arg48.setPtResurN(Long.valueOf(0L));
			arg48.setPtNresurN(Long.valueOf(0L));
			arg48.setPtParesN(Long.valueOf(1L));
			arg48.setPtTotpaqN(Long.valueOf(0L));
			arg48.setPtPesoN(Double.valueOf(0.0D));
			arg48.setPtTipStr(pedidoAlta.getTipoPedido());
			arg48.setPtSodEnvN(pedidoAlta.getDireccionEnvio().getIdDireccionPs());
			arg48.setPtSodFacN(pedidoAlta.getDireccionPago().getIdDireccionPs());
			arg48.setPtOnlineN(Long.valueOf(pedidoAlta.getFormaPedido().equals("A") ? 0L : 1L));
			Double dblTotalPed = Double.valueOf(0.0D);
			int numArt = 0;
			long intTotArt = 0L;
			boolean numApartado = false;
			Iterator altaPedDetalles = pedidoAlta.getItems().getItem().iterator();

			int altaTmkDeposito;
			while (altaPedDetalles.hasNext())
			{
				ArticuloPedido conseDepNum = (ArticuloPedido) altaPedDetalles.next();
				int consecutivoDep = ((ArticuloPedido) pedidoAlta.getItems().getItem().get(numArt)).getCantidad().intValue();
				++numArt;

				for (altaTmkDeposito = 0; altaTmkDeposito < consecutivoDep; ++altaTmkDeposito)
				{	++intTotArt;
					dblTotalPed = Double.valueOf(dblTotalPed.doubleValue() + conseDepNum.getArticulo().getPrecio().doubleValue());
					if (!conseDepNum.getArticulo().getApartado().equals("T") && !numApartado) {
						numApartado = true;
					}
				}
			}//end while altaPedDetalles

			if (!numApartado)
			{	arg48.setPtEstStr("T");}

			arg48.setPtParesN(Long.valueOf(intTotArt));
			arg48.setPtImporteN(dblTotalPed);

			try {  sess.save(arg48); }
			catch (Exception arg41){  arg41.printStackTrace(); }

			log.info("");
			log.info("Pedido\t\t: " + value);
			log.info("Pedido Magento\t: " + pedidoAlta.getPedidoMagento());
			log.info("Id usuario\t\t: " + arg48.getSoIdStr());
			log.info("Fecha de pedido \t: " + arg48.getPtFecDt());
			log.info("Usuario\t\t\t: " + arg48.getUsrCvePstr());
			log.info("Tipo de Pedido \t: " + arg48.getPtTipStr());
			log.info("Importe total \t: " + arg48.getPtImporteN());
			log.info("Gastos de envio\t: " + arg48.getPtCosenvN());
			log.info("Seguro Mensajeria\t: " + arg48.getPtSegmensN());
			log.info("Direccion envio\t: " + arg48.getPtSodEnvN());
			log.info("Direccion pago\t: " + arg48.getPtSodFacN());
			log.info("Forma de pedido\t: " + arg48.getPtOnlineN());
			log.info("");
			new PsPedtmkDet();
			numArt = 0;
			Iterator arg59 = pedidoAlta.getItems().getItem().iterator();

			while (arg59.hasNext())
			{
				ArticuloPedido arg61 = (ArticuloPedido) arg59.next();
				altaTmkDeposito = ((ArticuloPedido) pedidoAlta.getItems().getItem().get(numArt)).getCantidad().intValue();
				++numArt;

				for (int altaDeposito = 0; altaDeposito < altaTmkDeposito; ++altaDeposito)
				{
					PsPedtmkDet arg58 = new PsPedtmkDet();
					arg58.getId().setTiCveN(SUCURSAL);
					arg58.getId().setPtNumN(arg48.getId().getPtNumN());
					PsPedtmkDetPK arg9999 = arg58.getId();
					Long oferta = consecutivo;
					consecutivo = Long.valueOf(consecutivo.longValue() + 1L);
					arg9999.setPtdNumN(oferta);
					arg58.setIdArt(arg61.getArticulo().getIdArticuloPs());
					arg58.setTaCveN(arg61.getArticulo().getTalla());
					arg58.setPtdPrecN(arg61.getArticulo().getPrecio());
					arg58.setPtdCantN(Long.valueOf(1L));
					arg58.setPtdDescN(arg61.getDescuento());
					oferta = Long.valueOf(0L);
					arg58.setPtdOferN(oferta);
					arg58.setPtdEstStr(arg61.getArticulo().getApartado());

					if (arg61.getArticulo().getApartado().equals("T")) {
						arg58.setPtdCotN(Long.valueOf(1L));
					} else {
						arg58.setPtdCotN(Long.valueOf(0L));
					}

					arg58.setPtdOpcN(Long.valueOf(0L));
					sess.save(arg58);
					log.info("");
					log.info("Articulo \t:" + arg58.getIdArt());
					log.info("Talla\t \t:" + arg58.getTaCveN());
					log.info("Precio\t:" + arg58.getPtdPrecN());
					log.info("Tipo   \t:" + arg58.getPtdEstStr());
					log.info("");
				}//end for altaTmkDeposito
			}// end while
			
				if (pedidoAlta.getFormasPagos() != null)
				{
					new PsPedtmkDep();
					new PsDeposito();
					tx.commit();
					tx = sess.beginTransaction();
					Iterator arg65 = pedidoAlta.getFormasPagos().getItem().iterator();
	
					while (arg65.hasNext())
					{
						FormaPagoPedido formaPago = (FormaPagoPedido) arg65.next();
						String cveFormaPago = formaPago.getFormaPago();
						PsFPagoEcomm fPagoEcomm = null;
						Criteria critFP = sess.createCriteria(PsFPagoEcomm.class);
						critFP.add(Restrictions.eq("fpeCveStr", cveFormaPago));
						fPagoEcomm = (PsFPagoEcomm) critFP.uniqueResult();
	
						if (fPagoEcomm.getFpeCveStr().equals("F")) //FREE
						{	
							log.info("Forma de pago Free");
							respuesta.setBandera(true);
							respuesta.getFormaPagoPedido().setFormaPago(cveFormaPago);
							respuesta.getFormaPagoPedido().setCantidad(formaPago.getCantidad());
							this.guardarDoctos(value, respuesta.getFormaPagoPedido().getCantidad(),arg48.getSoIdStr(), sess);
						} else if (fPagoEcomm.getFpeCveStr().equals("S")) //SALDO
						{	
							log.info("Forma de pago Saldo");
							respuesta.setBanderaSaldo(true);
							respuesta.getFormaPagoPedido().setFormaPago(cveFormaPago);
							respuesta.getFormaPagoPedido().setCantidad(formaPago.getCantidad());
							this.guardarSaldo(value, respuesta.getFormaPagoPedido().getCantidad(),arg48.getSoIdStr(), sess);
						} else if (fPagoEcomm.getFpeCveStr().equals("C")) //CREDITO
						{
							log.info("Forma de pago Credito ");
							PsPedtmkVin tmkVin = new PsPedtmkVin(value,SUCURSAL,formaPago.getCantidad(),"A");
							log.info("Credito " + new Gson().toJson(tmkVin));
							sess.save(tmkVin);
						}
						 else if (fPagoEcomm.getFpeCveStr().equals("V")) //VALE
						{	log.info("Utilizar vale ");
							try 
							{	String query = " SELECT VA_NUM_N FROM PS_VALES A " + 
												" WHERE A.VA_EXC_STR = 'F' " + 
												" AND A.VA_EST_STR='A' " + 
												" AND A.SO_ID_STR = '"+soIdStr+"' ";
								BigDecimal result = (BigDecimal) sess.createSQLQuery(query).uniqueResult();
								log.info(" Vale " + new Gson().toJson(result));
								if( result!=null && result.longValue() > 0 )
								{
									PsPedtmkAplval valeAfi = new PsPedtmkAplval(value,SUCURSAL,result.longValue(),1);
									log.info("valeAfi " + new Gson().toJson(valeAfi));
									sess.save(valeAfi);
								}
							}catch (Exception e){ log.error(e.getMessage(),e); }
						}
						else	
						{
							if (!fPagoEcomm.getFpeCveStr().equals("K"))
							{
								boolean insertado = false;
								int countDep = 1;
								while(!insertado && countDep <= 10 )
								{
									log.info("Deposito intento "+countDep);
									insertado = registrarDeposito
												(countDep,
												SUCURSAL,
												value.longValue(),
												fPagoEcomm.getBaCveN(),
												soIdStr,
												pedidoAlta.getImporteTotal(),
												formaPago.getReferencia().equals("") ? "009999" : formaPago.getReferencia(),
												fechaServ,	
												pedidoAlta.getFormaPedido().equals("A") ? "A" : "T",
												fPagoEcomm.getFpeTipoStr(),
												cveFormaPago);
									countDep++;
								}
							}
						}
					}//end while
				}// end if getFormasPagos
			
			respuesta.setValue(value);

			log.info("********** INSERTA PEDIDO MAGENTO EN EL SOFT **********");
			log.info("Numero de Socio: " + soIdStr );
			log.info("Numero de Pedido Magento: " + consulta.getPedido().getPedidoMagento());
			log.info("Numero de Pedido Soft   : " + value);
			PedidoMagento pedidoMagento = new PedidoMagento();
			pedidoMagento.setTiCveN(SUCURSAL);
			pedidoMagento.setPtmMagentoStr( pedidoAlta.getPedidoMagento() );
			pedidoMagento.setPtNumN(value);
			sess.save(pedidoMagento);
			tx.commit();
			sess.flush();

		} catch (NumberFormatException arg42)
		{	log.info((new Gson()).toJson(consulta));
			log.error(arg42.getMessage(), arg42);
			respuesta.setCodigo(Constantes.COD_ERROR_FORMATO_NO_VALIDO);
			respuesta.setMensaje(Constantes.COD_ERROR_FORMATO_NO_VALIDO_MSJ);
		} catch (Exception arg43)
		{	arg43.printStackTrace();
			if (!errorConocido)
			{	log.info((new Gson()).toJson(consulta));
				log.error(arg43.getMessage(), arg43);
				respuesta.setCodigo(Constantes.COD_ERROR_EXCEPCION);
				respuesta.setMensaje(Constantes.COD_ERROR_SQL_MSJ);
			} else
			{	log.info((new Gson()).toJson(consulta));
				log.error(arg43.getMessage(), arg43);
				respuesta.setCodigo(Constantes.COD_ERROR_EXCEPCION);
				respuesta.setMensaje(Constantes.COD_ERROR_SQL_MSJ);
			}

			if (tx != null)
			{	log.info("Ejecutando rollback manual");
				tx.rollback();
			}

			throw arg43;
		} finally
		{
			if (sess != null)
			{ sess.close(); }
		}

		log.info(" ==== fin de registro de orden ");
		return respuesta;
	}
	
	private boolean registrarDeposito(int count, Long sucursal,Long pedido, Long baCveN, String soIdStr,Double importeTotal,
			String referencia, Date fechaServ, String formaPedido, String depTipo, String cveFormaPago)
	{
		boolean insertado = true;
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		PsPedtmkDep arg63 = new PsPedtmkDep();
		PsDeposito arg64 = new PsDeposito();
		
		try
		{
			tx = sess.beginTransaction();
			SQLQuery arg53 = sess.createSQLQuery("SELECT NVL(MAX(DEP_NUM_N),0)+1 AS DAP_NUM_N FROM PS_DEPOSITOS");
			String arg60 = arg53.uniqueResult().toString();
			Long deposito = Long.valueOf(Long.parseLong(arg60));
			
			arg64.getId().setTiCveN(sucursal);
			arg64.getId().setDepNumN(deposito);
			arg64.setBaCveN(baCveN);
			arg64.setSoIdStr(soIdStr);
			arg64.setDepImpN(importeTotal);
			arg64.setDepRefStr(referencia);
			arg64.setDepFechaDt(fechaServ);
			arg64.setUsrCvePstr("FSL33276");
			arg64.setDepFcaptDt(fechaServ);
			arg64.setDepEstStr(formaPedido);
			arg64.setDepTipoStr(depTipo);
			arg64.setDepComisN(Integer.valueOf(0));
			arg64.setDepPedN(Integer.valueOf(0));
			arg64.setDepcRegN(Integer.valueOf(0));
			arg64.setDepDestStr("K");
			arg64.setFpeCveStr(cveFormaPago);
			sess.save(arg64);

			log.info("Registrando deposito " + new Gson().toJson(arg64));
			
			try { 
				
				arg63.getId().setTiCveN(sucursal);
				arg63.getId().setPtNumN(pedido);
				arg63.getId().setDepNumN(deposito);
				arg63.setPtdepEstStr("A");
				sess.save(arg63);
				log.info("Registrando relacion deposito " + new Gson().toJson(arg63));
			}catch (Exception e) 
			{
				log.error("Falló registro de relacion pedido-deposito");
				log.error(e.getMessage(),e);
			}
			tx.commit();
		}catch (Exception e) 
		{
			tx.rollback();
			insertado=false;
			log.error("Falló el registro del depósito ");
			log.error(e.getMessage(), e );
		}finally 
		{
			sess.close();
		}
		return insertado;
	}
	
	public PedidoRespuesta guardarDoctos(Long value, Double Cantidad, String IdSocio, Session sess)
			throws SQLException {
		PedidoRespuesta respuesta = new PedidoRespuesta();
		boolean errorConocido = false;

		try {
			Procedure e = (Procedure) sess.getNamedQuery("P_WS_INSERTA_FORMAS_PAGO")
					.setLong("pedido", value.longValue()).setString("socio", IdSocio)
					.setDouble("monto", Cantidad.doubleValue()).uniqueResult();
			int pRegresa = e.getResultado().intValue();
			log.info(" P_WS_INSERTA_FORMAS_PAGO " + pRegresa + " - " + e.getErr());
			if (pRegresa == -1) {
				errorConocido = true;
				respuesta.setCodigo(Constantes.COD_ERROR_SQL);
				respuesta.setMensaje("Ocurrio un error en la transacion de vales y notas de credito.");
			} else if (pRegresa == 0) {
				errorConocido = true;
				respuesta.setCodigo(Constantes.COD_ERROR_SQL);
				respuesta.setMensaje("El socio no tiene saldo en vales ni notas de credito.");
			}
		} catch (Exception arg8) {
			if (!errorConocido) {
				log.info((new Gson()).toJson("Error"));
				respuesta.setCodigo(Constantes.COD_ERROR_EXCEPCION);
				respuesta.setMensaje(Constantes.COD_ERROR_SQL_MSJ);
				log.error(arg8.getMessage(), arg8);
			}
		}

		return respuesta;
	}

	public PedidoRespuesta guardarSaldo(Long value, Double Cantidad, String IdSocio, Session sess) throws SQLException {
		PedidoRespuesta respuesta = new PedidoRespuesta();
		boolean errorConocido = false;

		try {
			Procedure e = (Procedure) sess.getNamedQuery("P_WS_INSERTA_SALDO").setLong("pedido", value.longValue())
					.setString("socio", IdSocio).setDouble("monto", Cantidad.doubleValue()).uniqueResult();
			int pRegresa = e.getResultado().intValue();
			log.info(" P_WS_INSERTA_SALDO " + pRegresa + " - " + e.getErr());
			if (pRegresa == -1) {
				errorConocido = true;
				respuesta.setCodigo(Constantes.COD_ERROR_SQL);
				respuesta.setMensaje("Ocurrio un error en la transaciÃ³n de Saldos.");
			} else if (pRegresa == 0) {
				errorConocido = true;
				respuesta.setCodigo(Constantes.COD_ERROR_SQL);
				respuesta.setMensaje("El socio no tiene saldo para cubrir el pago.");
			}
		} catch (Exception arg8) {
			if (!errorConocido) {
				log.info((new Gson()).toJson("Error"));
				respuesta.setCodigo(Constantes.COD_ERROR_EXCEPCION);
				respuesta.setMensaje(Constantes.COD_ERROR_SQL_MSJ);
				log.error(arg8.getMessage(), arg8);
			}
		}

		return respuesta;
	}
	
	
	/**********************************************************************/
}