package br.com.cenarioesolucao.projetoPrece.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cenarioesolucao.projetoPrece.domain.Usuario;
import br.com.cenarioesolucao.projetoPrece.dto.UsuarioDTO;
import br.com.cenarioesolucao.projetoPrece.dto.UsuarioNewDTO;
import br.com.cenarioesolucao.projetoPrece.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> buscarTodas() {
		List<Usuario> body = service.buscarTodas();
		
		return ResponseEntity.ok().body(body);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscarId(@PathVariable Integer id) {
		Usuario body = service.buscarId(id);
		return ResponseEntity.ok().body(body);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Usuario>> buscarPaginado(@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<Usuario> body = service.buscarPaginado(page, linesPerPage, orderBy, direction);
				
		return ResponseEntity.ok().body(body);
	}
	
	@RequestMapping(value = "/dto", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> buscarTodasDTO() {
		List<Usuario> body = service.buscarTodas();
		List<UsuarioDTO> bodyDTO = body.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(bodyDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@Valid @RequestBody UsuarioNewDTO entityNewDTO) {
		Usuario entity = service.converteDTO(entityNewDTO);
		
		entity = service.guardar(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarId(@Valid @RequestBody UsuarioDTO entityDTO, @PathVariable Integer id) {
		Usuario entity = service.converteDTO(entityDTO);
		
		entity.setId(id);
		entity = service.atualizarId(entity);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> apagarId(@PathVariable Integer id) {
		service.apagarId(id);
		
		return ResponseEntity.noContent().build();
	}

}
