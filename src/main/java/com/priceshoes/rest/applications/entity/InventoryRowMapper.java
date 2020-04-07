package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.InventoryBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class InventoryRowMapper implements RowMapper<InventoryBean> {
	public InventoryBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		InventoryBean invBean = new InventoryBean();
		invBean.setTi_cve_n(rs.getInt("ti_cve_n"));
		invBean.setId_art(rs.getString("id_art"));
		invBean.setTa_cve_n(rs.getFloat("ta_cve_n"));
		invBean.setInv_exist_n(rs.getInt("inve_exist_n"));
		return invBean;
	}
}