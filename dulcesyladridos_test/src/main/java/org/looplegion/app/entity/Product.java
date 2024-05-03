package org.looplegion.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name="id_products")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name", length = 45, nullable = false)
	private String name;
	@Column(name="dogo_name",length = 45 ,unique= true)
	private String dogoName;
	@Column(name="description", length = 100)
	private String description;
	@Column(name="price",columnDefinition = "DECIMAL(9,2)",nullable = false )
	private Double price;
	@Column(name="quantity", columnDefinition = "INT", nullable = false )
	private Integer quantity;
	@Column(name="image_URL", length = 200, nullable = false)
	private String imageUrl;
	
	public Product() {
	
	}
	// Foreign key section
	// ------------------------------------------------------
	@ManyToOne 
	@JoinColumn(name = "id_category_product")
	private ProductCategory productCategory;
	// ------------------------------------------------------
		
	
	// Setter y Getter section
	// ------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDogoName() {
		return dogoName;
	}

	public void setDogoName(String dogoName) {
		this.dogoName = dogoName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public ProductCategory getProductcategory() {
		return productCategory;
	}
	
	public void setProductcategory(ProductCategory productcategory) {
		this.productCategory = productcategory;
	}
	// ------------------------------------------------------

	// toString section
	// ------------------------------------------------------

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", dogoName=");
		builder.append(dogoName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", productcategory=");
		builder.append(productCategory);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append(", getDogoName()=");
		builder.append(getDogoName());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getPrice()=");
		builder.append(getPrice());
		builder.append(", getQuantity()=");
		builder.append(getQuantity());
		builder.append(", getImageUrl()=");
		builder.append(getImageUrl());
		builder.append(", getProductcategory()=");
		builder.append(getProductcategory());
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
