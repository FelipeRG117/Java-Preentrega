package com.coder.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Schema (description = "Modelo de CLiente.")
@Table(name = "clients")
public class Client {

//firstName, lastName, age, email, doc, num 
@Schema (description = "id de cliente.")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Schema (description = "Nombre de cliente.")
@Column(nullable = false)
private String name;
@Schema (description = "Edad de cliente.")
@Column
private int age; 
@Schema (description = "Email de cliente.")
@Column(nullable = false, unique = true)

private String email; 
@Schema (description = "Documento unico de cliente.")
@Column(nullable= false)
private String ine;

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

public void setAge(int age) {
	this.age = age;
}

public int getAge() {
	return age;
}

//getID
public Long getId() {
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
