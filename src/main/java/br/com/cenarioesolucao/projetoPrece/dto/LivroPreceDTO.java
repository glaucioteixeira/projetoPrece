package br.com.cenarioesolucao.projetoPrece.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.cenarioesolucao.projetoPrece.domain.LivroPrece;

public class LivroPreceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 80, message = "Mínimo de 5 caracteres e máximo de 80 caracteres.")
	private String nome;
	
	/**
	 * Construtores
	 */
	public LivroPreceDTO() {
		
	}
	public LivroPreceDTO(LivroPrece livroPrece) {
		this.id = livroPrece.getId();
		this.nome = livroPrece.getNome();
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
