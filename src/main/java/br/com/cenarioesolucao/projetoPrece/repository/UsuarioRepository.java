package br.com.cenarioesolucao.projetoPrece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cenarioesolucao.projetoPrece.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	/**
	 * Implementa a busca por email 
	 * @param email
	 * @return
	 */
	
	@Transactional(readOnly = true)
	Usuario findByEmail(String email);
}
