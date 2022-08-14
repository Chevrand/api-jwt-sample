package br.com.neki.proj01.exception;

public class MayNotBeNullException extends Exception {

	private static final long serialVersionUID = 1L;

	public MayNotBeNullException(String message) {
		super(message);
	}	

}