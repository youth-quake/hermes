package br.com.youthquake.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_moviments")
public class Movements {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_movement")
	private int idMovement;

	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	@OneToOne
	@JoinColumn(name = "id_category")
	private Category category;

	@Column(name = "value")
	private double value;

	@Column(name = "type")
	private String type;

	@Column(name = "reference")
	private String reference;

	// Constructors
	public Movements() {
	}

	// Getters and Setters
	public int getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(int idMovement) {
		this.idMovement = idMovement;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
