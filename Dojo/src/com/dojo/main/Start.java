package com.dojo.main;

import com.dojo.entity.Jogo;
import com.dojo.entity.Partida;
import com.dojo.service.JogoService;

public class Start {

	public static void main(String[] args) throws Exception {

		JogoService service = new JogoService();
		Jogo jogo = service.iniciarJogo("src-logs/Partida.txt");
		
		for (Partida partida : jogo.getJogo().values()) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("Partida: " + partida.getNumeroPartida());
			System.out.println("Assassinos: " + partida.getAssasinatos());
			System.out.println("Mortes: " + partida.getMortes());
			System.out.println("Armas: " + partida.getArmas());
		}
	}
}
