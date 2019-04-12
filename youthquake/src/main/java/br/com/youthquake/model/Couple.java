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
@Table(name = "tbl_couple")
public class Couple {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "codUser_1", nullable = false)
	private int codUser1;
	
	@Column(name = "codUser_2", nullable = false)
	private int codUser2;
}
