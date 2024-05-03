package org.looplegion.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.looplegion.app.entity.User;
import org.looplegion.app.service.UserService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 *  Request Param
	 *  Vincula los parámetros de una solicitud HTTP con los
	 *  parámetros del método.
	 *  Permite extraer los valores de los parámetros de 
	 *  la consulta (query parameters).
	 *  Si no se proporciona los valores, se genera la excepción
	 *  MissingServletRequestParametersException
	 *  
	 *  En el sig. ejemplo manejaremos la url como:
	 *  
	 *  localhost:8080/api/v1/users?active=true  Todos los usuarios activos
	 *  localhost:8080/api/v1/users
	 *  
	 *  localhost:8080/api/v1/users?active=false  Todos los usuarios inactivo
	 *  
	 *	Class ResponseEntity<> : Es una clase que representa la respuesta HTTP:
	 *  código estado, encabezado, cuerpo de la respuesta.
	 *  Proporciona una forma más flexible y completa de manejar las respuestas HTTP. 
	 *
	 */
	@GetMapping 
	 ResponseEntity< List<User> > getAllUsers(
			@RequestParam(	name="active", 
							required=false, 
							defaultValue="true") boolean active 
			){
		return new ResponseEntity<List<User>>
		(userService.getAllUsers( active ), HttpStatus.OK);
	}
	
	@GetMapping("{id}") // localhost:8080/api/v1/users/{id}
	ResponseEntity<User> getUserById(@PathVariable("id") Long id ){
		return new ResponseEntity<User>
		(userService.getUserById(id) , HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user){
		User createdUser = userService.createUser(user);
		return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
ResponseEntity<String> deleteUser(@PathVariable("id") Long id ){
	userService.deleteUser(id);
	return new ResponseEntity<String>("User id " + id + " successfully deleted", HttpStatus.OK);
	}
}
