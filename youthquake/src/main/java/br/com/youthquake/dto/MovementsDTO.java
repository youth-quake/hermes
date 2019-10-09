package br.com.youthquake.dto;
import java.io.Serializable;	
import br.com.youthquake.model.User;

public class MovementsDTO implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;
	
	private long idMovement;
	private Long user;
	private Double value;
	private String type;
	private String reference;
	private String dateMovement;
	private String descriptionMovement;

	public MovementsDTO() {}

	public MovementsDTO(Long idMovement, Long user, double value, String type, String reference) {
		super();
		this.idMovement = idMovement;
		this.user = user;
		this.value = value;
		this.type = type;
		this.reference = reference;
	}
	
	public long getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(long idMovement) {
		this.idMovement = idMovement;
	}


	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
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
	
	public String getDateMovement() {
		return dateMovement;
	}
	
	public void setDateMovement(String dateMovement) {
		this.dateMovement = dateMovement;
	}
	
	public String getDescriptionMovement() {
		return descriptionMovement;
	}
	
	public void setDescriptionMovement(String descriptionMovement) {
		this.descriptionMovement = descriptionMovement;
	}
	
	@Override
	public String toString() {
		return "MovementsDTO [idMovement=" + idMovement + ", user=" + user + ", value=" + value + ", type=" + type
				+ ", reference=" + reference + "]";
	}
}
