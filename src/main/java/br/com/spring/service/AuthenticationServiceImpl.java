package br.com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.spring.model.User;
import br.com.spring.security.UserPrincipal;
import br.com.spring.security.jwt.JwtProvider;

@Service
public class AuthenticationServiceImpl implements AuthenticationService
{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User signInAndReturnJWT(User signRequest) {
		
    
          Authentication authetication = (Authentication) authenticationManager.authenticate(
        		  
        		 new UsernamePasswordAuthenticationToken(signRequest.getUsername(),signRequest.getPassword())	  
        		  
        );
          UserPrincipal userPrincipal = (UserPrincipal) ((org.springframework.security.core.Authentication) authetication).getPrincipal();
          String jwt = jwtProvider.generateToken(userPrincipal);
          
          User signUser = userPrincipal.getUser();
          
        		  
          signUser.setToken(jwt);
          
          return signUser;
	}
	
	
}
