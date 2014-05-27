package com.logistica.business;

import java.util.ArrayList;
import java.util.List;

import com.logistica.util.MalhaLogisticaUtil;

public class CidadeBusiness implements Comparable<CidadeBusiness> {

	private List<CidadeBusiness> cidades = new ArrayList<CidadeBusiness>();

	private List<RotaBusiness> rotas = new ArrayList<RotaBusiness>();

	private Integer id;

	private String name;

	private int distancia = Integer.MAX_VALUE;

	private CidadeBusiness previous;

	private String status = MalhaLogisticaUtil.UNVISITED;

	public CidadeBusiness(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getNumCidades() {
		return this.cidades.size();
	}

	public List<CidadeBusiness> getCidades() {
		return cidades;
	}

	public void setAdjacents(List<CidadeBusiness> adjacents) {
		this.cidades = adjacents;
	}

	public void addAdjacents(CidadeBusiness adjacents) {
		this.cidades.add(adjacents);
	}

	public List<RotaBusiness> getRotas() {
		return rotas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RotaBusiness insertRota(CidadeBusiness w, Integer o) {
		RotaBusiness e = new RotaBusiness();
		e.setOrigem(this);
		e.setDestino(w);
		e.setDistancia(o);
		this.rotas.add(e);
		return e;
	}

	public RotaBusiness insertRota(CidadeBusiness w, RotaBusiness e, Integer weigth) {
		e.setOrigem(w);
		e.setDestino(this);
		e.setDistancia(weigth);
		this.rotas.add(e);
		return e;
	}

	public void removeAllRotas() {
		this.rotas = new ArrayList<RotaBusiness>();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CidadeBusiness) {
			if (this.id.equals(((CidadeBusiness) obj).getId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Cidade: " + name;
	}

	public int compareTo(CidadeBusiness other) {
		return Double.compare(distancia, other.getDistancia());
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDist(int dist) {
		this.distancia = dist;
	}

	public CidadeBusiness getPrevious() {
		return previous;
	}

	public void setPrevious(CidadeBusiness previous) {
		this.previous = previous;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
