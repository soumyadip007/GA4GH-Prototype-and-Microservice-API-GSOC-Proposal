package com.ga4gh.prototype.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService  {

	@Override
	public UserDetails loadUserByUsername(String username) throws
											UsernameNotFoundException{
											
		return new User("GA4GH_USER","GA4GH_PASS",new ArrayList<>());
		
	}
	
}
