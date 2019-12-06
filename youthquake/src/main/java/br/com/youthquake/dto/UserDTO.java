package br.com.youthquake.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private long id;
	private String name;
	private String login;
	private String password;
	private String email;
	private String messageStatus;
	private String picture;
	private boolean isFirstAccess;
	private int score; 
	
	
	public boolean isFirstAccess() {
		return isFirstAccess;
	}

	public void setFirstAccess(boolean isFirstAccess) {
		this.isFirstAccess = isFirstAccess;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

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
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", email="
				+ email + ", messageStatus=" + messageStatus + ", picture=" + picture + ", score="+ score +", isFirstAccess="+ isFirstAccess +" ]";
	}
}
	
	
	
	
	