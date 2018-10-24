package br.com.cenarioesolucao.projetoPrece.dto;

import java.io.Serializable;

public class CredencialDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	
	/**
	 * Construtores
	 */
	public CredencialDTO() {
		
	}

	/**
	 * Getters and setters
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
