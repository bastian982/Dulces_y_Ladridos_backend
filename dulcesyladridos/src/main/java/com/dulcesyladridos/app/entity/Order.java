package com.dulcesyladridos.app.entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;



@Entity
@Table(name="orders")
public class Order {

	// columns section
	// ------------------------------------------------------
	@Id
	@Column(name="id_order")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	

	@Column(nullable = false)
	private Date date; //o tambien puede ser Timestamp
	// ------------------------------------------------------
	
	// Foreign key section
	// ------------------------------------------------------
	
	@ManyToOne 
	@JoinColumn(name = "id_user")
	private User user;
	@OneToOne 
	@JoinColumn(name = "id_review")
	private Review review;
	
	// ------------------------------------------------------
	
	// Setter y Getter section
	// ------------------------------------------------------

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	// ------------------------------------------------------
	
	
		
	// toString section
	// ------------------------------------------------------
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", user=");
		builder.append(user);
		builder.append(", review=");
		builder.append(review);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getDate()=");
		builder.append(getDate());
		builder.append(", getUser()=");
		builder.append(getUser());
		builder.append(", getReview()=");
		builder.append(getReview());
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
