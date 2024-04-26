package com.dulcesyladridos.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="privilages")
public class Privilege {
	
	@Id
	@Column(name = "id_privilege")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String privilage;
}
