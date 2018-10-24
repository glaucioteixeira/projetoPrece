package br.com.cenarioesolucao.projetoPrece.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.cenarioesolucao.projetoPrece.domain.Usuario;
import br.com.cenarioesolucao.projetoPrece.service.validation.UsuarioAtualizar;

@UsuarioAtualizar
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 80, message = "Mínimo de 5 caracteres e máximo de 80 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email(message = "Email inválido!")
	private String email;
	
	/**
	 * Construtores
	 */
	public UsuarioDTO() {
		
	}
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
