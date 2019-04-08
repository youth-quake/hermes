package br.com.youthquake.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private long id;
	private String login;
	private String password;

	public UserDTO() {}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
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

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
}
	
	
	
	
	