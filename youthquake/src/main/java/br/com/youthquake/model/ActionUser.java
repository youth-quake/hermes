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
	private String quantity;

	@Column(name = "progress")
	private String progress;
}
