package br.com.youthquake.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private long id;
	private String login;
	private String password;
	private String email;
	private String telephone;
	
	public UserDTO() {}
	
	public UserDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}



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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", telephone="
				+ telephone + "]";
	}
}
	
	
	
	
	