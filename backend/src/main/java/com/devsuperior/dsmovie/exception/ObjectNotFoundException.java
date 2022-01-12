package com.devsuperior.dsmovie.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String obj, Long id) {
		super(obj + " não encontrado! Id: " + id);
	}

}
