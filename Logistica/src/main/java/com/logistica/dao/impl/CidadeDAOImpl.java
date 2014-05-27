package com.logistica.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.logistica.dao.CidadeDAO;
import com.logistica.entity.CidadeEntity;
import com.logistica.entity.CidadeMapper;
import com.logistica.exception.BusinessException;
import com.logistica.util.ConstanteUtil;

public class CidadeDAOImpl implements CidadeDAO{

	private DataSource dataSource;

	private JdbcTemplate jdbc;
	
	@Override
	public List<CidadeEntity> getAllCidade() throws BusinessException {
		try {
			String sql = "SELECT * FROM Cidade";
			this.jdbc = new JdbcTemplate(dataSource);
			return jdbc.query(sql, new CidadeMapper());
		} catch (Exception e) {
			throw new BusinessException(ConstanteUtil.MSG_ERRO_DAO_CIDADE);
		}
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
