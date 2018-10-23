package br.com.cenarioesolucao.projetoPrece.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.cenarioesolucao.projetoPrece.domain.Municipio;
import br.com.cenarioesolucao.projetoPrece.repository.MunicipioRepository;
import br.com.cenarioesolucao.projetoPrece.service.exception.ObjectNotFoundException;


@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository repository;
	
	public Municipio buscarId(Integer id) {
		Optional<Municipio> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Recurso não encontrado! Id: " + id + ", Tipo: " + Municipio.class.getName()));
	}
	
	public List<Municipio> buscarTodas() {
		return repository.findAll();
	}
	
	public Page<Municipio> buscarPaginado(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
}
