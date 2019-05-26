package br.com.youthquake.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.youthquake.dto.TargetDTO;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Component
@Table(name = "tbl_target")
public class Target implements Serializable {
	
	private static final long serialVersionUID = -6888542263201514002L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_target")
	private long idTarget;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dt_start")
	private String dtStart;
	
	@Column(name = "dt_end")
	private String dtEnd;
	
	@Column(name = "value")
	private int value;
	
	@Column(name = "value_accumulated")
	private int valueAccumulated;
	
	@Column(name = "percentage")
	private int percentage;
	
	//Constructors
	public Target() {
		
	}

	//Getters and Setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDtStart() {
		return dtStart;
	}

	public void setDtStart(String dtStart) {
		this.dtStart = dtStart;
	}

	public String getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd(String dtEnd) {
		this.dtEnd = dtEnd;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValueAccumulated() {
		return valueAccumulated;
	}

	public void setValueAccumulated(int valueAccumulated) {
		this.valueAccumulated = valueAccumulated;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public User getUsers() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}
	
	public void targetUpdateInformations(TargetDTO dto){
		this.setDescription(dto.getDescription());
		this.setDtStart(dto.getDtStart());
		this.setDtEnd(dto.getDtEnd());
		this.setName(dto.getName());
		this.setValue(dto.getValue());
		this.setValueAccumulated(dto.getValueAccumulated());
	}
}
