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
@Table(name = "tbl_conquest_user")
public class ConquestUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod;
	
	@Column(name = "cod_user", nullable = false)
	private int codUser;
	
	@Column(name = "cod_conquest", nullable = false)
	private int codConquest;
	
	@Column(name = "dt_conquest", nullable = false)
	private String dtConquest;
}
