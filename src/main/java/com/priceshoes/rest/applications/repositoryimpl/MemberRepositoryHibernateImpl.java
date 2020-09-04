/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.priceshoes.rest.applications.repositoryimpl;

import com.google.gson.Gson;
import com.priceshoes.rest.applications.bean.Direccion;
import com.priceshoes.rest.applications.bean.MemberBean;
import com.priceshoes.rest.applications.bean.Socio;
import com.priceshoes.rest.applications.entity.Member;
import com.priceshoes.rest.applications.entity.MemberAddress;
import com.priceshoes.rest.applications.entity.MemberBalance;
import com.priceshoes.rest.applications.entity.MemberBalanceRowMapper;
import com.priceshoes.rest.applications.entity.MemberImage;
import com.priceshoes.rest.applications.entity.SaldosSocio;
import com.priceshoes.rest.applications.exceptions.AddressNotFoundException;
import com.priceshoes.rest.applications.exceptions.BeanNotFoundException;
import com.priceshoes.rest.applications.exceptions.MemberCreationException;
import com.priceshoes.rest.applications.repository.MemberRepositoryHibernate;
import com.priceshoes.rest.applications.respuesta.SocioRespuesta;
import com.priceshoes.rest.applications.utils.Constantes;
import com.priceshoes.rest.applications.utils.Funciones;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.TransactionRequiredException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberRepositoryHibernateImpl implements MemberRepositoryHibernate {
	private static Logger log = Logger.getLogger(MemberRepositoryHibernateImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired private Environment env;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public synchronized SocioRespuesta saveMember(MemberBean memberBean) throws MemberCreationException {
		String id = null;
		SocioRespuesta respuesta = new SocioRespuesta();
		Socio socio = memberBean.getSocio();
		Integer secuencia = Integer.valueOf(1);
		Integer idPais = socio.getPaisId();
		Integer estado = socio.getEstadoId();
		Integer municipio = null;
		Boolean errorConocido = Boolean.valueOf(false);
		Timestamp dateOfBirth = null;
		Member member = memberBean.getPsSocio();
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			log.info("*********** INPUT JSON ************");
			log.info((new Gson()).toJson(memberBean));
			
			tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("SELECT SYSDATE FROM DUAL");
			Iterator iterDate = query.list().iterator();
			Date fechaServ = (Date) iterDate.next();
			String key = null;

			for (int contadorSeguridad = 3; key == null && contadorSeguridad > 0; --contadorSeguridad) {
				Funciones membImage = new Funciones(Long.valueOf(env.getProperty("price.sucursal")));
				session.doWork(membImage);
				key = membImage.getIdSocio();
				log.info(key);
			}

			if (key == null) {
				throw new MemberCreationException();
			}

			if (member == null) {
				throw new BeanNotFoundException("psSocio Bean not found in the request");
			}
			String nombreSocio = socio.getNombre();
			if( nombreSocio !=null && nombreSocio.length() > 29 ) 
			{
				nombreSocio = nombreSocio.substring(0,29);
			}	
			member.setSoNomStr(nombreSocio);
			member.setSoApatStr(socio.getApellidoPaterno());
			member.setSoAmatStr(socio.getApellidoMaterno());
			if (member.getSoFnacDt() != null) {
				SimpleDateFormat arg27 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				arg27.setTimeZone(TimeZone.getTimeZone("GMT"));
				dateOfBirth = member.getSoFnacDt();
				arg27.format(dateOfBirth);
				member.setSoFnacDt(Timestamp.valueOf(arg27.format(dateOfBirth)));
			}

			log.info(member.getSoFnacDt());
			member.setSoFaltaDt(fechaServ);
			member.setSoIdStr(key);
			id = (String) session.save(member);
			if (id == null || id.equals("")) {
				respuesta.setStatus("Member Not Created");
				throw new MemberCreationException("Id is NULL");
			}

			respuesta.setSocioId(id);
			respuesta.setStatus("Member Created");
			if (memberBean.getImage() != null && member.getTiCveN() != null) {
				MemberImage arg28 = new MemberImage();
				arg28.setSoIdStr(id);
				arg28.setStoreId(member.getTiCveN());
				arg28.setPhoto(memberBean.getImage());
				session.saveOrUpdate(arg28);
			}

			if (socio.getDirecciones() != null && socio.getDirecciones().getDireccion() != null
					&& socio.getDirecciones().getDireccion().size() > 0) {
				Iterator arg29 = socio.getDirecciones().getDireccion().iterator();

				while (true) {
					if (!arg29.hasNext()) {
						respuesta.setDireccion(socio.getDirecciones().getDireccion());
						tx.commit();
						break;
					}

					Direccion dir = (Direccion) arg29.next();
					MemberAddress direccion = new MemberAddress();
					direccion.getId().setSoIdStr(member.getSoIdStr());
					dir.setIdDireccionPs(secuencia);
					secuencia = Integer.valueOf(secuencia.intValue() + 1);
					Long seqTemp = Long.valueOf(secuencia.longValue());
					direccion.getId().setSodConsN(seqTemp);
					idPais = dir.getPaisId() != null && dir.getPaisId().intValue() > 0 ? dir.getPaisId()
							: socio.getPaisId();
					estado = dir.getEstadoId() != null && dir.getEstadoId().intValue() > 0 ? dir.getEstadoId()
							: socio.getEstadoId();
					municipio = dir.getMunicipioId();
					direccion.setEdCveN(estado);
					direccion.setMuCveN(municipio);
					direccion.setPaCveN(idPais);
					direccion.setSodCalleStr(dir.getCalle() != null && !dir.getCalle().trim().equals("")
							? dir.getCalle().toUpperCase() : null);
					dir.setCalle(direccion.getSodCalleStr());
					direccion.setSodCdStr(dir.getCiudad() != null && !dir.getCiudad().trim().equals("")
							? dir.getCiudad().toUpperCase() : null);
					dir.setCiudad(direccion.getSodCdStr());
					direccion.setSodColStr(dir.getColonia());
					dir.setColonia(direccion.getSodColStr());
					direccion.setSodNumStr(dir.getNumero());
					dir.setNumero(direccion.getSodNumStr());
					direccion.setSodObsStr(dir.getObservaciones() != null ? dir.getObservaciones().toUpperCase()
							: dir.getObservaciones());
					if (direccion.getSodCalleStr() == null || direccion.getSodNumStr() == null
							|| direccion.getSodColStr() == null || direccion.getSodCdStr() == null) {
						respuesta.setCodigo(Constantes.COD_ERROR_ENTRADA_INSUFICIENTE);
						respuesta.setMensaje(
								"La calle, numero, colonia y ciudad son datos requeridos para registrar la direccion.");
						errorConocido = Boolean.valueOf(true);
						throw new AddressNotFoundException(
								"La calle, numero, colonia y ciudad son datos requeridos para registrar la direccion.");
					}

					direccion.setSodCpStr(dir.getCodigoPostal());
					direccion.setSodEstStr("A");
					direccion.setSodTel1Str(dir.getTelefono1());
					direccion.setSodTel2Str(dir.getTelefono2());
					dir.setPaisId(idPais);
					dir.setEstadoId(estado);
					dir.setMunicipioId(municipio);
					session.save(direccion);
				}
			}
		} catch (MemberCreationException arg23) {
			if(tx!=null ) { tx.rollback(); }
			respuesta.setCodigo(Constantes.COD_ERROR_SQL);
			respuesta.setMensaje(arg23.toString());
			log.error(arg23);
		} catch (TransactionRequiredException arg24) {
			if(tx!=null ) { tx.rollback(); }
			respuesta.setCodigo(Constantes.COD_ERROR_EXCEPCION);
			respuesta.setMensaje(arg24.toString());
			log.error(arg24);
		} catch (HibernateException arg25) {
			if(tx!=null ) { tx.rollback(); }
			respuesta.setCodigo(Constantes.COD_ERROR_EXCEPCION);
			respuesta.setMensaje(arg25.toString());
			log.error(arg25);
		} catch (Exception arg26) {
			if(tx!=null ) { tx.rollback(); }
			respuesta.setCodigo(Constantes.COD_ERROR_EXCEPCION);
			respuesta.setMensaje(arg26.toString());
			log.error(arg26);
		}finally 
		{
			if (session!=null)
			{
				session.close();
			}
		}

		return respuesta;
	}

	@Transactional
	public MemberBalance getBalance(String id) 
	{
		MemberBalance memberBalance = null;
		if ( Boolean.valueOf(env.getProperty("usar.saldo.corpo")))
		{
			log.info("Consulta consolidada "+id);
			String liga ="@lrcorpprice";
			if( env.getProperty("sys.env").equalsIgnoreCase("TEST"))
			{
				liga="";
				log.info("Consulta consolidada TEST");
			}	
			Transaction tx = null;
			Session sess = sessionFactory.openSession();
			try
			{
				tx = sess.beginTransaction();
				StringBuilder q = new StringBuilder();
				BigDecimal utilizado 		= new BigDecimal(0);
				BigDecimal saldo	 		= new BigDecimal(0);
				BigDecimal saldoDisponible	= new BigDecimal(0);
				BigDecimal notas	 		= new BigDecimal(0);
				BigDecimal vales	 		= new BigDecimal(0);
				BigDecimal cupon	 		= new BigDecimal(0);
				
				if ( Boolean.valueOf(env.getProperty("obtener.saldo.utilizado")))
				{	log.debug("inicio");
					q = new StringBuilder();
					q.append(" select ppvmx.F_ECOMM_SALDO_UTILIZADO"+liga+"('"+id+"') from dual ");
					utilizado = (BigDecimal) sess.createSQLQuery(q.toString()).uniqueResult();
					log.debug("Utilizado " + utilizado);
				}	
				if ( Boolean.valueOf(env.getProperty("obtener.cupon")))
				{	log.debug("inicio");
					q = new StringBuilder();
					q.append(" select ppvmx.F_ECOMM_CUPON"+liga+"('"+id+"') from dual ");
					cupon = (BigDecimal) sess.createSQLQuery(q.toString()).uniqueResult();
					log.debug("Cupón " + cupon);
				}
				if ( Boolean.valueOf(env.getProperty("obtener.vales")))
				{	log.debug("inicio");
					q = new StringBuilder();
					q.append(" select ppvmx.F_ECOMM_VALES"+liga+"('"+id+"') from dual ");
					vales = (BigDecimal) sess.createSQLQuery(q.toString()).uniqueResult();
					log.debug("Vales " + vales);
				}
				if ( Boolean.valueOf(env.getProperty("obtener.notas")))
				{	log.debug("inicio");
					q = new StringBuilder();
					q.append(" select ppvmx.F_ECOMM_NOTAS_CARGO"+liga+"('"+id+"') from dual ");
					notas = (BigDecimal) sess.createSQLQuery(q.toString()).uniqueResult();
					log.debug("Notas " + notas);
				}
				log.debug("inicio");
				q = new StringBuilder();
				q.append(" select ppvmx.F_ECOMM_SALDO"+liga+"('"+id+"') from dual ");
				saldo = (BigDecimal) sess.createSQLQuery(q.toString()).uniqueResult();
				log.debug("saldo " + saldo);
				saldoDisponible = saldo.subtract(utilizado);
				log.debug("Disponible " + saldoDisponible);
				
				memberBalance = new MemberBalance();
				memberBalance.setCupon( 	cupon);
				memberBalance.setDepositos( new BigDecimal(0));
				memberBalance.setNC(		notas);
				memberBalance.setSaldo(		saldoDisponible);
				memberBalance.setVales(		vales);
				
				tx.commit();
				
			}
			catch (Exception e) { tx.rollback();  log.error(e.getMessage()); }
			finally {  sess.close(); }
		}	
		else
		{
			log.info("Consulta simple server remoto");
			try {
				String ex = "SELECT PCK_MAGENTO.F_GET_SALDO_NC   (\'"+id+"\') as NC, "
						+ " PCK_MAGENTO.F_GET_SALDO_VALES 		 (\'"+id+"\') as VALES, "
						+ " PCK_MAGENTO.F_GET_SALDO_DEPOSITOS	 (\'"+id+"\') as DEPOSITOS, "
						+ " PCK_MAGENTO.F_GET_SALDO_SOCIO		 (\'"+id+"\') as SOCIO, "
						+ " (SELECT NVL(SUM(A.VA_MONTO_N),0) "
						+ " FROM PS_VALES A WHERE A.SO_ID_STR = '"+id+"'  "
						+ " AND A.VA_EXC_STR = 'F' AND A.VA_EST_STR='A') AS CUPON  "
						+ "  FROM DUAL ";
				List memberBalances = this.jdbcTemplate.query(ex, new MemberBalanceRowMapper());
				if (memberBalances != null && memberBalances.size() > 0) {
					memberBalance = (MemberBalance) memberBalances.get(0);
				}
				log.info(" Balance "+id+" "+new Gson().toJson(memberBalance));
			} catch (JDBCException arg4) {
				log.error(arg4.toString());
			} catch (Exception arg5) {
				log.error(arg5.toString());
			}
		}	
		
		log.info(" Balance "+id+" "+new Gson().toJson(memberBalance));
		return memberBalance;
	}

	@Transactional
	public byte[] getImage(String id) {
		byte[] image = null;
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MemberImage.class);
		criteria.add(Restrictions.eq("soIdStr", id));
		MemberImage memberImage = (MemberImage) criteria.uniqueResult();
		if (memberImage != null) {
			image = memberImage.getPhoto();
		}

		return image;
	}

	@Override
	public SocioRespuesta updateMember(MemberBean memberBean) 
	{
		log.info("updateMember " + new Gson().toJson(memberBean));
		int camposModificados = 0;
		SocioRespuesta response = new SocioRespuesta();
		Transaction tx = null;
		Session sess = sessionFactory.openSession();
		
		if (memberBean==null || 
			memberBean.getPsSocio() ==null || 
			memberBean.getPsSocio().getSoIdStr() ==null
			)
		{
			response.setCodigo(-1);
			response.setMensaje("Falta información para procesar la petición");
			return response;
		}
		
		String soIdStr 	= memberBean.getPsSocio().getSoIdStr();
		String email 	= memberBean.getPsSocio().getSoEmailStr();
		String telefono = memberBean.getPsSocio().getSoTel4Str(); 
		try
		{
			tx = sess.beginTransaction();
			Criteria crit = sess.createCriteria(Member.class);
			crit.add(Restrictions.eq("soIdStr", soIdStr));
			Member psSocio = (Member) crit.uniqueResult();
			
			log.debug("Socio " + new Gson().toJson(psSocio));
			
			if( psSocio != null )
			{
				if(email!=null && email.trim().length() > 0 )
				{ 
					psSocio.setSoEmailStr( email.trim().toLowerCase() );
					camposModificados++;	
				}
				
				if(telefono!=null && telefono.trim().length() > 0 )
				{ 
					psSocio.setSoTel4Str( telefono.trim() );	
					camposModificados++;
				}
				log.info("Datos actualizados");
				response.setMensaje("Datos actualizados");
			}
			tx.commit();
		}
		catch (Exception e) { tx.rollback();  log.error(e.getMessage()); }
		finally {  sess.close(); }
		
		response.setCamposModificados(camposModificados);
		return response;
	}
}
