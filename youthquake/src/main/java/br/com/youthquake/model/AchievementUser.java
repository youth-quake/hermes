package br.com.youthquake.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_achievement_user")
public class AchievementUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_achievement_user")
	private int idAchievementUser;
	
	@ManyToMany
	@JoinTable(name = "achievement_users", 
			  joinColumns = @JoinColumn(name = "id_achievement_user"), 
			  inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> users = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="id_achievement")
	private User idAchievement;
	
	@Column(name = "dt_conquest")
	private String dtConquest;
	
	//Constructors
	public AchievementUser() {
		
	}

	//Getters and Setters
	public int getIdAchievementUser() {
		return idAchievementUser;
	}


	public void setIdAchievementUser(int idAchievementUser) {
		this.idAchievementUser = idAchievementUser;
	}


	public User getIdAchievement() {
		return idAchievement;
	}


	public void setIdAchievement(User idAchievement) {
		this.idAchievement = idAchievement;
	}


	public String getDtConquest() {
		return dtConquest;
	}


	public void setDtConquest(String dtConquest) {
		this.dtConquest = dtConquest;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
