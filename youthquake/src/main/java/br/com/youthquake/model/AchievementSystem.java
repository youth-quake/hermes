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
	private int idAchievement;

	@Column(name = "name")
	private String name;

	@Column(name = "number_required")
	private int numberRequired;

	@Column(name = "description")
	private String description;

	public int getIdAchievement() {
		return idAchievement;
	}

	public void setIdAchievement(int idAchievement) {
		this.idAchievement = idAchievement;
	}

	// Constructors
	public AchievementSystem() {

	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberRequired() {
		return numberRequired;
	}

	public void setNumberRequired(int numberRequired) {
		this.numberRequired = numberRequired;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
