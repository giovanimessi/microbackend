package br.com.spring.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthorizationFilter extends OncePerRequestFilter{
	
	
	@Autowired
	private JwtProvider jwtProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Authentication authetication = jwtProvider.getAuthentication(request);
		
		
		if(authetication != null && jwtProvider.isTokenValid(request)) {
			
			SecurityContextHolder.getContext().setAuthentication(authetication);
			
		}
		filterChain.doFilter(request, response);
	}

}
