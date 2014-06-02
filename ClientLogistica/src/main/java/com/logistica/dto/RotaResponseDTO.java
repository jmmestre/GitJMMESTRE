package com.logistica.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RotaResponseDTO {
	
	private MensagemDTO mensagem;
	
	private String cidadeOrigem;
	
	private String cidadeDestino;
	
	private String menorCaminho;
	
	private Integer menorDistancia;
	
	private BigDecimal menorCusto;
	
	public MensagemDTO getMensagem() {
		return mensagem;
	}

	public void setMensagem(MensagemDTO mensagem) {
		this.mensagem = mensagem;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}
	
	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public String getMenorCaminho() {
		return menorCaminho;
	}

	public void setMenorCaminho(String menorCaminho) {
		this.menorCaminho = menorCaminho;
	}

	public Integer getMenorDistancia() {
		return menorDistancia;
	}

	public void setMenorDistancia(Integer menorDistancia) {
		this.menorDistancia = menorDistancia;
	}

	public BigDecimal getMenorCusto() {
		return menorCusto;
	}

	public void setMenorCusto(BigDecimal menorCusto) {
		this.menorCusto = menorCusto;
	}
	
}
