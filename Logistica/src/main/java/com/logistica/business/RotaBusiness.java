package com.logistica.business;

import com.logistica.util.MalhaLogisticaUtil;

public class RotaBusiness {

	private CidadeBusiness origem;

	private CidadeBusiness destino;

	private Integer distancia;

	private String status = MalhaLogisticaUtil.UNVISITED;

	public CidadeBusiness getOrigem() {
		return origem;
	}

	public void setOrigem(CidadeBusiness origem) {
		this.origem = origem;
	}

	public CidadeBusiness getDestino() {
		return destino;
	}

	public void setDestino(CidadeBusiness destino) {
		this.destino = destino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Distancia = " + distancia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
