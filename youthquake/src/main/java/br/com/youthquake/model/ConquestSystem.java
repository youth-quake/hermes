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
@Table(name = "tbl_conquest_system")
public class ConquestSystem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "condition", nullable = false)
	private int condition;
	
	@Column(name = "is_completed", nullable = false)
	private boolean iscompleted;
}
