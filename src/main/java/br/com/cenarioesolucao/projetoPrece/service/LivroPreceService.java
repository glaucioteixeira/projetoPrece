package br.com.cenarioesolucao.projetoPrece.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cenarioesolucao.projetoPrece.domain.LivroPrece;
import br.com.cenarioesolucao.projetoPrece.dto.LivroPreceDTO;
import br.com.cenarioesolucao.projetoPrece.repository.LivroPreceRepository;
import br.com.cenarioesolucao.projetoPrece.service.exception.DataIntegrityException;
import br.com.cenarioesolucao.projetoPrece.service.exception.ObjectNotFoundException;


@Service
public class LivroPreceService {

	@Autowired
	private LivroPreceRepository repository;
	
	public LivroPrece buscarId(Integer id) {
		Optional<LivroPrece> obj = repository.findById(id);
				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Recurso não encontrado! Id: " + id + ", Tipo: " + LivroPrece.class.getName()));
	}
	
	public List<LivroPrece> buscarTodas() {
		return repository.findAll();
	}
	
	public Page<LivroPrece> buscarPaginado(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	@Transactional
	public LivroPrece guardar(LivroPrece entity) {
		entity.setId(null);
		return repository.save(entity);
	}
	
	@Transactional
	public LivroPrece atualizarId(LivroPrece entity) {
		LivroPrece newEntity = buscarId(entity.getId());
		atualizarEntity(newEntity, entity);
		
		return repository.save(entity);
	}
	
	@Transactional
	public void apagarId(Integer id) {
		buscarId(id);
		
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("[ Integridade referencial ] Não é possivel excluir !");
		}
	}
	
	/**
	 * Metodo auxiliar que instacia uma classe LivroPrece a partir de um DTO
	 * @param livroPreceDTO
	 * @return
	 */
	public LivroPrece converteDTO(LivroPreceDTO livroPreceDTO) {
		return new LivroPrece(livroPreceDTO.getId(), livroPreceDTO.getNome());
	}
	
	/**
	 * Atualiza os dados do novo objeto com base no objeto que veio como argumento [ Somente os campos que serao atualizados
	 * @param newEntity
	 * @param entity
	 */
	private void atualizarEntity(LivroPrece newEntity, LivroPrece entity) {
		newEntity.setNome(entity.getNome());
	}
}
