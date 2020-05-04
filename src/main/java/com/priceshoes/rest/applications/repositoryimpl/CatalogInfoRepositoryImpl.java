package com.priceshoes.rest.applications.repositoryimpl;

import com.priceshoes.rest.applications.entity.CatalogInfoRowMapper;
import com.priceshoes.rest.applications.entity.Member;
import com.priceshoes.rest.applications.exceptions.CatalogInfoNotFoundException;
import com.priceshoes.rest.applications.exceptions.MemberNotFoundException;
import com.priceshoes.rest.applications.repository.CatalogInfoRepository;
import com.priceshoes.rest.applications.respuesta.CatalogRespuesta;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CatalogInfoRepositoryImpl implements CatalogInfoRepository {
	private static Logger log = Logger.getLogger(CatalogInfoRepositoryImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public CatalogRespuesta getInfo(String memberId) throws MemberNotFoundException {
		CatalogRespuesta catalogRespuesta = null;
		List catalogInfo = null;
		log.info("MemberId:" + memberId);

		try {
			catalogRespuesta = new CatalogRespuesta();
			String ex = "select distinct decode(c.tar_cve_n, 4, c.id_art, d.id_art) Id_Art, decode(c.tar_cve_n,4,c.ar_desc_str, (select e.ar_desc_str from articulo e where d.id_art = e.id_art)) Desc_Catalogo from notasvta@lrcognos a inner join detvtas@lrcognos b on (a.ti_cve_n = b.ti_cve_n and a.cj_cve_n = b.cj_cve_n and a.nv_nota_n = b.nv_nota_n) inner join articulo c on (b.id_art = c.id_art and c.tar_cve_n in (4, 8)) left join detpaq d on (b.id_art = d.art_id_art and exists (select x.tar_cve_n from articulo x where d.id_art = x.id_art and x.tar_cve_n in (4, 8))) where 1 = 1 and a.nv_est_n = 1 and a.so_id_str = \'"
					+ memberId
					+ "\' union SELECT DISTINCT DECODE(c.tar_cve_n, 4, c.id_art, C.id_art) Id_Art, DECODE(c.tar_cve_n, 4,c.ar_desc_str, (SELECT e.ar_desc_str FROM articulo@LRCORPPRICE e WHERE d.id_art = e.id_art)) Desc_Catalogo FROM PS_PEDTMK A  INNER JOIN PS_PEDTMK_DET B ON (B.TI_CVE_N = A.TI_CVE_N AND B.PT_NUM_N=A.PT_NUM_N ) INNER JOIN ARTICULO@LRCORPPRICE C ON (C.ID_ART = B.ID_ART AND C.TAR_CVE_N IN(4,8) ) INNER JOIN PS_TIPART D ON (D.TAR_CVE_N = C.TAR_CVE_N) LEFT JOIN detpaq d ON (b.id_art = d.art_id_art AND EXISTS (SELECT x.tar_cve_n FROM articulo x WHERE d.id_art = x.id_art AND x.tar_cve_n IN (4, 8))) WHERE A.PT_EST_STR IN (\'A\',\'V\') AND A.SO_ID_STR = \'"
					+ memberId + "\'";
			catalogInfo = this.jdbcTemplate.query(ex, new CatalogInfoRowMapper());
			if (catalogInfo.size() <= 0) 
			{
				Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Member.class);
				crit.add(Restrictions.eq("soIdStr", memberId));
				Member psSocio = (Member) crit.uniqueResult();
				if (psSocio != null) {
					throw new CatalogInfoNotFoundException(
							"Catalog Information not available for Member Id:" + memberId);
				}

				throw new MemberNotFoundException("Member Not Found");
			}

			catalogRespuesta.setCatalogInfo(catalogInfo);
		} catch (JDBCException arg6) {
			log.error(arg6.toString());
			catalogRespuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			catalogRespuesta.setMensaje(arg6.toString());
		} catch (Exception arg7) {
			log.error(arg7.toString());
			catalogRespuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			catalogRespuesta.setMensaje(arg7.toString());
		}

		return catalogRespuesta;
	}
}