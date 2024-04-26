package com.dulcesyladridos.app.model;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post {

	@Id
	@Column(name="id_post")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String title;
	private String description;
	private String content;
	private Date date;
	//Foreign key
	@Column(name="id_user")
	private Long idUser;
	@Column(name="id_category_post")
	private Long idCategoryPost;
	
	
}
