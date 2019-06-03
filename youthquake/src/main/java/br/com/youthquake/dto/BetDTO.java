package br.com.youthquake.dto;

import java.io.Serializable;


public class BetDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private int idBet;
	private Long idFriends;
	private Long idUer1;
	private Long idUer2;
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
	
	
	
	public Long getIdUer1() {
		return idUer1;
	}

	public void setIdUer1(Long idUer1) {
		this.idUer1 = idUer1;
	}

	public Long getIdUer2() {
		return idUer2;
	}

	public void setIdUer2(Long idUer2) {
		this.idUer2 = idUer2;
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
