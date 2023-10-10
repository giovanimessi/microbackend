package br.com.spring.security.jwt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import br.com.spring.security.UserPrincipal;

public interface JwtProvider {

	Authentication getAuthentication(HttpServletRequest request);

	boolean isTokenValid(HttpServletRequest request);

	String generateToken(UserPrincipal userPrincipal);

}
