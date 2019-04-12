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
@Table(name = "tbl_goal")
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cod;
	
	
	@Column(name = "cod_user", nullable = false)
	private int codUser;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "dt_start", nullable = false)
	private String dtStart;
	
	@Column(name = "dt_end", nullable = false)
	private String dtEnd;
	
	@Column(name = "value", nullable = false)
	private int value;
	
	@Column(name = "value_accumulated", nullable = false)
	private int valueAccumulated;
	
	@Column(name = "percentage", nullable = false)
	private int percentage;
}
