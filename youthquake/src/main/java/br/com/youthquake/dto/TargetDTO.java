package br.com.youthquake.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import br.com.youthquake.model.User;

public class TargetDTO implements Serializable{

	private static final long serialVersionUID = -6888542263201514002L;
	
	private long idTarget;
	private User user;
	private String name;
	private String description;
	private String dtStart;
	private String dtEnd;
	private int value;
	private int valueAccumulated;
	private int percentage;

	public long getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(long idTarget) {
		this.idTarget = idTarget;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
}
