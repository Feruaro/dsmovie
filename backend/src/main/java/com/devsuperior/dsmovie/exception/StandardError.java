package com.devsuperior.dsmovie.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer httpStatus;
	private String message;
	private Long timeMillis;

	public StandardError(Integer httpStatus, String message, Long timeMillis) {
		this.httpStatus = httpStatus;
		this.message = message;
		this.timeMillis = timeMillis;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimeMillis() {
		return timeMillis;
	}

	public void setTimeMillis(Long timeMillis) {
		this.timeMillis = timeMillis;
	}

}
