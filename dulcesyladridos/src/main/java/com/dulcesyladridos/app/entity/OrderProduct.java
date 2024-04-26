package com.dulcesyladridos.app.entity;

import java.sql.Date;

import jakarta.persistence.*;



@Entity
@Table(name="orders")
public class OrderProduct {

	@Id
	@Column(name="id_order")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date date;
	
	
	// Foreign key
	private Long id_user;
	private Long id_review;
}
