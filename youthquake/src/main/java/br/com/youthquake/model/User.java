package br.com.youthquake.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Component
@Table(name = "tbl_user")
public class User implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "login_user", nullable = false)
	private String login;

	@Column(name = "password_user", nullable = false)
	private String password;
	
	@Column(name = "email_user", nullable = false)
	private String email;
	
	@Column(name = "telephone_user", nullable = false)
	private String telephone;
	
	public User() {}

	public User(long id, String login, String password, String email, String telephone) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.telephone = telephone;
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

	public void setTelephone(String telefone) {
		this.telephone = telefone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", telefone="
				+ telephone + "]";
	}
	
	
}
