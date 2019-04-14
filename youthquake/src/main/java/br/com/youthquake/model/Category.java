package br.com.youthquake.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "tbl_category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_category")
	private int idCategory;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany
	private List<Movements> movements = new ArrayList<>(); 
	
	
	//Constructors
	public Category() {
		
	}

	//Getters and Setters
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Movements> getMovements() {
		return movements;
	}

	public void setMovements(List<Movements> movements) {
		this.movements = movements;
	}
	
}
