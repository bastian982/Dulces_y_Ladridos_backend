package org.looplegion.app.service;

import java.util.List;

import org.looplegion.app.entity.User;


public interface UserService {
	
	User getUserById(Long id);
	User getUserByEmail(String email);
	User createUser(User user);
	List<User> getAllActiveUsers();
	List<User> getAllInactiveUsers();
	List<User> getAllUsers(boolean isActive);
	User updateUser(User user, Long id);
	void deleteUser(Long id);
	
}
