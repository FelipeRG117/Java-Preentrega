package com.coder.dto;



public class TimeResponseDTO {
private String dateTime;
private String timeZone;
private String date; 
private String abbrevation;

public String getDateTime() {
	return dateTime;
}
public void setDateTime(String newDateTime) {
	this.dateTime = newDateTime;
}

public String getTimeZone() {
	return timeZone;
}
public void setTimeZone(String newTimeZone) {
	this.timeZone = newTimeZone;
}

public String getDate() {
	return date;
}
public void setDate(String newDate) {
	this.date =  newDate;
}

public String getAbbrevation() {
	return abbrevation;
}
public void setAbbrevation(String newAbbrevation) {
	this.abbrevation = newAbbrevation;
}




}
