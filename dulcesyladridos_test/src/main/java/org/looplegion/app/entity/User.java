package org.looplegion.app.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	
	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name", length = 45)
	private String firstName;
	
	@Column(name="last_name", length = 45)
	private String lastName;
	
	@Column(name="telephone_number", length = 20)
	private String telephoneNumber;
	
	@Column(unique = true, length = 45, nullable = false)
	private String email;

	@Column(name="password", length = 100)
	private String password;
	
	@Column(name="birth_date", columnDefinition = "DATE")
	private Date birthDate;

	@Column(name="is_active", columnDefinition = "TINYINT")
	private Boolean active;
	


	// Foreign key section
	// ------------------------------------------------------
		@ManyToOne
		@JoinColumn(name= "id_privilege")
		private Privilege privilege;

	// ------------------------------------------------------
		
	// Setter y Getter section
	// ------------------------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	// ------------------------------------------------------

	

	

	// toString section
	// ------------------------------------------------------
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", telephoneNumber=");
		builder.append(telephoneNumber);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", active=");
		builder.append(active);
		builder.append(", privilege=");
		builder.append(privilege);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getFirstName()=");
		builder.append(getFirstName());
		builder.append(", getLastName()=");
		builder.append(getLastName());
		builder.append(", getTelephoneNumber()=");
		builder.append(getTelephoneNumber());
		builder.append(", getEmail()=");
		builder.append(getEmail());
		builder.append(", getPassword()=");
		builder.append(getPassword());
		builder.append(", getBirthDate()=");
		builder.append(getBirthDate());
		builder.append(", getPrivilege()=");
		builder.append(getPrivilege());
		builder.append(", getActive()=");
		builder.append(getActive());
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
