package br.com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.spring.security.jwt.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passowordEncoder());
		
	}
	
	@Bean
	public JwtAuthorizationFilter jwtAuthorizationFilter(){
		
		return new JwtAuthorizationFilter();
		
	}
	
	@Override
	protected void configure(HttpSecurity http ) throws Exception {
		
	http.cors();
	http.csrf().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	http.authorizeRequests()
	.antMatchers("/api/aythetication/**").permitAll()
	.anyRequest().authenticated();
	
	
	
	http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	}
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	  return super.authenticationManagerBean();
	}
	
	//criptografa senha
	//passsowrd
	
	@Bean
	public PasswordEncoder passowordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	public WebMvcConfigurer corsConfigure() {
		
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping( "/**")
				.allowedOrigins("*")
                .allowedMethods("*");
			}
			
		};
		
	}
}
