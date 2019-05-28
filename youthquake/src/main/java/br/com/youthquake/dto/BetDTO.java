package br.com.youthquake.dto;

import java.io.Serializable;


public class BetDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private int idBet;
	private Long idFriends;
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

	public int getIdBet() {
		return idBet;
	}

	public void setIdBet(int idBet) {
		this.idBet = idBet;
	}
	
	
	
}
