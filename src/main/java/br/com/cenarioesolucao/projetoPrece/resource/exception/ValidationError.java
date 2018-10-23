package br.com.cenarioesolucao.projetoPrece.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	private List<FieldMessage> erros = new ArrayList<>();

	/**
	 * Construtores
	 * @param status
	 * @param msg
	 * @param cause
	 * @param timeStamp
	 */
	public ValidationError(Integer status, String msg, Throwable cause, Long timeStamp) {
		super(status, msg, cause, timeStamp);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public List<FieldMessage> getErros() {
		return erros;
	}

	public void setErros(List<FieldMessage> erros) {
		this.erros = erros;
	}
	
	/**
	 * Metodo para adicionar os erros individualmente.
	 * @param fieldName
	 * @param message
	 */
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}



}
