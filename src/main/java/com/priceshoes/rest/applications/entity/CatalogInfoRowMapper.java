package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.CatalogInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CatalogInfoRowMapper implements RowMapper<CatalogInfo> {
	public CatalogInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatalogInfo catalogInfo = new CatalogInfo();
		catalogInfo.setId_Art(rs.getInt("ID_ART"));
		catalogInfo.setDesc_Catalogo(rs.getString("DESC_CATALOGO"));
		return catalogInfo;
	}
}