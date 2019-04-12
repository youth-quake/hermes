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
@Table(name = "tbl_moviments")
public class ScoreUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod;
	
	@Column(name = "cod_user", nullable = false)
	private int codUser;
	
	@Column(name = "score", nullable = false)
	private int score;
	
	@Column(name = "cod_current_level", nullable = false)
	private int codCurrentLevel;
	
	@Column(name = "cod_next_level", nullable = false)
	private int codNextLevel;
}
