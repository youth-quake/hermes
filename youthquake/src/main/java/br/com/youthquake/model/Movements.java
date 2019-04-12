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
@Table(name = "tbl_moviments")
public class Movements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod;
	
	@Column(name = "cod_user", nullable = false)
	private int codUser;
	
	@Column(name = "cod_category", nullable = false)
	private int codCategory;
	
	@Column(name = "value", nullable = false)
	private double value;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "reference", nullable = false)
	private String reference;
}
