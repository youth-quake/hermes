package br.com.youthquake.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name = "tbl_action_user")
public class ActionUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_achievement_user")
	private int idActionUser;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_user")
	private User user;

	@OneToOne
	@JoinColumn(name = "id_achievement")
	private ActionSystem idActionSystem;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "progress")
	private int progress;

	
	public ActionUser() {}
	
	public int getIdActionUser() {
		return idActionUser;
	}

	public void setIdActionUser(int idActionUser) {
		this.idActionUser = idActionUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ActionSystem getIdActionSystem() {
		return idActionSystem;
	}

	public void setIdActionSystem(ActionSystem idActionSystem) {
		this.idActionSystem = idActionSystem;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	
}
