package com.logistica.business;

import java.util.ArrayList;
import java.util.List;

import com.logistica.exception.BusinessException;
import com.logistica.util.ConstanteUtil;

public class MalhaLogisticaBusiness {

	private int numCidades = 0;
	private int numRotas = 0;
	private List<CidadeBusiness> cidades = new ArrayList<CidadeBusiness>();
	private List<RotaBusiness> rotas = new ArrayList<RotaBusiness>();

	public CidadeBusiness getCidade(Integer id) {
		for (CidadeBusiness cidade : cidades) {
			if (cidade.getId().equals(id)) {
				return cidade;
			}
		}
		return null;
	}

	public int getNumCidades() {
		return numCidades;
	}

	public int getNumRotas() {
		return numRotas;
	}

	public List<CidadeBusiness> getCidades() {
		return cidades;
	}

	public List<RotaBusiness> getRotas() {
		return rotas;
	}

	public int getNumeroCidades(CidadeBusiness cidade) {
		return cidade.getNumCidades();
	}

	public List<CidadeBusiness> getCidades(CidadeBusiness cidade) {
		return cidade.getCidades();
	}

	public List<RotaBusiness> getNumRotasCidade(CidadeBusiness cidade) {
		return cidade.getRotas();
	}

	public List<CidadeBusiness> endVertices(RotaBusiness rota) {
		List<CidadeBusiness> listCidades = new ArrayList<CidadeBusiness>();
		listCidades.add(rota.getOrigem());
		listCidades.add(rota.getDestino());
		return listCidades;
	}

	public static CidadeBusiness opposite(CidadeBusiness cidade, RotaBusiness rotaRequest) throws BusinessException {
		for (RotaBusiness rota : cidade.getRotas()) {
			if (rota.equals(rotaRequest)) {
				if (cidade.equals(rota.getOrigem())) {
					return rota.getDestino();
				} else {
					return rota.getOrigem();
				}
			}
		}
		throw new BusinessException(ConstanteUtil.MSG_ERRO_CIDADE_INEXISTENTE);
	}

	public RotaBusiness insertRota(CidadeBusiness origem, CidadeBusiness destino, Integer distancia) {
		RotaBusiness rota = origem.insertRota(destino, distancia);
		destino.insertRota(origem, rota, distancia);
		origem.addAdjacents(destino);
		destino.addAdjacents(origem);
		rotas.add(rota);
		numRotas++;
		return rota;
	}

	public CidadeBusiness insertCidade(Integer id, String nome) throws BusinessException {
		for (CidadeBusiness cidade : cidades) {
			if (cidade.getId().equals(id)) {
				throw new BusinessException(ConstanteUtil.MSG_ERRO_ID_DUPLICADO);
			}
		}
		CidadeBusiness countCidade = new CidadeBusiness(id, nome);
		cidades.add(countCidade);
		numCidades++;
		return countCidade;
	}

	public void removeCidade(CidadeBusiness cidade) {

		cidades.remove(cidade);
		numCidades--;
		cidade.removeAllRotas();
	}

	public void removeRota(RotaBusiness rota) {
		rota.setOrigem(null);
		rota.setDestino(null);
		rotas.remove(rota);
	}
}
