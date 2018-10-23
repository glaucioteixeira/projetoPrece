package br.com.cenarioesolucao.projetoPrece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cenarioesolucao.projetoPrece.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{

}
