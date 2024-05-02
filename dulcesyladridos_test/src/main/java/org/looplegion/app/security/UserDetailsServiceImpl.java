package org.looplegion.app.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.looplegion.app.entity.User;
import org.looplegion.app.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserService userService;
	
	public UserDetailsServiceImpl( UserService userService ) {
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User existingUser = userService.getUserByEmail(email);
				
		return new UserDetailsImpl( existingUser );
	}

}
