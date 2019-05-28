package br.com.youthquake.dto;

import java.io.Serializable;


public class FriendsDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;
	
	private Long idFriends;
	private Long user1;
	private Long user2;
	
	public FriendsDTO() {}

	public FriendsDTO(Long idFriends, Long user1, Long user2) {
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
	public Long getUser1() {
		return user1;
	}
	public void setUser1(Long user1) {
		this.user1 = user1;
	}
	public Long getUser2() {
		return user2;
	}
	public void setUser2(Long user2) {
		this.user2 = user2;
	}

	@Override
	public String toString() {
		return "FriendsDTO [idFriends=" + idFriends + ", user1=" + user1 + ", user2=" + user2 + "]";
	}
	
	
	
}
