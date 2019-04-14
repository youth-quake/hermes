package br.com.youthquake.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	@Column(name = "id_user")
	private long idUser;
	
	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@OneToOne
	@JoinColumn(name="id_picture")
	private Picture picture;
	
	@OneToMany
	private List<Movements> movements = new ArrayList<>(); 
	
	@OneToMany
	private List<Couple> couples = new ArrayList<>();
	
	@ManyToMany(mappedBy = "users")
	private List<Goal> goals = new ArrayList<>();
	
	@ManyToMany(mappedBy = "users")
	private List<AchievementUser> AchievementUsers = new ArrayList<>();
	
	
	//Constructors
	public User() {}
	
	//Getters and Setters
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
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

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	
}
