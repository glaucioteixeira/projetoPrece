package br.com.cenarioesolucao.projetoPrece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cenarioesolucao.projetoPrece.domain.UF;

@Repository
public interface UFRepository extends JpaRepository<UF, Integer>{

}
