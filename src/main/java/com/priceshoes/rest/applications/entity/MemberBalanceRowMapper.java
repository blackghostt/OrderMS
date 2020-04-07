package com.priceshoes.rest.applications.entity;

import com.priceshoes.rest.applications.entity.MemberBalance;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MemberBalanceRowMapper implements RowMapper<MemberBalance> {
	public MemberBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberBalance memberBalance = new MemberBalance();
		memberBalance.setNC(rs.getBigDecimal("NC"));
		memberBalance.setVales(rs.getBigDecimal("VALES"));
		memberBalance.setDepositos(rs.getBigDecimal("DEPOSITOS"));
		memberBalance.setSaldo(rs.getBigDecimal("SOCIO"));
		return memberBalance;
	}
}