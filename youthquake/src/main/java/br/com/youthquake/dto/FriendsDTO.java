package br.com.youthquake.dto;

import java.io.Serializable;

import br.com.youthquake.model.User;

public class FriendsDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;
	
	private int idFriends;
	private User user1;
	private User user2;
	
	public FriendsDTO() {}

	public FriendsDTO(int idFriends, User user1, User user2) {
		super();
		this.idFriends = idFriends;
		this.user1 = user1;
		this.user2 = user2;
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

	@Override
	public String toString() {
		return "FriendsDTO [idFriends=" + idFriends + ", user1=" + user1 + ", user2=" + user2 + "]";
	}
	
	
	
}
