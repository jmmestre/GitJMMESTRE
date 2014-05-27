package com.logistica.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RotaMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet result, int arg1) throws SQLException {
		RotaEntity rota = new RotaEntity();
		rota.setIdRota(result.getInt("ID_ROTA"));
		rota.setIdOrigem(result.getInt("ID_ORIGEM"));
		rota.setIdDestino(result.getInt("ID_DESTINO"));
		rota.setDistancia(result.getInt("NR_DISTANCIA"));
		return rota;
	}

}
