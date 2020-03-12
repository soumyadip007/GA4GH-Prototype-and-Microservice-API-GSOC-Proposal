package com.ga4gh.prototypel.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService  {

	@Override
	public UserDetails loadUserByUsername(String username) throws
											UsernameNotFoundException{
											
		return new User("Soumya","Soumya",new ArrayList<>());
		
	}
	
}
