package br.com.spring.service;

import java.util.Optional;

import br.com.spring.model.Role;
import br.com.spring.model.User;

public interface UserService {

	User saverUser(User user);

	Optional<User> findByUsername(String username);

	void changeRole(Role newRole, String username);

}
