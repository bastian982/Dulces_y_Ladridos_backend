package org.looplegion.app.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
public class Post {

	@Id
	@Column(name="id_post")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title", nullable = false ,  length = 45, unique = true)
	private String title;
	
	@Column(name = "description", nullable = false, columnDefinition = "TEXT" )
	private String description;

	@Column(name = "content", nullable = false, columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "date",nullable = false,columnDefinition = "DATE")
	private Date date;
	
	
	// Foreign key section
	// ------------------------------------------------------
	
	@ManyToOne 
	@JoinColumn(name = "id_category_post", nullable = false)
	private PostCategory postcategory;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public PostCategory getPostcategory() {
		return postcategory;
	}
	public void setPostcategory(PostCategory postcategory) {
		this.postcategory = postcategory;
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
		builder.append("Post [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", content=");
		builder.append(content);
		builder.append(", date=");
		builder.append(date);
		builder.append(", postcategory=");
		builder.append(postcategory);
		builder.append(", user=");
		builder.append(user);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getTitle()=");
		builder.append(getTitle());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getContent()=");
		builder.append(getContent());
		builder.append(", getDate()=");
		builder.append(getDate());
		builder.append(", getPostcategory()=");
		builder.append(getPostcategory());
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
