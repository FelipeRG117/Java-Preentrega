package com.coder.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema (description = "DTO para creacion de facturas (Toma los datos del producto y sus detalles")
public class TicketItemDTO {
	@Schema (description = "id de producto.")
	private Long productId;
	@Schema (description = "nombre de producto.")
	private String productName;
	@Schema (description = "cantidad de producto.")
	private int quantity;
	@Schema (description = "precio de producto.")
	private BigDecimal price;
	@Schema (description = "total de producto/s.")
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
