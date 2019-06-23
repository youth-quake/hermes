package br.com.youthquake.dto;

import java.io.Serializable;


public class BetDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private Long idBet;
	private Long idFriends;
	private Long idUser1;
	private Long idUser2;
	private String description;
	private double value;
	private String name;
	private String time;
	private String result;
	
	public BetDTO() {}

	public Long getIdFriends() {
		return idFriends;
	}

	public void setIdFriends(Long idFriends) {
		this.idFriends = idFriends;
	}

	public String getDescription() {
		return description;
	}
	
	
	
	public Long getIdUser1() {
		return idUser1;
	}

	public void setIdUser1(Long idUser1) {
		this.idUser1 = idUser1;
	}

	public Long getIdUser2() {
		return idUser2;
	}

	public void setIdUer2(Long idUser2) {
		this.idUser2 = idUser2;
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

	@Override
	public String toString() {
		return "BetDTO [idFriends=" + idFriends + ", description=" + description + ", value=" + value + ", name=" + name
				+ ", time=" + time + ", result=" + result + "]";
	}

	public Long getIdBet() {
		return idBet;
	}

	public void setIdBet(Long idBet) {
		this.idBet = idBet;
	}
	
	
	
}
