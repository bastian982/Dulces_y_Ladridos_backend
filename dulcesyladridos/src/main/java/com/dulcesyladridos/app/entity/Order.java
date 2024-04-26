package com.dulcesyladridos.app.entity;

import jakarta.persistence.*;
@Entity
@Table(name="orders_has_products")
public class Order {

	@Id
	@Column(name="id_order_has_products")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	
	// Foreign key
	
	private Order id_order;
	private Product id_product;


}