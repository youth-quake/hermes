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
@Table(name = "tbl_bet")
public class Bet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod;
	
	@Column(name = "cod_couple", nullable = false)
	private int codCouple;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "value", nullable = false)
	private double value;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "time", nullable = false)
	private String time;
	
	@Column(name = "result", nullable = false)
	private String result;
}
