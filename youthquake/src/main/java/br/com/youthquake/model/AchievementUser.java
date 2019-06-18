package br.com.youthquake.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name = "tbl_achievement_user")
public class AchievementUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_achievement_user")
	private int idAchievementUser;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_user")
	private User user;

	@OneToOne
	@JoinColumn(name = "id_achievement")
	private AchievementSystem idAchievement;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "progress")
	private String progress;

	@Column(name = "dt_conquest")
	private String dtConquest;

	// Constructors
	public AchievementUser() {

	}

	// Getters and Setters
	public int getIdAchievementUser() {
		return idAchievementUser;
	}

	public void setIdAchievementUser(int idAchievementUser) {
		this.idAchievementUser = idAchievementUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AchievementSystem getIdAchievement() {
		return idAchievement;
	}

	public void setIdAchievement(AchievementSystem idAchievement) {
		this.idAchievement = idAchievement;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getDtConquest() {
		return dtConquest;
	}

	public void setDtConquest(String dtConquest) {
		this.dtConquest = dtConquest;
	}

}
