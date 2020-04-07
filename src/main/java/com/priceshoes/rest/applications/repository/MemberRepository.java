package com.priceshoes.rest.applications.repository;

import com.priceshoes.rest.applications.entity.Member;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends PagingAndSortingRepository<Member, Long>, JpaSpecificationExecutor<Member> {
	@Query("SELECT m FROM Member m WHERE m.soIdStr = :id")
	Member findMemberById(@Param("id") String arg0);

	@Query("SELECT m FROM Member m WHERE m.soEmailStr = :emailAddress")
	Member findMemberByEmailAddress(@Param("emailAddress") String arg0);

	@Query("SELECT m FROM Member m WHERE m.soIdStr = :id AND m.soFnacDt = :dob")
	Member findMemberByIdAndDOB(@Param("id") String arg0, @Param("dob") Date arg1);

	@Query("SELECT m FROM Member m")
	Iterable<Member> findAll();

	@Query("SELECT m FROM Member m WHERE m.soEstStr = \'I\'")
	Iterable<Member> findAllInactiveMembers();

	@Query("SELECT m FROM Member m")
	Page<Member> findAll(Pageable arg0);

	@Query("SELECT m FROM Member m WHERE m.soEstStr = \'I\'")
	Page<Member> findAllInactiveMembers(Pageable arg0);
}