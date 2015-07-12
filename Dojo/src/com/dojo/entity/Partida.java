package com.dojo.entity;

import java.util.LinkedHashMap;

public class Partida {

	private String numeroPartida;
	
	private LinkedHashMap<String, Integer> assasinatos = new LinkedHashMap<String, Integer>();
	
	private LinkedHashMap<String, Integer> mortes = new LinkedHashMap<String, Integer>();
	
	private LinkedHashMap<String, Integer> armas = new LinkedHashMap<String, Integer>();

	public String getNumeroPartida() {
		return numeroPartida;
	}

	public void setNumeroPartida(String numeroPartida) {
		this.numeroPartida = numeroPartida;
	}

	public LinkedHashMap<String, Integer> getAssasinatos() {
		return assasinatos;
	}

	public void setAssasinatos(LinkedHashMap<String, Integer> assasinatos) {
		this.assasinatos = assasinatos;
	}

	public LinkedHashMap<String, Integer> getMortes() {
		return mortes;
	}

	public void setMortes(LinkedHashMap<String, Integer> mortes) {
		this.mortes = mortes;
	}

	public LinkedHashMap<String, Integer> getArmas() {
		return armas;
	}

	public void setArmas(LinkedHashMap<String, Integer> armas) {
		this.armas = armas;
	}

}
