package br.com.youthquake.dto;

import java.io.Serializable;

import br.com.youthquake.model.User;

public class MovementsDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;
	
	private long idMovement;
	private User user;
	private double value;
	private String type;
	private String reference;

	public long getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(long idMovement) {
		this.idMovement = idMovement;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}
