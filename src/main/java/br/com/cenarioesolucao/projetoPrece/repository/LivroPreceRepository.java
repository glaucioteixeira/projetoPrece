package br.com.cenarioesolucao.projetoPrece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cenarioesolucao.projetoPrece.domain.LivroPrece;

@Repository
public interface LivroPreceRepository extends JpaRepository<LivroPrece, Integer>{

}
