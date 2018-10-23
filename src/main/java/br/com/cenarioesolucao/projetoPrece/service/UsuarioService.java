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

import br.com.cenarioesolucao.projetoPrece.domain.Endereco;
import br.com.cenarioesolucao.projetoPrece.domain.Municipio;
import br.com.cenarioesolucao.projetoPrece.domain.Usuario;
import br.com.cenarioesolucao.projetoPrece.domain.enums.TipoUsuario;
import br.com.cenarioesolucao.projetoPrece.dto.UsuarioDTO;
import br.com.cenarioesolucao.projetoPrece.dto.UsuarioNewDTO;
import br.com.cenarioesolucao.projetoPrece.repository.EnderecoRepository;
import br.com.cenarioesolucao.projetoPrece.repository.UsuarioRepository;
import br.com.cenarioesolucao.projetoPrece.service.exception.DataIntegrityException;
import br.com.cenarioesolucao.projetoPrece.service.exception.ObjectNotFoundException;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public Usuario buscarId(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
				
		return obj.orElseThrow(() -> new ObjectNotFoundException("Recurso não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> buscarTodas() {
		return repository.findAll();
	}
	
	public Page<Usuario> buscarPaginado(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	@Transactional
	public Usuario guardar(Usuario entity) {
		entity.setId(null);
		entity = repository.save(entity);
		enderecoRepository.saveAll(entity.getEnderecos());
		
		return entity;
	}
	
	@Transactional
	public Usuario atualizarId(Usuario entity) {
		Usuario newEntity = buscarId(entity.getId());
		atualizarEntity(newEntity, entity);
		
		return repository.save(newEntity);
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
	public Usuario converteDTO(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail(), null, null);
	}
	public Usuario converteDTO(UsuarioNewDTO usuarioNewDTO) {
		Usuario usuario = new Usuario(null, usuarioNewDTO.getNome(), usuarioNewDTO.getEmail(), usuarioNewDTO.getCpfOuCnpj(), TipoUsuario.toEnum(usuarioNewDTO.getTipoUsuario()));
		Municipio municipio = new Municipio(usuarioNewDTO.getCidadeId(), null, null);
		
		Endereco endereco = new Endereco(null, usuarioNewDTO.getLogradouro(), usuarioNewDTO.getNumero(), usuarioNewDTO.getComplemento(), usuarioNewDTO.getBairro(), usuarioNewDTO.getCep(), usuario, municipio);

		usuario.getEnderecos().add(endereco);
		usuario.getTelefones().add(usuarioNewDTO.getTelefone1());
		if (usuarioNewDTO.getTelefone2() != null) {
			usuario.getTelefones().add(usuarioNewDTO.getTelefone2());
		}
		if (usuarioNewDTO.getTelefone3() != null) {
			usuario.getTelefones().add(usuarioNewDTO.getTelefone3());
		}
		
		return usuario;
	}
	
	/**
	 * Atualiza os dados do novo objeto com base no objeto que veio como argumento [ Somente os campos que serao atualizados
	 * @param newEntity
	 * @param entity
	 */
	private void atualizarEntity(Usuario newEntity, Usuario entity) {
		newEntity.setNome(entity.getNome());
		newEntity.setEmail(entity.getEmail());
	}
}
