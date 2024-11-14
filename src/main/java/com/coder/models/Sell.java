package com.coder.models;



import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "Sells")
public class Sell {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id; 

@ManyToOne
@JoinColumn(name = "client_id")
private Client client;

private Date saleDate;
private BigDecimal total; 
@OneToMany(mappedBy = "sell", cascade = CascadeType.ALL)
private List<SellItem> items;


public Sell(Client client, Date saleDate, List<SellItem>items) {
	this.client = client;
	this.saleDate = saleDate;
	this.items = items;
	this.total = calculateTotal();
}


public BigDecimal calculateTotal() {
    return items.stream()
                .map(SellItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public Client getClient() {
    return client;
}

public void setClient(Client client) {
    this.client = client;
}

public Date getSaleDate() {
    return saleDate;
}

public void setSaleDate(Date saleDate) {
    this.saleDate = saleDate;
}

public BigDecimal getTotal() {
    return total;
}

public void setTotal(BigDecimal total) {
    this.total = total;
}

public List<SellItem> getItems() {
    return items;
}

public void setItems(List<SellItem> items) {
    this.items = items;
    this.total = calculateTotal();  
}








}

