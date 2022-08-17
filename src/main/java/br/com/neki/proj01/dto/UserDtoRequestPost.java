package br.com.neki.proj01.dto;

public class UserDtoRequestPost {
	
	private String login;
	private String password;
	
	public UserDtoRequestPost() {}	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}