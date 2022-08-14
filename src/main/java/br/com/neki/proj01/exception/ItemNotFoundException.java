package br.com.neki.proj01.exception;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String message) {
		super(message);
	}	

}