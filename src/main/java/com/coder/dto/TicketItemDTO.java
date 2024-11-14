package com.coder.dto;

import java.math.BigDecimal;

public class TicketItemDTO {
	private Long productId;
	private String productName;
	private int quantity;
	private BigDecimal price;
	private BigDecimal subtotal;
	

	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
public String getProductName() {
	return productName;
}

public void setProductName(String newName) {
	this.productName = newName;
}

public int getQuantity() {
 return quantity;	
}

public void setQuantity(int newQuantity) {
	this.quantity = newQuantity;
}

public BigDecimal getPrice() {
	return price;
}

public void setPrice(BigDecimal newPrice) {
	this.price = newPrice; 
}

public BigDecimal getSubtotal() {
	return subtotal;
}

public void setSubtotal(BigDecimal newSubtotal) {
	this.subtotal = newSubtotal; 
}


}
