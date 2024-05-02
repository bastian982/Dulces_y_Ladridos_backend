package org.looplegion.app.controller;

import java.util.List;

import org.looplegion.app.entity.User;
import org.looplegion.app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
	
	UserService userService;
	
	public RoleController(UserService userService) {
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
	 *  Class ResponseEntity<> : Es una clase que representa la respuesta HTTP:
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
		return new ResponseEntity<List<User>>(userService.getAllUsers( active ), HttpStatus.OK);
	}
	
	/**
	 *  @GetMapping con Path Variable
	 *  Path Variable vincula un valor de una variable URL
	 *  a un parámetro del método.
	 *  Permite capturar datos dinámicos presentes en la URL 
	 */
	@GetMapping("{id}") // localhost:8080/api/v1/users/{id}
	ResponseEntity<User> getUserById(@PathVariable("id") Long id ){
		return new ResponseEntity<User>(userService.getUserById(id) ,HttpStatus.OK );
	}
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user ){
		User createdUser = userService.createUser(user);
		
		return new ResponseEntity<User>( createdUser, HttpStatus.CREATED );		
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteUser(@PathVariable("id") Long id ){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User id " + id + " successfully deleted", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity<User> updateUser(
			@RequestBody User user, 
			@PathVariable("id") Long id  
			){
		User updatedUser = userService.updateUser(user, id);
		
		return new ResponseEntity<User>( updatedUser, HttpStatus.OK );		
	}
	
}
