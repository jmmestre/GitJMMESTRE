package com.dojo.entity;

import java.util.LinkedHashMap;

public class Jogo {

	private LinkedHashMap<String, Partida> jogo = new LinkedHashMap<String, Partida>();

	public LinkedHashMap<String, Partida> getJogo() {
		return jogo;
	}

	public void setJogo(LinkedHashMap<String, Partida> jogo) {
		this.jogo = jogo;
	}
	
}
