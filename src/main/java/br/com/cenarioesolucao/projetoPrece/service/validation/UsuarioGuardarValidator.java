package br.com.cenarioesolucao.projetoPrece.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.cenarioesolucao.projetoPrece.domain.enums.TipoUsuario;
import br.com.cenarioesolucao.projetoPrece.dto.UsuarioNewDTO;
import br.com.cenarioesolucao.projetoPrece.resource.exception.FieldMessage;
import br.com.cenarioesolucao.projetoPrece.service.validation.utils.BR;

public class UsuarioGuardarValidator implements ConstraintValidator<UsuarioGuardar, UsuarioNewDTO> {
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
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
