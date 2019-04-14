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
@Table(name = "tbl_level")
public class Level {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_level")
	private int idLevel;
	
	@Column(name = "number_level")
	private int numberLevel;		
	
	@Column(name = "score_required")
	private int scoreRequired;
	
	@Column(name = "title")
	private String title;
	
	//Constructors
	public Level() {
		
	}

	//Getters and Setters
	public int getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(int idLevel) {
		this.idLevel = idLevel;
	}

	public int getNumberLevel() {
		return numberLevel;
	}

	public void setNumberLevel(int numberLevel) {
		this.numberLevel = numberLevel;
	}

	public int getScoreRequired() {
		return scoreRequired;
	}

	public void setScoreRequired(int scoreRequired) {
		this.scoreRequired = scoreRequired;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
