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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.youthquake.dto.UserDTO;

@Entity
@Component
@Table(name = "tbl_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private long idUser;

	@Column(name = "name")
	private String name;
	
	@Column(name = "login")
	private String login;
		
	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@OneToOne
	@JoinColumn(name = "id_picture")
	private Picture picture;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Movements> movements;

	@JsonProperty
	@OneToMany(mappedBy = "user")
	private List<Target> target;
	
	@JsonIgnore
	@OneToMany
	private List<Friends> friends;

	@JsonIgnore
	@ManyToMany(mappedBy = "users")
	private List<AchievementUser> AchievementUsers;

	// Constructors
	public User() {}

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}
	// Getters and Setters
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

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void userUpdateInformations(UserDTO dto) {
		this.setLogin(dto.getLogin());
		this.setPassword(dto.getPassword());
		this.setEmail(dto.getEmail());
		this.setPicture(dto.getPicture());
	}
}
