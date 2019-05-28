package br.com.youthquake.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Component
@Table(name = "tbl_friends")
public class Friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_friends")
	private int idFriends;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_user_1")
	@JsonDeserialize(as = User.class)
	@JsonIgnore
	private User user1;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_user_2")
	@JsonDeserialize(as = User.class)
	private User user2;
	
	@OneToMany(mappedBy="idFriends")
	private List<Bet> bets = new ArrayList<>();

	
	//Constructors
	public Friends() {
		
	}


	public int getIdFriends() {
		return idFriends;
	}


	public void setIdFriends(int idFriends) {
		this.idFriends = idFriends;
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


	public List<Bet> getBets() {
		return bets;
	}


	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
}
