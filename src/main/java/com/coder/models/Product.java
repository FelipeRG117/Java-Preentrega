package com.coder.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Products")
public class Product {
//title, description price, brand
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column
private String title;
@Column
private String description; 
@Column(nullable = false)
private BigDecimal price;
@Column(nullable= false)
private String brand; 
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
