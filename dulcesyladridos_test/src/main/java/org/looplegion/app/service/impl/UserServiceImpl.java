package org.looplegion.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.looplegion.app.entity.User;
import org.looplegion.app.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.looplegion.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	UserRepository userRepository;
	PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(
			UserRepository userRepository, 
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public User getUserById(Long id) {		
		Optional<User> userOptional = userRepository.findById(id);
		User existingUser;
		
		if( userOptional.isPresent() ) {
			existingUser = userOptional.get();
			return existingUser;
		} else {
			throw new IllegalStateException("User does not exist with id " + id);
		}			
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> userOptional = userRepository.findByEmail(email);
		User existingUser;
		
		if( userOptional.isPresent() ) {
			existingUser = userOptional.get();
			return existingUser;
		} else {
			throw new IllegalStateException("User does not exist with email " + email);
		}	
	}

	@Override
	public User createUser(User user) {
		user.setActive(true);
		user.setId(null);
		//TODO encriptar password
		
		if( userRepository.existsByEmail(user.getEmail()) ) {
	throw new IllegalStateException("User exist with email " + user.getEmail());
		}
		
		return userRepository.save(user);
	}

	
	@Override
	public List<User> getAllUsers(boolean isActive) {
		if( isActive ) return getAllActiveUsers();
		else return getAllInactiveUsers();		
	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<User> getAllActiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}	


	@Override
	public List<User> getAllInactiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}

