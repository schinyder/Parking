package com.techchallenge.parquimetro.exception;

public class ControllerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ControllerNotFoundException(String message) {
    	 super(message);
     }
}

