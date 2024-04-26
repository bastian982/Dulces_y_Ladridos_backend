package com.dulcesyladridos.app.entity;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
	@Table(name="reviews")
	public class Review {
		
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id_review")
		private Long id;
		@Column(name = "content")
		private String content;
		@Column(name = "rating")
		private Integer rating;
		@Column(name = "date")
		private Date date;
		@Column(name = "validation")
		private Boolean validation;
		@Column(name = "id_user")
		private Long idUser;
		
		protected Review() {}

		  public Review(String content, Integer ratinge, Long idUser) {
		    this.content = content;
		    this.rating = ratinge;
		    this.idUser = idUser;
		  }

		public Long getId() {
			return id;
		}

		public String getContent() {
			return content;
		}

		public Integer getRating() {
			return rating;
		}

		public Date getDate() {
			return date;
		}

		public Boolean getValidation() {
			return validation;
		}

		public Long getIdUser() {
			return idUser;
		}
		  
		  
	}

