package com.priceshoes.rest.applications.transfer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.priceshoes.rest.applications.entity.PsPedtmkInfMppagoDetInfo;

@Repository
@Transactional(value = "transactionManager", readOnly=true,rollbackFor=Exception.class)
public class TransferDaoImpl implements TransferDao
{
	@Autowired
	private SessionFactory session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PsPedtmkInfMppagoDetInfo> getSaldosPorTransferir() 
	{
		StringBuilder query = new StringBuilder();
		query.append(" SELECT DET.* , PED.SO_ID_STR ");
		query.append(" FROM  PPVMX.PS_PEDTMK_INF_MPPAGO_DET DET ");
		query.append(" INNER JOIN PS_PEDTMK PED ON (PED.TI_CVE_N = DET.TI_CVE_N AND PED.PT_NUM_N = DET.PT_NUM_N) ");
		query.append(" WHERE DET.SALD_TIPO_STR = 'S'  ");
		query.append(" AND  DET.SALD_EST_STR = 'P'    ");
		query.append(" AND  PED.PT_EST_STR NOT IN ('C','V') ");
		
		return session.getCurrentSession().createSQLQuery(query.toString()).addEntity(PsPedtmkInfMppagoDetInfo.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PsPedtmkInfMppagoDetInfo> getSaldosPorTransferir(Long sucursal, Long pedido) 
	{
		StringBuilder query = new StringBuilder();
		query.append(" SELECT DET.* , PED.SO_ID_STR ");
		query.append(" FROM  PPVMX.PS_PEDTMK_INF_MPPAGO_DET DET ");
		query.append(" INNER JOIN PS_PEDTMK PED ON (PED.TI_CVE_N = DET.TI_CVE_N AND PED.PT_NUM_N = DET.PT_NUM_N) ");
		query.append(" WHERE DET.SALD_TIPO_STR = 'S'  ");
		query.append(" AND  DET.SALD_EST_STR = 'P'    ");
		query.append(" AND DET.TI_CVE_N = "+sucursal );
		query.append(" AND DET.PT_NUM_N = "+pedido );
		
		return session.getCurrentSession().createSQLQuery(query.toString()).addEntity(PsPedtmkInfMppagoDetInfo.class).list();
	}
	
}
