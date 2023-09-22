package br.com.spring.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.spring.model.Role;
import br.com.spring.model.User;
import br.com.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	  private final UserRepository userRepository;

	    @Autowired
	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }


    // Métodos do serviço
    
    @Autowired
    private PasswordEncoder passowordEncoder;
    
    
    @Override
    public User saverUser(User user) {
    	//password encoder
    	
    	user.setPassword(passowordEncoder.encode(user.getPassword()));
    	user.setRole(Role.USER);
    	user.setCreateTime(LocalDateTime.now());
    	return userRepository.save(user);
     }
    
    @Override
    @Transactional
    public Optional <User> findByUsername(String username){
    	
    	return  userRepository.findByUsername(username);
    	
    }
    
    public void changeRole(Role newRole,String username) {
    	
    	userRepository.updateUserRole(username,newRole);
    	
    }
   }
