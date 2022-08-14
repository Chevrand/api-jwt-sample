package br.com.neki.proj01.security;

public class UserAuthenticationResponse {

	private final String token;

	private String getToken() {
		return token;
	}

	public UserAuthenticationResponse(String token) {
		this.token = token;
	}

}