package br.com.youthquake.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_couple")
public class Couple {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_couple")
	private int idCouple;

	@ManyToOne
	@JoinColumn(name="id_user_1")
	private User user1;
	
	
	@ManyToOne
	@JoinColumn(name="id_user_2")
	private User user2;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany
	private List<Bet> bets = new ArrayList<>();

	
	//Constructors
	public Couple() {
		
	}
	
	//Getters and Setters
	public int getIdCouple() {
		return idCouple;
	}

	public void setIdCouple(int idCouple) {
		this.idCouple = idCouple;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
	
}
