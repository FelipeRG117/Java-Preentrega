package com.coder.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

//firstName, lastName, age, email, doc, num 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(nullable = false)
private String name;
@Column
private int age; 
@Column(nullable = false, unique = true)

private String email; 
@Column(nullable= false)
private String ine;
//Constructor vacio para Spring
public Client() {
	
}
//contructor para ejecucion
public Client(String name, int age, String email, String ine) {
	this.name = name;
	this.age = age;
	this.email = email;
	this.ine = ine;
	
}

//setear y traer el nombre, edad, traer el email y el ine y se etear el ine 

public String getName() {
	return name;
}

public void setName(String Name) {
this.name = Name;

}


public int getAge() {
	return age;
}

//getID
public long getId() {
	return id;
}

//setId 
public void setId(Long id) {
	this.id = id;
}
//getCorreo
public String getEmail() {
	return email;
}
//cambiar correo 
public void setEmail(String email) {
  this.email = email; 
}
public String getIne() {
	return ine;
}

public void setIne(String ine) {
	this.ine = ine;
}






}
