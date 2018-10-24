package br.com.cenarioesolucao.projetoPrece.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cenarioesolucao.projetoPrece.domain.LivroPrece;
import br.com.cenarioesolucao.projetoPrece.dto.LivroPreceDTO;
import br.com.cenarioesolucao.projetoPrece.service.LivroPreceService;

@RestController
@RequestMapping(value = "/livroPreces")
public class LivroPreceResource {
	
	@Autowired
	private LivroPreceService service;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LivroPrece>> buscarTodas() {
		List<LivroPrece> body = service.buscarTodas();
		
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<LivroPrece> buscarId(@PathVariable Integer id) {
		LivroPrece body = service.buscarId(id);
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<LivroPrece>> buscarPaginado(@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "unidadeFederacao") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<LivroPrece> body = service.buscarPaginado(page, linesPerPage, orderBy, direction);
				
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/dto", method = RequestMethod.GET)
	public ResponseEntity<List<LivroPreceDTO>> buscarTodasDTO() {
		List<LivroPrece> body = service.buscarTodas();
		List<LivroPreceDTO> bodyDTO = body.stream().map(obj -> new LivroPreceDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(bodyDTO);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@Valid @RequestBody LivroPreceDTO entityDTO) {
		LivroPrece entity = service.converteDTO(entityDTO);
		
		entity = service.guardar(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarId(@Valid @RequestBody LivroPreceDTO entityDTO, @PathVariable Integer id) {
		LivroPrece entity = service.converteDTO(entityDTO);
		
		entity.setId(id);
		entity = service.atualizarId(entity);
		
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> apagarId(@PathVariable Integer id) {
		service.apagarId(id);
		
		return ResponseEntity.noContent().build();
	}
}
