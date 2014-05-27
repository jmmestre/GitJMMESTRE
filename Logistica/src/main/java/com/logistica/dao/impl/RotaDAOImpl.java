package com.logistica.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.logistica.dao.RotaDAO;
import com.logistica.entity.RotaEntity;
import com.logistica.entity.RotaMapper;
import com.logistica.exception.BusinessException;
import com.logistica.util.ConstanteUtil;

public class RotaDAOImpl implements RotaDAO{

	private DataSource dataSource;

	private JdbcTemplate jdbc;
	
	public List<RotaEntity> getAllRota() throws BusinessException {
		try {
			String sql = "SELECT * FROM Rota";
			this.jdbc = new JdbcTemplate(dataSource);
			return jdbc.query(sql, new RotaMapper());
		} catch (Exception e) {
			throw new BusinessException(ConstanteUtil.MSG_ERRO_DAO_ROTA);
		}
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
