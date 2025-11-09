package com.singularix.restfulws.product;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="product_details")
public class Product {
	private Integer id;
	
	private String name;
	
	@Positive
	private Double price;
	
	@Size(min=50)
	private String description;
	
	private String manufacturer;
	
	protected Product () {
		
	}
	

	public Product(Integer id, String name, @Positive Double price, @Size(min = 50) String description,
			String manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.manufacturer = manufacturer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	

}
	