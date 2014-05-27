package com.logistica.dao;

import java.util.List;

import com.logistica.entity.RotaEntity;
import com.logistica.exception.BusinessException;

public interface RotaDAO {

	public List<RotaEntity> getAllRota() throws BusinessException;
}
