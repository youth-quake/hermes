package br.com.youthquake.dto;

import java.io.Serializable;

public class TargetDTO implements Serializable{
	private static final long serialVersionUID = -6888542263201514002L;
	
	private long idTarget;
	private Long user;
	private String name;
	private String description;
	private String dtStart;
	private String dtEnd;
	private double value;
	private double valueAccumulated;
	private double percentage;

	public long getIdTarget() {
		return idTarget;
	}

	public void setIdTarget(long idTarget) {
		this.idTarget = idTarget;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValueAccumulated() {
		return valueAccumulated;
	}

	public void setValueAccumulated(double valueAccumulated) {
		this.valueAccumulated = valueAccumulated;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
}
