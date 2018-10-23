package br.com.cenarioesolucao.projetoPrece.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.cenarioesolucao.projetoPrece.domain.UF;
import br.com.cenarioesolucao.projetoPrece.repository.UFRepository;
import br.com.cenarioesolucao.projetoPrece.service.exception.ObjectNotFoundException;


@Service
public class UFService {

	@Autowired
	private UFRepository repository;
	
	public UF buscarId(Integer id) {
		Optional<UF> obj = repository.findById(id);
				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Recurso não encontrado! Id: " + id + ", Tipo: " + UF.class.getName()));
	}
	
	public List<UF> buscarTodas() {
		return repository.findAll();
	}
	
	public Page<UF> buscarPaginado(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
}
