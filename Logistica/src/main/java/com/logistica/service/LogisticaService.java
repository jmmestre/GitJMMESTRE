package com.logistica.service;

import com.logistica.dto.RotaResponseDTO;

public interface LogisticaService {
	
	public RotaResponseDTO consultarRota(Integer origem, Integer destino,
			Integer autonomia, Double valorCombustivel);
	
}
