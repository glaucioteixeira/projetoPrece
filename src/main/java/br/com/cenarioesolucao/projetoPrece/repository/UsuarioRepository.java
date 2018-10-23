package br.com.cenarioesolucao.projetoPrece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cenarioesolucao.projetoPrece.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
