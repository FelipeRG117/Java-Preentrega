package com.coder.models;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Schema (description = "Modelo de product.")
@Table(name= "Products")
public class Product {
//title, description price, brand
@Schema (description = "id product.")	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Schema (description = "title product.")
@Column
private String title;
@Schema (description = "description product.")
@Column
private String description;
@Schema (description = "price product.")
@Column(nullable = false)
private BigDecimal price;
@Schema (description = "brand product.")
@Column(nullable= false)
private String brand; 
@Schema (description = "stock de product.")
@Column
private  int stock;


public Product() {
	
}

public Product(String title, String description, BigDecimal price, String brand, int stock) {
this.title = title;
this.description = description;
this.price = price;
this.brand = brand; 
this.stock = stock;
}


	//getters y setters 
public String getTitle() {
	return title;
}
	
public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return this.description; 
}

public void setDescription(String description) {
	this.description = description;
}

public BigDecimal getPrice() {
	return this.price;
}

public void setPrice(BigDecimal price) {
	this.price = price; 
	
}

public String getBrand() {
	return this.brand;
}


public void setBrand(String brand) {
	this.brand = brand; 
}


public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}




}
