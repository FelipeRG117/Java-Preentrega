package com.coder.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema (description = "DTO para creacion de facturas (Toma los datos de productos, los itera y forma la estructura del ticket")
public class TicketDTO {
@Schema (description = "id de ticket.")	
private Long id;
@Schema (description = "Nombre de cliente.")
private String clientName;
@Schema (description = "fecha del ticket.")
private String saleDate;
@Schema(description = "Hora del ticket.")
private String saleTime;
@Schema (description = "Total de compra.")
private BigDecimal totalAmount;
@Schema (description = "Productos elegidos.")
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

public String getSaleDate() {
	return saleDate;
}

public void setSaleDate(String newDate) {
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
