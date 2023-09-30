package br.com.spring.security;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.spring.model.User;
import br.com.spring.service.UserService;
import br.com.spring.utils.SecurityUtils;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
      User user = userService.findByUsername(username)
    		  .orElseThrow(() -> new UsernameNotFoundException(username));
      
      Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
	
      
      return UserPrincipal.builder()
    		  .user(user)
    		  .id(user.getId())
    		  .username(username)
    		  .password(user.getPassword())
    		  .authorities(authorities)
    		  .build();
	}

}
