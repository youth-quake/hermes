package br.com.youthquake.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_score_user")
public class ScoreUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_score_user")
	private int idScoreUser;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@OneToOne
	@JoinColumn(name="id_level")
	private Level level;
	
	@OneToOne
	@JoinColumn(name="number_level")
	private Level numberLevel;
	
	@OneToOne
	@JoinColumn(name="score_required_next_level")
	private Level scoreRequiredNextLevel;
		
	@Column(name = "score")
	private int score;
	
	@OneToMany
	private List<User> users = new ArrayList<>();
	
	
	//Constructors
	public ScoreUser() {
		
	}
	
	//Getters and Setters
	public int getIdScoreUser() {
		return idScoreUser;
	}

	public void setIdScoreUser(int idScoreUser) {
		this.idScoreUser = idScoreUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Level getNumberLevel() {
		return numberLevel;
	}

	public void setNumberLevel(Level numberLevel) {
		this.numberLevel = numberLevel;
	}

	public Level getScoreRequiredNextLevel() {
		return scoreRequiredNextLevel;
	}

	public void setScoreRequiredNextLevel(Level scoreRequiredNextLevel) {
		this.scoreRequiredNextLevel = scoreRequiredNextLevel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
		
}
