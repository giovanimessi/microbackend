package br.com.spring.service;

import br.com.spring.model.User;

public interface AuthenticationService {

	User signInAndReturnJWT(User signRequest);

}
