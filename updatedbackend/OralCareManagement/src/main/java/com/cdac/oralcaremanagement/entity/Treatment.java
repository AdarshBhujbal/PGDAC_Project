package com.cdac.oralcaremanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "treatment_table")
public class Treatment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_Id", nullable = false)
	private long tId;

	@Column(name = "t_name")
	private String name;

	@Column(name = "t_desc")
	private String description;

	@Column(name = "rate")
	private int price;

	public Treatment() {
		// TODO Auto-generated constructor stub
	}

	public Treatment(long tId, String name, String description, int price) {
		super();
		this.tId = tId;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Treatment [tId=" + tId + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}

}
