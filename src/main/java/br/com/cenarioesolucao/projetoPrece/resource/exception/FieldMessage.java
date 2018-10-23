package br.com.cenarioesolucao.projetoPrece.resource.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	private String fieldName;
	private String message;
	
	/**
	 * Construtores
	 */
	public FieldMessage() {
		
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
