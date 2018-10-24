package br.com.cenarioesolucao.projetoPrece.service;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.cenarioesolucao.projetoPrece.security.UsuarioSpringSecurity;

public class UsuarioLogadoService {

	public static UsuarioSpringSecurity authenticated() {
		try {
			return (UsuarioSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
