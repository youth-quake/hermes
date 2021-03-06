package br.com.youthquake.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.youthquake.dto.BetDTO;

@Entity
@Component
@Table(name = "tbl_bet")
public class Bet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_bet")
	private Long idBet;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_friends")
	@JsonIgnore
	private Friends idFriends;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "value")
	private double value;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "result")
	private String result;

	
	//Constructors
	public Bet() {
		
	}

	//Getters and Setters
	public Long getIdBet() {
		return idBet;
	}

	public void setIdBet(Long idBet) {
		this.idBet = idBet;
	}
	
	
	public void setIdFriends(Friends idFriends) {
		this.idFriends = idFriends;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void updateBet(BetDTO dto) {
		this.setResult(dto.getResult());
	}
}
