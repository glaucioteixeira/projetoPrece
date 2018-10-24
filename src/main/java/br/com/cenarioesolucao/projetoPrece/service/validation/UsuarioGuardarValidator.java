package br.com.cenarioesolucao.projetoPrece.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cenarioesolucao.projetoPrece.domain.Usuario;
import br.com.cenarioesolucao.projetoPrece.domain.enums.TipoUsuario;
import br.com.cenarioesolucao.projetoPrece.dto.UsuarioNewDTO;
import br.com.cenarioesolucao.projetoPrece.repository.UsuarioRepository;
import br.com.cenarioesolucao.projetoPrece.resource.exception.FieldMessage;
import br.com.cenarioesolucao.projetoPrece.service.validation.utils.BR;

public class UsuarioGuardarValidator implements ConstraintValidator<UsuarioGuardar, UsuarioNewDTO> {
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void initialize(UsuarioGuardar ann) {
		
	}

	@Override
	public boolean isValid(UsuarioNewDTO usuarioNewDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (usuarioNewDTO.getTipoUsuario().equals(TipoUsuario.PESSOAFISICA.getCodigo()) && !BR.isValidCPF(usuarioNewDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("CpfOuCnpj", "CPF Inválido"));
		}
		if (usuarioNewDTO.getTipoUsuario().equals(TipoUsuario.PESSOAJURIDICA.getCodigo()) && !BR.isValidCNPJ(usuarioNewDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("CpfOuCnpj", "CNPJ Inválido"));
		}
		
		Usuario aux = repository.findByEmail(usuarioNewDTO.getEmail());
		if (aux != null) {
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
