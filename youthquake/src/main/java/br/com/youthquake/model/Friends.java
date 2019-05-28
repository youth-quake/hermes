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
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_friends")
public class Friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_friends")
	private Long idFriends;

	@ManyToOne
	@JoinColumn(name="id_user_1")
	private User user1;
	
	
	@ManyToOne
	@JoinColumn(name="id_user_2")
	private User user2;
	
	@OneToMany
	private List<Bet> bets = new ArrayList<>();

	
	//Constructors
	public Friends() {
		
	}

	public Friends(Long idFriends, User user1, User user2) {
		super();
		this.idFriends = idFriends;
		this.user1 = user1;
		this.user2 = user2;
	}


	public Long getIdFriends() {
		return idFriends;
	}


	public void setIdFriends(Long idFriends) {
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
}
