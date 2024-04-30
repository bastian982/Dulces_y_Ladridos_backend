package org.looplegion.app.repository;
import java.util.Optional;
import org.looplegion.app.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository< User , Long > {
	
	/**
	 * La clase Optional se introdujo en Java 8 para representar
	 * un valor que puede ser presente o ausente(null).
	 * Evita el manejo de valores nulos directamente.
	 * 
	 */
	// SELECT * FROM users WHERE email = ?1
	Optional<User> findByEmail(String email);
	 // SELECT * FROM users WHERE  firstName = ?1
	Optional<User> findByFirstName(String firstName);
	// SELECT * FROM users WHERE lastName = ?1
	Optional<User> findByLastName(String lastName); 
	

}