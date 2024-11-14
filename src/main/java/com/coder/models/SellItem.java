package com.coder.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "sell_items")
public class SellItem {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name ="sell_id")
private Sell sell;

@ManyToOne
@JoinColumn(name = "product_id")
private Product product;

private int quantity; 
private BigDecimal price; 
private BigDecimal subtotal;

public SellItem(Sell sell, Product product, int quantity) {
	this.sell = sell;
	this.product = product;
	this.quantity = quantity;
	this.price = product.getPrice();
	this.subtotal = calculateSubtotal();
}

public BigDecimal calculateSubtotal() {
	return this.price.multiply(BigDecimal.valueOf(this.quantity));
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Sell getSell() {
	return sell;
}

public void setSell(Sell sell) {
	this.sell = sell;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public BigDecimal getPrice() {
	return price;
}

public void setPrice(BigDecimal price) {
	this.price = price; 
}

public BigDecimal getSubtotal() {
	return subtotal;
}
 public void setSubtotal(BigDecimal subtotal) {
	 this.subtotal = subtotal;
 }






}
