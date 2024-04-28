package org.looplegion.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="privileges")
public class Privilege {
	
	@Id
	@Column(name = "id_privilege")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "privilege",length=45, nullable = false)
	private String privilage;


	
	// Foreign key section
	// ------------------------------------------------------
		
	// ------------------------------------------------------
	
	// Setter y Getter section
	// ------------------------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrivilage() {
		return privilage;
	}

	public void setPrivilage(String privilage) {
		this.privilage = privilage;
	}
	// ------------------------------------------------------

	
	// toString section
	// ------------------------------------------------------
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Privilege [id=");
		builder.append(id);
		builder.append(", privilage=");
		builder.append(privilage);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getPrivilage()=");
		builder.append(getPrivilage());
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