package com.coder.models;

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
//title(nombre del producto), dateSell, client(nombre del usuario), salePrice(resultado de funcion),
//quantity, product(nombre del producto), precio, total, reference (id del usuario)
}
