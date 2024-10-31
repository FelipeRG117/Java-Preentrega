package com.coder.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "Sells")
public class Sell {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id; 
private String title;
private LocalDate dateSell; 
private String client;
private double total;
private int quantity;
private long cid;


public String getTitle() {
return title;	
}

public void setTitle(String title) {
	this.title = title;
}

public LocalDate getDateSell() {
	return dateSell;
}

public void setDateSell(LocalDate dateSell) {
	 this.dateSell = dateSell;
}


public String getClient() {
	return client;
}



public void setClient(String client) {
	this.client = client;
}

public double getTotal() {
	return total; 
}

public void setTotal(double total) {
	this.total = total;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity; 
}

public long getCid() {
	return cid; 
}

public void setCid(long cid) {
	this.cid = cid;
}

}
