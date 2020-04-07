package com.priceshoes.rest.applications.repositoryimpl;

import com.priceshoes.rest.applications.entity.InventoryBean;
import com.priceshoes.rest.applications.entity.InventoryRowMapper;
import com.priceshoes.rest.applications.repository.InventoryOnlineRepositoryBatchProcess;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryOnlineRepositoryImpl implements InventoryOnlineRepositoryBatchProcess {
	private static Logger log = Logger.getLogger(InventoryOnlineRepositoryImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<InventoryBean> getInventory(int start, int end) {
		List invBeans = null;

		try {
			String ex = "SELECT ti_cve_n, id_art, ta_cve_n, inve_exist_n from(select ti_cve_n, id_art, ta_cve_n, inve_exist_n, rownum r from ps_inventario_ecomm m where ti_cve_n in (1,5) order by ti_cve_n, id_art, ta_cve_n) where r >= \'"
					+ start + "\' and r <= \'" + end + "\'";
			invBeans = this.jdbcTemplate.query(ex, new InventoryRowMapper());
		} catch (JDBCException arg4) {
			log.error(arg4.toString());
		} catch (Exception arg5) {
			log.error(arg5.toString());
		}

		return invBeans;
	}
}