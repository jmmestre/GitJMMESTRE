package com.logistica.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RotaRequestDTO {

	private Integer idOrigem;
	
	private Integer idDestino;
	
	private Integer autonomia;
	
	private Double valorCombustivel;

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

	public Integer getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(Integer autonomia) {
		this.autonomia = autonomia;
	}

	public Double getValorCombustivel() {
		return valorCombustivel;
	}

	public void setValorCombustivel(Double valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}
}
