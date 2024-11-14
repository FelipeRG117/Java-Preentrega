package com.coder.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class TicketDTO {
private Long id;
private String clientName;
private Date saleDate;
private BigDecimal totalAmount;
private List<TicketItemDTO> items;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getClientName() {
	return clientName;
}

public void setClientName(String name) {
	this.clientName = name;
}

public Date getSaleDate() {
	return saleDate;
}

public void setSaleDate(Date newDate) {
	this.saleDate = newDate;
}

public BigDecimal getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(BigDecimal newAmount) {

	this.totalAmount = newAmount;
}

public List<TicketItemDTO> getItems(){
	return items;
}

public void setItems(List<TicketItemDTO> newItems) {
	this.items = newItems;
}


}
