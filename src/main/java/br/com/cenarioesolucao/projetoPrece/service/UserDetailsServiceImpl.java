package br.com.cenarioesolucao.projetoPrece.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cenarioesolucao.projetoPrece.domain.Usuario;
import br.com.cenarioesolucao.projetoPrece.repository.UsuarioRepository;
import br.com.cenarioesolucao.projetoPrece.security.UsuarioSpringSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		
		
		return new UsuarioSpringSecurity(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfilUsuarios());
	}

}
