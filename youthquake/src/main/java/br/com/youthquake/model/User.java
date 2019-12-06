package br.com.youthquake.model;

import java.io.Serializable;
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

	@Column(name = "status_message")
	private String messageStatus;

	@Column(name = "path_picture")
	private String picture;

	@Column(name = "level")
	private int level;
	
	@Column(name="first_access")
	private boolean isFirstAccess;
	
	@Column(name="score")
	private int score;

	@JsonProperty
	@OneToMany(mappedBy = "user")
	private List<Movements> movements;

	@JsonProperty
	@OneToMany(mappedBy = "user")
	private List<Target> target;

	@JsonIgnore
	@OneToMany
	private List<Friends> friends;

	@JsonProperty
	@OneToMany(mappedBy = "user")
	private List<AchievementUser> achievementUsers;

	@JsonProperty
	@OneToMany(mappedBy = "user")
	private List<ActionUser> actionUsers;

	// Constructors
	public User() {
	}

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}
	// Getters and Setters

	public long getIdUser() {
		return idUser;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public String getMessageStatus() {
		return messageStatus;
	}
	
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

	public void userUpdateInformations(UserDTO dto) {
		this.setName(dto.getName());
		this.setLogin(dto.getLogin());
		this.setEmail(dto.getEmail());
		this.setPassword(dto.getPassword());
	}

	public void updateUserInfos(UserDTO dto) {
		this.setMessageStatus(dto.getMessageStatus());
	}

	public void updatePictureUser(UserDTO dto) {
		this.setPicture(dto.getPicture());
	}
	
	public void updateScoreUser(UserDTO dto) {
		this.setScore(this.getScore() + dto.getScore());
	}
}
