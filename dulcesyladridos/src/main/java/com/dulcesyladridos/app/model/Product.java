package com.dulcesyladridos.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name="id_products")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
//	@Column(name="name")
	private String name;
	@Column(name="dogo_name", unique= true)
	private String dogoName;
//	@Column(name="description")
	private String description;
//	@Column(name="price")
	private Double price;
//	@Column(name="quantity")
	private Integer quantity;
	@Column(name="image_URL")
	private String imageUrl;
	@Column(name="id_category_product")
	private String  categoryProduct;
	
	
	
	
	

}
