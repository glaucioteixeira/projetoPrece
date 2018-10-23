package br.com.cenarioesolucao.projetoPrece.dto;

import java.io.Serializable;

import br.com.cenarioesolucao.projetoPrece.domain.Municipio;

public class MunicipioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	private Integer id;
	private String municipio;
	
	/**
	 * Construtores
	 */
	public MunicipioDTO() {
		
	}
	public MunicipioDTO(Municipio municipio) {
		this.id = municipio.getId();
		this.municipio = municipio.getMunicipio();
	}

	/**
	 * Getters and Setters
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	
}
