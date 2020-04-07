package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.SkuDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SkuDateRowMapper implements RowMapper<SkuDate> {
	public SkuDate mapRow(ResultSet rs, int rowNum) throws SQLException {
		SkuDate skuDate = new SkuDate();
		skuDate.setSkuId(rs.getString("sku"));
		skuDate.setDate(rs.getDate("fecha_llegada"));
		return skuDate;
	}
}