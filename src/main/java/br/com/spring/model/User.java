package br.com.spring.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;

@Data

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Long Id;
	
	@Column(name = "username", unique=true, nullable = false, length=100)
	private String username;
	
	
	@Column(name = "password",  nullable = false, length=100)
	private String password;
	
	@Column(name = "name",  nullable = false, length=100)
	private String name;
	

	
	@Column(name = "create_time",nullable = false)
	private LocalDateTime createTime;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;
	
	
}
