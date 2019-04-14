package br.com.youthquake.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_achievement_system")
public class AchievementSystem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_achievement")
	private int  idAchievement;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "condition")
	private int condition;
	
	@Column(name = "is_completed")
	private boolean iscompleted;

	public int getIdAchievement() {
		return idAchievement;
	}

	public void setIdAchievement(int idAchievement) {
		this.idAchievement = idAchievement;
	}

	
	//Constructors
	public AchievementSystem() {
		
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public boolean isIscompleted() {
		return iscompleted;
	}

	public void setIscompleted(boolean iscompleted) {
		this.iscompleted = iscompleted;
	}
	
	
}
