package com.logistica.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.logistica.business.CidadeBusiness;
import com.logistica.business.MalhaLogisticaBusiness;
import com.logistica.business.RotaBusiness;
import com.logistica.dto.RotaResponseDTO;
import com.logistica.exception.BusinessException;

public class MalhaLogisticaUtil {
	
	public static String VISITED = "VISITED";

	public static String UNVISITED = "UNVISITED";

	public static void dijkstra(CidadeBusiness inicial) throws BusinessException {
		inicial.setDist(0);
		PriorityQueue<CidadeBusiness> queue = new PriorityQueue<CidadeBusiness>();
		queue.add(inicial);

		while (!queue.isEmpty()) {
			CidadeBusiness cidade = queue.poll();

			for (RotaBusiness rota : cidade.getRotas()) {
				CidadeBusiness v = MalhaLogisticaBusiness.opposite(cidade, rota);
				int distancia = rota.getDistancia();
				int distanceTotal = cidade.getDistancia() + distancia;
				if (distanceTotal < v.getDistancia()) {
					queue.remove(v);
					v.setDist(distanceTotal);
					v.setPrevious(cidade);
					queue.add(v);
				}
			}
		}
	}

	private static List<CidadeBusiness> montaMenorCaminho(CidadeBusiness cidadeRequest) {
		List<CidadeBusiness> caminho = new ArrayList<CidadeBusiness>();
		for (CidadeBusiness cidade = cidadeRequest; cidade != null; cidade = cidade.getPrevious()) {
			caminho.add(cidade);
		}
		Collections.reverse(caminho);
		return caminho;
	}

	public static RotaResponseDTO getMenorCaminho(MalhaLogisticaBusiness malha, Integer cidadeDestino) {
		for (CidadeBusiness cidade : malha.getCidades()) {
			if (cidade.getId().equals(cidadeDestino)) {
				RotaResponseDTO response = new RotaResponseDTO();
				response.setCidadeDestino(cidade.getName());
				response.setMenorCaminho(montaMenorCaminho(cidade).toString());
				response.setMenorDistancia(cidade.getDistancia());
				return response;
			}
		}
		return null;
	}
}