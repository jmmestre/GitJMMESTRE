package com.logistica.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CidadeMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet result, int arg1) throws SQLException {
		CidadeEntity cidade = new CidadeEntity();
		cidade.setIdCidade(result.getInt("ID_CIDADE"));
		cidade.setNomeCidade(result.getString("NM_CIDADE"));
		return cidade;
	}

}
