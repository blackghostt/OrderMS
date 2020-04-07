package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.bean.MemberBean;
import com.priceshoes.rest.applications.entity.MemberBalance;
import com.priceshoes.rest.applications.exceptions.MemberCreationException;
import com.priceshoes.rest.applications.respuesta.SocioRespuesta;

public interface MemberRepositoryHibernate {
	SocioRespuesta saveMember(MemberBean arg0) throws MemberCreationException;

	byte[] getImage(String arg0);

	MemberBalance getBalance(String arg0);
}