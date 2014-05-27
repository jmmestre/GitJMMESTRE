package com.logistica.dao;

import java.util.List;

import com.logistica.entity.CidadeEntity;
import com.logistica.exception.BusinessException;

public interface CidadeDAO {

	public List<CidadeEntity> getAllCidade() throws BusinessException;
}
