package org.looplegion.app.entity;

import java.sql.Date;
import jakarta.persistence.*;

	@Entity
	@Table(name="reviews")
	public class Review {
		
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id_review")
		private Long id;
		
		@Column(name = "content", length = 150)
		private String content;
		
		@Column(name = "rating", columnDefinition = "INT", nullable = false )
		private Integer rating;
		
		@Column(name = "date" , columnDefinition = "DATE", nullable = false )
		private Date date;
		
		@Column(name = "validation", columnDefinition = "TINYINT", nullable = false )
		private Boolean validation;
		
		// Foreign key section
		// ------------------------------------------------------
		@ManyToOne 
		@JoinColumn(name = "id_user")
		private User user;	
		// ------------------------------------------------------

		// Setter y Getter section
		// ------------------------------------------------------
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Boolean getValidation() {
			return validation;
		}

		public void setValidation(Boolean validation) {
			this.validation = validation;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}	
		
		// ------------------------------------------------------

			
		// toString section
		// ------------------------------------------------------
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Review [id=");
			builder.append(id);
			builder.append(", content=");
			builder.append(content);
			builder.append(", rating=");
			builder.append(rating);
			builder.append(", date=");
			builder.append(date);
			builder.append(", validation=");
			builder.append(validation);
			builder.append(", user=");
			builder.append(user);
			builder.append(", getId()=");
			builder.append(getId());
			builder.append(", getContent()=");
			builder.append(getContent());
			builder.append(", getRating()=");
			builder.append(getRating());
			builder.append(", getDate()=");
			builder.append(getDate());
			builder.append(", getValidation()=");
			builder.append(getValidation());
			builder.append(", getUser()=");
			builder.append(getUser());
			builder.append(", getClass()=");
			builder.append(getClass());
			builder.append(", hashCode()=");
			builder.append(hashCode());
			builder.append(", toString()=");
			builder.append(super.toString());
			builder.append("]");
			return builder.toString();
		}
		// ------------------------------------------------------

	
		  
	}

