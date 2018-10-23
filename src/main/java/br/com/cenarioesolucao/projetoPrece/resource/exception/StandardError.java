package br.com.cenarioesolucao.projetoPrece.resource.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Throwable cause;
	private Long timeStamp;
	
	public StandardError(Integer status, String msg, Throwable cause, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.cause = cause;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
		

}
