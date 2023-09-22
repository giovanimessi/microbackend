package br.com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableJpaRepositories(basePackages = {"br.com.spring.respository"})
@ComponentScan(basePackages = {"br.com.spring.respository*"})
@SpringBootApplication
public class MicrobackendApplication {
	
	//criptografa senha
	//passsowrd
	
	@Bean
	public PasswordEncoder passowordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(MicrobackendApplication.class, args);
	}

}
