package com.youthquake.microservice.microservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBind;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movements {

	@JsonProperty
	@CsvBind
	private String idMovement;

	@JsonProperty
	@CsvBind
	private String value;

	@JsonProperty
	@CsvBind
	private String type;

	@JsonProperty
	@CsvBind
	private String reference;

	public Movements() {
	}

	public String getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(String idMovement) {
		this.idMovement = idMovement;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}