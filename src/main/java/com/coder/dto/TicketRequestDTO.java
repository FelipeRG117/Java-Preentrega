package com.coder.dto;

import java.util.List;

public class TicketRequestDTO {
private List<TicketItemDTO>items;
private String dateTime;

public List<TicketItemDTO> getItems(){
	return items;
}

public void setItems(List<TicketItemDTO> newItems) {
	this.items = newItems;
}

public String getDateTime() {
	return dateTime;
}

public void setDateTime(String newDateTime) {
	this.dateTime = newDateTime;
}

}
