package com.dulcesyladridos.app.entity;

import jakarta.persistence.*;
@Entity
@Table(name="orders_has_products")
public class OrderHasProduct {

	/* no tiene llave primaria es una tabla compuesta
	@Id
	@Column(name="id_order_has_products")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	*/
	
	@Column(name = "product_in_cart", nullable = false, columnDefinition = "INT" )
	private Integer amount;
	
	// ------------------------------------------------------
	
	// Foreign key section
	// ------------------------------------------------------
	/*
	 * Relaciones entre Entidades: JPA permite definir relaciones 
	 * entre entidades, como relaciones uno a uno, uno a muchos 
	 * y muchos a muchos. Estas relaciones se pueden configurar
	 *  usando anotaciones como @OneToOne, @OneToMany, @ManyToOne y @ManyToMany. 
	 */
	@ManyToOne 
	@JoinColumn(name = "id_oder")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	// ------------------------------------------------------
	
	// Setter y Getter section
	// ------------------------------------------------------
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	// ------------------------------------------------------
	
	// toString section
	// ------------------------------------------------------
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHasProduct [amount=");
		builder.append(amount);
		builder.append(", order=");
		builder.append(order);
		builder.append(", product=");
		builder.append(product);
		builder.append(", getAmount()=");
		builder.append(getAmount());
		builder.append(", getOrder()=");
		builder.append(getOrder());
		builder.append(", getProduct()=");
		builder.append(getProduct());
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