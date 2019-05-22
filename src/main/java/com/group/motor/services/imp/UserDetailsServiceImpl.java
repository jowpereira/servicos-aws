package com.group.motor.services.imp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group.motor.enums.Perfil;
import com.group.motor.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Value("${user.email}")
	private String user;
	
	@Value("${user.password}")
	private String password;
	
	private Set<Perfil> perfis;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return new UserSS(user, password, perfis);
	}

}
