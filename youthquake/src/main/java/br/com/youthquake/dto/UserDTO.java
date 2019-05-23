package br.com.youthquake.dto;

import java.io.Serializable;

import br.com.youthquake.model.Picture;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private long id;
	private String name;
	private String login;
	private String password;
	private String email;
	private Picture picture;
	
	
	
	public UserDTO() {}
	
	public UserDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public Picture getPicture() {
		return picture;
	}
	
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name="+ name +", login=" + login + ", password=" + password + ", email=" + email;
	}
}
	
	
	
	
	