package br.com.youthquake.dto;
import java.io.Serializable;

public class MovementsDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	private Long idMovement;
	private Long user;
	private double value;
	private String type;
	private String reference;
	
	public MovementsDTO() {}
	
	public MovementsDTO(Long idMovement, Long user, double value, String type, String reference) {
		super();
		this.idMovement = idMovement;
		this.user = user;
		this.value = value;
		this.type = type;
		this.reference = reference;
	}
	
	public Long getIdMovement() {
		return idMovement;
	}
	public void setIdMovement(Long idMovement) {
		this.idMovement = idMovement;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
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

	@Override
	public String toString() {
		return "MovementsDTO [idMovement=" + idMovement + ", user=" + user + ", value=" + value + ", type=" + type
				+ ", reference=" + reference + "]";
	}
	
}
