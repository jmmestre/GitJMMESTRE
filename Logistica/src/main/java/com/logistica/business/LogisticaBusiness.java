package com.logistica.business;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logistica.dao.CidadeDAO;
import com.logistica.dao.RotaDAO;
import com.logistica.dto.RotaRequestDTO;
import com.logistica.dto.RotaResponseDTO;
import com.logistica.entity.CidadeEntity;
import com.logistica.entity.RotaEntity;
import com.logistica.exception.BusinessException;
import com.logistica.util.ConstanteUtil;
import com.logistica.util.MalhaLogisticaUtil;

public class LogisticaBusiness{

	public RotaResponseDTO getBestRota(RotaRequestDTO request) throws BusinessException {
		
		validaRequest(request);
		
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    	
    	RotaDAO rotaDAO = (RotaDAO) context.getBean("rotaDAO");
    	CidadeDAO cidadeDAO = (CidadeDAO) context.getBean("cidadeDAO");
    	
		List<CidadeEntity> listCidade = cidadeDAO.getAllCidade();
		List<RotaEntity> listRota = rotaDAO.getAllRota();
		
		MalhaLogisticaBusiness malha = criarMalha(listCidade, listRota);
		
		CidadeBusiness cidade = malha.getCidade(request.getIdOrigem());
		MalhaLogisticaUtil.dijkstra(cidade);
		
		RotaResponseDTO response = MalhaLogisticaUtil.getMenorCaminho(malha, request.getIdDestino());
		response.setCidadeOrigem(cidade.getName());
		
		return response;
		
	}

	private void validaRequest(RotaRequestDTO request) throws BusinessException {
		if (request != null) {
			if (request.getAutonomia() == null || request.getAutonomia() == 0) {
				throw new BusinessException(ConstanteUtil.MSG_ERRO_AUTONOMIA);
			}
			if (request.getIdOrigem() == null || request.getIdOrigem() == 0) {
				throw new BusinessException(ConstanteUtil.MSG_ERRO_ORIGEM);
			}
			if (request.getIdDestino() == null || request.getIdDestino() == 0) {
				throw new BusinessException(ConstanteUtil.MSG_ERRO_DESTINO);
			}
			if (request.getValorCombustivel() == null || request.getValorCombustivel() == 0) {
				throw new BusinessException(ConstanteUtil.MSG_ERRO_COMBUSTIVEL);
			}
		} else {
			throw new BusinessException(ConstanteUtil.MSG_ERRO_REQUISICAO);
		}
	}

	public void addRota(RotaEntity rota) {
		
	}

	private MalhaLogisticaBusiness criarMalha(List<CidadeEntity> listCidade, List<RotaEntity> listRota) throws BusinessException {

		MalhaLogisticaBusiness malha = new MalhaLogisticaBusiness();
		HashMap<Integer, CidadeBusiness> mapCidade = new HashMap<Integer, CidadeBusiness>();

		for (CidadeEntity cidadeEntity : listCidade) {
			mapCidade.put(cidadeEntity.getIdCidade(), malha.insertCidade(cidadeEntity.getIdCidade(), cidadeEntity.getNomeCidade()));
		}

		for (RotaEntity rotaEntity : listRota) {
			malha.insertRota(mapCidade.get(rotaEntity.getIdOrigem()), mapCidade.get(rotaEntity.getIdDestino()), rotaEntity.getDistancia());
		}

		return malha;
	}
}
