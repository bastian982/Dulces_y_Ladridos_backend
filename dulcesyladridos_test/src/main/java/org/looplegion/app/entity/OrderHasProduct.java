package org.looplegion.app.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
@Entity
@Table(name="orders_has_products")
public class OrderHasProduct {

    @EmbeddedId
    private OrderHasProductId id;

    @Column(name = "products_in_cart", nullable = false)
    private Integer amount;

    // Constructor vacío
    public OrderHasProduct() {}

    // Constructor con parámetros
    public OrderHasProduct(OrderHasProductId id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    // Getters y setters
    public OrderHasProductId getId() {
        return id;
    }

    public void setId(OrderHasProductId id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderHasProduct [id=");
		builder.append(id);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getAmount()=");
		builder.append(getAmount());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

    // llave compuesta
}

@Embeddable
class OrderHasProductId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    // Constructor vacío
    public OrderHasProductId() {}

    // Constructor con parámetros
    public OrderHasProductId(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    // Getters y setters
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

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderHasProductId that = (OrderHasProductId) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}


