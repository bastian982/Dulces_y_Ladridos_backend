package com.dulcesyladridos.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users_has_privileges")
public class UserHasPrivilege {
	
	@Id
	@Column(name="id_user_has_privilege")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//Foreign Key
	@Column(name="id_user")
	private Long idUser;
	@Column(name="id_privilege")
	private Long idPrivilege;
	
	

}
