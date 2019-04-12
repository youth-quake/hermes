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
	private int cod;
	
	@Column(name = "number_level", nullable = false)
	private int numberLevel;		
	
	@Column(name = "score_required", nullable = false)
	private int scoreRequired;
	
	@Column(name = "achievement", nullable = false)
	private String achievement;
}
