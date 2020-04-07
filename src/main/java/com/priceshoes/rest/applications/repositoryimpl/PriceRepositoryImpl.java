package com.priceshoes.rest.applications.repositoryimpl;

import com.priceshoes.rest.applications.entity.ProductPriceRowMapper;
import com.priceshoes.rest.applications.repository.PriceRepository;
import com.priceshoes.rest.applications.respuesta.PriceRespuesta;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
	private static Logger log = Logger.getLogger(PriceRepositoryImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public PriceRespuesta getPrices(int days) {
		PriceRespuesta respuesta = null;
		List productPrices = null;

		try {
			respuesta = new PriceRespuesta();
			String ex = "";
			StringBuilder query = new StringBuilder();
			query.append("  ");
					
			query.append(" SELECT SKU,AA.ID_ART,AA.TA_CVE_N,AA.PRE_TMK_N, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_CLIENTE = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_CLIENTE,'PRECIO_CLIENTE') ");
			query.append(" 		         END AS PRECIO_CLIENTE,        ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_SOCIO = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_SOCIO,'PRECIO_SOCIO') ");
			query.append(" END AS PRECIO_SOCIO,        ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_DISTRIBUIDOR = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_DISTRIBUIDOR,'PRECIO_DISTRIBUIDOR') ");
			query.append(" END AS PRECIO_DISTRIBUIDOR, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_CENTENARIO = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_CENTENARIO,'PRECIO_CENTENARIO') ");
			query.append(" END AS PRECIO_CENTENARIO, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_GOLDEN = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_GOLDEN,'PRECIO_GOLDEN') ");
			query.append(" END AS PRECIO_GOLDEN, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_OFERTA_CLIENTE = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_OFERTA_CLIENTE,'PRECIO_OFERTA_CLIENTE') ");
			query.append(" END AS PRECIO_OFERTA_CLIENTE, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_OFERTA_SOCIO = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_OFERTA_SOCIO,'PRECIO_OFERTA_SOCIO') ");
			query.append(" END AS PRECIO_OFERTA_SOCIO, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_OFERTA_DISTRIBUIDOR = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_OFERTA_DISTRIBUIDOR,'PRECIO_OFERTA_DISTRIBUIDOR') ");
			query.append(" END AS PRECIO_OFERTA_DISTRIBUIDOR, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_OFERTA_CENTENARIO = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_OFERTA_CENTENARIO,'PRECIO_OFERTA_CENTENARIO') ");
			query.append(" END AS PRECIO_OFERTA_CENTENARIO, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PRECIO_OFERTA_GOLDEN = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PRECIO_OFERTA_GOLDEN,'PRECIO_OFERTA_GOLDEN') ");
			query.append(" END AS PRECIO_OFERTA_GOLDEN, ");
			query.append(" AA.PREC_ES_OFERTA, ");
			query.append(" CASE ");
			query.append(" WHEN AA.PREC_REMATE = 0 THEN 0 ");
			query.append(" ELSE F_GET_REDONDEO(5,AA.TAR_CVE_N,AA.PREC_REMATE,'PREC_REMATE') ");
			query.append(" END AS PREC_REMATE ");
			query.append(" FROM (SELECT A.SKU,A.ID_ART,A.TA_CVE_N,A.PRE_TMK_N, ");               
			query.append(" CASE ");
			query.append(" WHEN (A.PRECIO_CLIENTE) - ROUND(A.PRECIO_CLIENTE) > 0 THEN ROUND(A.PRECIO_CLIENTE) + 1 ");
			query.append("              ELSE ROUND(A.PRECIO_CLIENTE) ");
			query.append(" END AS PRECIO_CLIENTE, ");
			query.append(" A.PRECIO_SOCIO, ");
			query.append(" A.PRECIO_DISTRIBUIDOR, ");
			query.append(" A.PRECIO_CENTENARIO, ");
			query.append(" A.PRECIO_GOLDEN, ");
			query.append(" A.PRECIO_OFERTA_CLIENTE, ");
			query.append(" A.PRECIO_OFERTA_SOCIO, ");
			query.append(" A.PRECIO_OFERTA_DISTRIBUIDOR, ");
			query.append(" A.PRECIO_OFERTA_CENTENARIO, ");
			query.append(" A.PRECIO_OFERTA_GOLDEN, ");
			query.append(" A.PREC_ES_OFERTA, ");
			query.append(" A.PREC_REMATE, ");
			query.append(" A.TAR_CVE_N "); 		        
			query.append(" FROM (SELECT RIGHT('0000000000' || TO_CHAR(AR.ID_ART), 10) || RIGHT('00' || TO_CHAR(AL.TA_CVE_N * 2), 2) AS SKU,AR.ID_ART,PR.PRE_TMK_N,");
			query.append(" (SELECT (CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 1 THEN PR.PRE_MENANT_N * 1.30 ");
			query.append(" ELSE PR.PRE_SUG_N END) * (1 + CTMK.CTMK_PORC_N) ");
			query.append(" FROM PS_COSTO_TMK@LRCORPPRICE CTMK ");
			query.append(" WHERE CTMK.TI_CVE_N = 5 ");
			query.append(" 		                   AND (CASE WHEN PR.PRE_ESOFER_N = 1 THEN PR.PRE_MENANT_N * 1.30 ");
			query.append(" ELSE PR.PRE_SUG_N END) BETWEEN CTMK.CTMK_RINI_N AND CTMK.CTMK_RFIN_N) AS PRECIO_CLIENTE, "); 
			query.append(" CASE WHEN PR.PRE_ESOFER_N = 0 AND NVL(PPD.PROMOCION, 0) = 0 THEN PR.PRE_TMK_N ");
			query.append(" ELSE (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MENANT_N ELSE PR.PRE_TMK_N END) END AS PRECIO_SOCIO, ");		                       
			query.append(" CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 0 AND NVL(PPD.PROMOCION, 0) = 0 ");
			query.append(" THEN (PR.PRE_MAY_N -(ROUND(PR.PRE_MAY_N * 1.06, 0) - PR.PRE_MAY_N)) * 1.23 ");
			query.append(" ELSE PR.PRE_MAY_N -(ROUND(PR.PRE_MAY_N * 1.06, 0) - PR.PRE_MAY_N) END AS PRECIO_DISTRIBUIDOR, ");
			query.append(" PR.PRE_MAY_N AS PRECIO_CENTENARIO, ");		                      
			query.append(" CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 0 AND NVL(PPD.PROMOCION, 0) = 0 ");
			query.append(" THEN PR.PRE_MAY_N * 1.20 ELSE PR.PRE_MAY_N * 1.10 END AS PRECIO_GOLDEN, ");		                       
			query.append(" CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 1 AND NVL(PPD.PROMOCION, 0) = 0 THEN PR.PRE_OFER_N * 1.30 ");
			query.append(" ELSE (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_OFER_N * 1.30 ELSE 0 END) END AS PRECIO_OFERTA_CLIENTE, ");		                      
			query.append(" CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 0 AND NVL(PPD.PROMOCION, 0) = 0 THEN ");
			query.append(" (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MAY_N ELSE 0 END) ");
			query.append(" WHEN PR.PRE_ESOFER_N = 1 AND NVL(PPD.PROMOCION, 0) = 0 "); 
			query.append(" THEN PR.PRE_MAY_N ELSE NVL(PPD.PMD_PRECIO_N, 0) END AS PRECIO_OFERTA_SOCIO, ");		                      
			query.append(" CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 1 AND NVL(PPD.PROMOCION, 0) = 0 THEN PR.PRE_MAY_N ");
			query.append(" ELSE (CASE PR.PRE_ESOFER_N WHEN 1 THEN (PR.PRE_OFER_N-(ROUND(PR.PRE_OFER_N * 1.06, 0) - PR.PRE_OFER_N)) ");
			query.append(" ELSE 0 END) END AS PRECIO_OFERTA_DISTRIBUIDOR, ");		                       
			query.append(" CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 1 AND NVL(PPD.PROMOCION, 0) = 0 THEN PR.PRE_MAY_N ");
			query.append(" ELSE (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_OFER_N ELSE 0 END) END AS PRECIO_OFERTA_CENTENARIO, ");		                       
			query.append(" CASE ");
			query.append(" WHEN PR.PRE_ESOFER_N = 1 AND NVL(PPD.PROMOCION, 0) = 0 THEN PR.PRE_MAY_N ");
			query.append(" ELSE (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_OFER_N * 1.10 ELSE 0 END) END AS PRECIO_OFERTA_GOLDEN, ");		                       
			query.append(" PR.PRE_ESOFER_N AS PREC_ES_OFERTA, ");
			query.append(" NVL(PPD.PMD_PRECIO_N,0) AS PREC_REMATE, ");
			query.append(" AR.TAR_CVE_N, ");
			query.append(" AL.TA_CVE_N, ");
			query.append(" PR.TA_CVE_N_INI ");
			query.append(" FROM ARTICULO AR, ");
			query.append(" 		                   ARTICULO_TALLA AL, ");
			query.append(" PS_ARTICULO_CORR AO, ");
			query.append(" PRECIOS@LRCORPPRICE PR, ");
			query.append(" 		                   (SELECT PS_PROMART_DET.ID_ART, ");
			query.append(" PS_PROMART_DET.CO_CVE_STR, ");
			query.append(" PS_PROMART_DET.PMD_PRECIO_N, ");
			query.append(" 1 AS PROMOCION ");
			query.append(" FROM PS_PROMART_DET ");
			query.append(" WHERE PS_PROMART_DET.PM_TPO_STR = 'M' ");
			query.append(" AND PS_PROMART_DET.PMD_EST_STR = 'A' ");
			query.append(" AND PS_PROMART_DET.TI_CVE_N=5) PPD, ");
			query.append(" (SELECT DISTINCT BPR.ID_ART,BPR.TA_CVE_N_INI "); 
			query.append(" FROM BIT_PRECIO@LRCORPPRICE BPR "); 
			query.append(" WHERE TRUNC(BPR.FECHA_DT)=TRUNC(SYSDATE-"+days+") ");
			query.append(" AND BPR.TIPO_STR='U' ");
			query.append(" AND ((OLD_PRE_COSTO_N <> NEW_PRE_COSTO_N) "); 
			query.append(" OR (OLD_PRE_CNETO_N <> NEW_PRE_CNETO_N) ");
			query.append(" OR (OLD_PRE_MAY_N <> NEW_PRE_MAY_N)  ");
			query.append(" OR (OLD_PRE_MEN_N <> NEW_PRE_MEN_N) "); 
			query.append(" OR (OLD_PRE_TMK_N <> NEW_PRE_TMK_N) "); 
			query.append(" OR (OLD_PRE_SUG_N <> NEW_PRE_SUG_N) "); 
			query.append(" OR (OLD_PRE_OFER_N <> NEW_PRE_OFER_N)) "); 
			query.append(" )BP "); 
			query.append(" WHERE AR.ID_ART = AL.ID_ART ");
			query.append(" AND AR.ID_ART = AO.ID_ART ");
			query.append(" AND AO.ID_ART = PR.ID_ART ");
			query.append(" AND AO.CO_CVE_STR = PR.CO_CVE_STR ");
			query.append(" AND PR.ID_ART = PPD.ID_ART(+) ");
			query.append(" AND PR.ID_ART = BP.ID_ART ");
			query.append(" AND PR.CO_CVE_STR = PPD.CO_CVE_STR(+) ");
			query.append(" AND (AL.TA_CVE_N BETWEEN PR.TA_CVE_N_INI AND ");
			query.append(" 		                   PR.TA_CVE_N_FIN) ");
			query.append(" AND AL.TA_CVE_EST_N = 1 ");
			query.append(" AND ((AR.DIV_CVE_N in (1, 2, 3, 4, 5, 6, 7)) ");
			query.append(" 		                   OR (AR.DIV_CVE_N = 8 AND AO.SEC_CVE_N = 25))               ");
			query.append(" ORDER BY 1 ASC) A ");               
			query.append(" ) AA ");

			/*-- consulta anterior -----------------------------------------------------------------------------------------							
					+ "SELECT SKU,AA.ID_ART,AA.TA_CVE_N,AA.PRE_TMK_N,"
					+ " CASE WHEN AA.PRECIO_CLIENTE = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_CLIENTE) END AS PRECIO_CLIENTE,"
					+ " CASE WHEN AA.PRECIO_SOCIO = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_SOCIO) END AS PRECIO_SOCIO,"
					+ " CASE WHEN AA.PRECIO_DISTRIBUIDOR = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_DISTRIBUIDOR) END AS PRECIO_DISTRIBUIDOR,"
					+ " CASE WHEN AA.PRECIO_CENTENARIO = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_CENTENARIO) END AS PRECIO_CENTENARIO,"
					+ " CASE WHEN AA.PRECIO_GOLDEN = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_GOLDEN) END AS PRECIO_GOLDEN,"
					+ " CASE WHEN AA.PRECIO_OFERTA_CLIENTE = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_OFERTA_CLIENTE) END AS PRECIO_OFERTA_CLIENTE,"
					+ " CASE WHEN AA.PRECIO_OFERTA_SOCIO = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_OFERTA_SOCIO) END AS PRECIO_OFERTA_SOCIO,"
					+ " CASE WHEN AA.PRECIO_OFERTA_DISTRIBUIDOR = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_OFERTA_DISTRIBUIDOR) END AS PRECIO_OFERTA_DISTRIBUIDOR," 
					+ " CASE WHEN AA.PRECIO_OFERTA_CENTENARIO = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_OFERTA_CENTENARIO) END AS PRECIO_OFERTA_CENTENARIO, "
					+ " CASE WHEN AA.PRECIO_OFERTA_GOLDEN = 0 THEN 0 ELSE F_GET_REDONDEO(5, AA.TAR_CVE_N, AA.PRECIO_OFERTA_GOLDEN) END AS PRECIO_OFERTA_GOLDEN, "
					+ " AA.PREC_ES_OFERTA FROM ("
					+ " SELECT RIGHT(\'0000000000\'||TO_CHAR(AR.ID_ART),10)||RIGHT(\'00\'||TO_CHAR(AL.TA_CVE_N * 2),2) AS SKU," 
					+ " AR.ID_ART,AL.TA_CVE_N,PR.PRE_TMK_N,"
					+ " (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MENANT_N * 1.30 ELSE PR.PRE_SUG_N END) AS PRECIO_CLIENTE,"
					+ " (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MENANT_N ELSE PR.PRE_TMK_N END) AS PRECIO_SOCIO, "
					+ " PR.PRE_MAY_N - ((PR.PRE_MAY_N * 1.06) - PR.PRE_MAY_N) AS PRECIO_DISTRIBUIDOR,"
					+ " PR.PRE_MAY_N AS PRECIO_CENTENARIO,"
					+ " PR.PRE_MAY_N * 1.10 AS PRECIO_GOLDEN," 
					+ " (CASE PR.PRE_ESOFER_N WHEN 1 THEN (PR.PRE_MAY_N * 1.30) ELSE 0 END) AS PRECIO_OFERTA_CLIENTE,"
					+ " (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MAY_N ELSE 0 END) AS PRECIO_OFERTA_SOCIO,"
					+ " (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MAY_N ELSE 0 END) AS PRECIO_OFERTA_DISTRIBUIDOR,"
					+ " (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MAY_N ELSE 0 END) AS PRECIO_OFERTA_CENTENARIO,"
					+ " (CASE PR.PRE_ESOFER_N WHEN 1 THEN PR.PRE_MAY_N ELSE 0 END) AS PRECIO_OFERTA_GOLDEN,  "
					+ " PR.PRE_ESOFER_N AS PREC_ES_OFERTA,AR.TAR_CVE_N "
					+ " FROM ARTICULO@LRCORPPRICE AR "
					+ " INNER JOIN ARTICULO_TALLA@LRCORPPRICE AL ON (AR.ID_ART = AL.ID_ART AND AL.TA_CVE_EST_N = 1)" 
					+ " INNER JOIN PRECIOS@LRCORPPRICE PR  ON (AR.ID_ART=PR.ID_ART AND (AL.TA_CVE_N BETWEEN PR.TA_CVE_N_INI AND PR.TA_CVE_N_FIN))"
					+ " INNER JOIN (SELECT DISTINCT BPR.ID_ART,BPR.TA_CVE_N_INI "
					+ " FROM BIT_PRECIO@LRCORPPRICE BPR "
					+ " WHERE TRUNC(BPR.FECHA_DT)=TRUNC(SYSDATE-"
					+ days
					+ " ) AND BPR.TIPO_STR=\'U\'"
					+ " AND ((OLD_PRE_COSTO_N <> NEW_PRE_COSTO_N)" 
					+ " OR (OLD_PRE_CNETO_N <> NEW_PRE_CNETO_N)"
					+ " OR (OLD_PRE_MAY_N <> NEW_PRE_MAY_N)" 
					+ " OR (OLD_PRE_MEN_N <> NEW_PRE_MEN_N)" 
					+ " OR (OLD_PRE_TMK_N <> NEW_PRE_TMK_N)" 
					+ " OR (OLD_PRE_SUG_N <> NEW_PRE_SUG_N)" 
					+ " OR (OLD_PRE_OFER_N <> NEW_PRE_OFER_N)) " 
					+ " ) BP "
					+ " ON (PR.ID_ART=BP.ID_ART AND PR.TA_CVE_N_INI=BP.TA_CVE_N_INI) "
					+ " ) AA ";
			--- fin consulta anterior ----------------------------------------------------------------------------*/
			
			productPrices = this.jdbcTemplate.query(query.toString(), new ProductPriceRowMapper());
			respuesta.setProductPrices(productPrices);
		} catch (JDBCException arg4) {
			log.error(arg4.toString());
			respuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuesta.setMensaje(arg4.toString());
		} catch (Exception arg5) {
			log.error(arg5.toString());
			respuesta.setCodigo(HttpStatus.INTERNAL_SERVER_ERROR.value());
			respuesta.setMensaje(arg5.toString());
		}

		return respuesta;
	}
}