package br.com.cenarioesolucao.projetoPrece.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.cenarioesolucao.projetoPrece.domain.Usuario;
import br.com.cenarioesolucao.projetoPrece.dto.UsuarioDTO;
import br.com.cenarioesolucao.projetoPrece.repository.UsuarioRepository;
import br.com.cenarioesolucao.projetoPrece.resource.exception.FieldMessage;

public class UsuarioAtualizarValidator implements ConstraintValidator<UsuarioAtualizar, UsuarioDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void initialize(UsuarioAtualizar ann) {
		
	}

	@Override
	public boolean isValid(UsuarioDTO usuarioDTO, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario aux = repository.findByEmail(usuarioDTO.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente!"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
