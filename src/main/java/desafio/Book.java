package desafio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
  @Id 
   private Long sku;
   private String name;
   private String brand;
   private BigDecimal price;
   
   public Book (Long sku) {
	   this.sku = sku;
   }
   
   protected Book() {
	   
   }
   public Book(Long sku, String name, String brand, BigDecimal price) {
	this.sku = sku;
	this.name = name;
	this.brand = brand;
	this.price = price;
}

public Long getSku() {
	return sku;
}

public void setSku(Long sku) {
	this.sku = sku;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
   
   
}
