package br.com.youthquake.model;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.youthquake.dto.MovementsDTO;

@Entity
@Component
@Table(name = "tbl_moviments")
public class Movements implements Serializable{

	private static final long serialVersionUID = -6888542263201514002L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_movement")
	private Long idMovement;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "id_user")
	private User user;

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
	
	public Long getIdMovement() {
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
	
	public void movementUpdateInformation(MovementsDTO dto){
		this.setReference(dto.getReference());
		this.setType(dto.getType());
		this.setValue(dto.getValue());
	}
}
