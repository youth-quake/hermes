
package br.com.youthquake.model;

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
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Component
@Table(name = "tbl_friends")
@JsonIgnoreProperties("user1.movements")
public class Friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_friends")
	private Long idFriends;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_user_1")
	private User user1;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_user_2")
	private User user2;
	
	@OneToMany(mappedBy = "idFriends")
	private List<Bet> bets;

	
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

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
	
	
}
