package br.com.youthquake.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_action_system")
public class ActionSystem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_action")
	private int idAction;

	@Column(name = "name")
	private String name;

	@Column(name = "number_required")
	private int numberRequired;

	public int getIdAction() {
		return idAction;
	}

	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberRequired() {
		return numberRequired;
	}

	public void setNumberRequired(int numberRequired) {
		this.numberRequired = numberRequired;
	}

	
}
