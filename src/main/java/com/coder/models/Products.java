package com.coder.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Products")
public class Products {
//title, description price, brand
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column
private String title;
@Column
private String description; 
@Column(nullable = false)
private int price;
@Column(nullable= false)
private String brand; 

	

	
}
