package com.priceshoes.rest.applications.service;

import com.priceshoes.rest.applications.bean.MemberBean;
import com.priceshoes.rest.applications.entity.Member;
import com.priceshoes.rest.applications.exceptions.MemberCreationException;
import com.priceshoes.rest.applications.repository.MemberRepository;
import com.priceshoes.rest.applications.repository.MemberRepositoryHibernate;
import com.priceshoes.rest.applications.respuesta.SocioRespuesta;
import com.priceshoes.rest.applications.service.AbstractService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends AbstractService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberRepositoryHibernate memberRepositoryHibernate;

	public Long count() {
		return Long.valueOf(this.memberRepository.count());
	}

	public Iterable<Member> findAll() {
		return this.memberRepository.findAll();
	}

	public Page<Member> findAll(int page, int size) {
		return this.memberRepository.findAll(new PageRequest(page, size));
	}

	public Iterable<Member> findAllInactiveMembers() {
		return this.memberRepository.findAllInactiveMembers();
	}

	public Page<Member> findAllInactiveMembers(int page, int size) {
		return this.memberRepository.findAllInactiveMembers(new PageRequest(page, size));
	}

	public Member findByMemberId(String id) {
		return this.memberRepository.findMemberById(id);
	}

	public Member findByMemberEmailAddress(String emailAddress) {
		return this.memberRepository.findMemberByEmailAddress(emailAddress);
	}

	public Member findByMemberIdAndDOB(String id, Date dob) {
		return this.memberRepository.findMemberByIdAndDOB(id, dob);
	}

	public SocioRespuesta saveMember(MemberBean memberBean) throws MemberCreationException {
		return this.memberRepositoryHibernate.saveMember(memberBean);
	}

	public byte[] getImage(String id) {
		return this.memberRepositoryHibernate.getImage(id);
	}

}