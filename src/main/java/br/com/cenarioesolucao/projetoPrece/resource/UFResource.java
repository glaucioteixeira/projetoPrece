package br.com.cenarioesolucao.projetoPrece.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cenarioesolucao.projetoPrece.domain.UF;
import br.com.cenarioesolucao.projetoPrece.service.UFService;

@RestController
@RequestMapping(value = "/ufs")
public class UFResource {
	
	@Autowired
	private UFService service;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UF>> buscarTodas() {
		List<UF> body = service.buscarTodas();
		
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<UF> buscarId(@PathVariable Integer id) {
		UF body = service.buscarId(id);
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<UF>> buscarPaginado(@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "unidadeFederacao") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<UF> body = service.buscarPaginado(page, linesPerPage, orderBy, direction);
				
		return ResponseEntity.ok().body(body);
	}
}
