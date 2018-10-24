package br.com.cenarioesolucao.projetoPrece.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cenarioesolucao.projetoPrece.domain.Municipio;
import br.com.cenarioesolucao.projetoPrece.dto.MunicipioDTO;
import br.com.cenarioesolucao.projetoPrece.service.MunicipioService;

@RestController
@RequestMapping(value = "/municipios")
public class MunicipioResource {
	
	@Autowired
	private MunicipioService service;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Municipio>> buscarTodas() {
		List<Municipio> body = service.buscarTodas();
		
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Municipio> buscarId(@PathVariable Integer id) {
		Municipio body = service.buscarId(id);
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Municipio>> buscarPaginado(@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "municipio") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<Municipio> body = service.buscarPaginado(page, linesPerPage, orderBy, direction);
				
		return ResponseEntity.ok().body(body);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/dto", method = RequestMethod.GET)
	public ResponseEntity<List<MunicipioDTO>> buscarTodasDTO() {
		List<Municipio> body = service.buscarTodas();
		List<MunicipioDTO> bodyDTO = body.stream().map(obj -> new MunicipioDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(bodyDTO);
	}
}
