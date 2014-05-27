package com.logistica.entity;


public class RotaEntity {
	
	private Integer idRota;
	
	private Integer idOrigem;
	
	private Integer idDestino;
	
	private Integer distancia;

	public Integer getIdRota() {
		return idRota;
	}

	public void setIdRota(Integer idRota) {
		this.idRota = idRota;
	}

	public Integer getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(Integer idOrigem) {
		this.idOrigem = idOrigem;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
}
