package com.priceshoes.rest.applications.repositoryimpl;

import com.priceshoes.rest.applications.entity.SkuDate;
import com.priceshoes.rest.applications.entity.SkuDateRowMapper;
import com.priceshoes.rest.applications.repository.ProductAvailabilityRepository;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductAvailabilityRepositoryImpl implements ProductAvailabilityRepository {
	private static Logger log = Logger.getLogger(ProductAvailabilityRepositoryImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<SkuDate> getAvailability() {
		List skuDates = null;

		try {
			/*String ex = "select * from ppvmx.v_pedidos_entrega@lrcorpprice";*/
			String ex = "select sku,fechallegada as FECHA_LLEGADA from ppvmx.v_fecha_llegadav2@lrcorpprice v2 where v2.ti_cve_n=5 ";
			skuDates = this.jdbcTemplate.query(ex, new SkuDateRowMapper());
		} catch (JDBCException arg2) {
			log.error(arg2.toString());
		} catch (Exception arg3) {
			log.error(arg3.toString());
		}

		return skuDates;
	}
}