package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.ProductPrice;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductPriceRowMapper implements RowMapper<ProductPrice> {
	public ProductPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductPrice pp = new ProductPrice();
		pp.setSku(rs.getString("SKU"));
		pp.setIdArt(rs.getString("ID_ART"));
		pp.setTaCveN(Double.valueOf(rs.getDouble("TA_CVE_N")));
		
		pp.setPreTmkN(Double.valueOf(rs.getDouble("PRE_TMK_N")));
		pp.setPrecioCliente(Double.valueOf(rs.getDouble("PRECIO_CLIENTE")));
		pp.setPrecioSocio(Double.valueOf(rs.getDouble("PRECIO_SOCIO")));
		pp.setPrecioDistributor(Double.valueOf(rs.getDouble("PRECIO_DISTRIBUIDOR")));
		pp.setPrecioCentenario(Double.valueOf(rs.getDouble("PRECIO_CENTENARIO")));
		pp.setPrecioGolden(Double.valueOf(rs.getDouble("PRECIO_GOLDEN")));
		pp.setPrecioOfertaCliente(Double.valueOf(rs.getDouble("PRECIO_OFERTA_CLIENTE")));
		pp.setPrecioOfertaSocio(Double.valueOf(rs.getDouble("PRECIO_OFERTA_SOCIO")));
		pp.setPrecioOfertaDistributor(Double.valueOf(rs.getDouble("PRECIO_OFERTA_DISTRIBUIDOR")));
		pp.setPrecioOfertaCentenario(Double.valueOf(rs.getDouble("PRECIO_OFERTA_CENTENARIO")));
		pp.setPrecioOfertaGolden(Double.valueOf(rs.getDouble("PRECIO_OFERTA_GOLDEN")));
		
		/*pp.setPreTmkN(Long.valueOf(rs.getDouble("PRE_TMK_N")));
		pp.setPrecioCliente(Long.valueOf(rs.getDouble("PRECIO_CLIENTE")));
		pp.setPrecioSocio(Long.valueOf(rs.getDouble("PRECIO_SOCIO")));
		pp.setPrecioDistributor(Long.valueOf(rs.getDouble("PRECIO_DISTRIBUIDOR")));
		pp.setPrecioCentenario(Long.valueOf(rs.getDouble("PRECIO_CENTENARIO")));
		pp.setPrecioGolden(Long.valueOf(rs.getDouble("PRECIO_GOLDEN")));
		pp.setPrecioOfertaCliente(Long.valueOf(rs.getDouble("PRECIO_OFERTA_CLIENTE")));
		pp.setPrecioOfertaSocio(Long.valueOf(rs.getDouble("PRECIO_OFERTA_SOCIO")));
		pp.setPrecioOfertaDistributor(Long.valueOf(rs.getDouble("PRECIO_OFERTA_DISTRIBUIDOR")));
		pp.setPrecioOfertaCentenario(Long.valueOf(rs.getDouble("PRECIO_OFERTA_CENTENARIO")));
		pp.setPrecioOfertaGolden(Long.valueOf(rs.getDouble("PRECIO_OFERTA_GOLDEN")));*/
		
		pp.setPrecEsOferta(Integer.valueOf(rs.getInt("PREC_ES_OFERTA")));
		return pp;
	}
}