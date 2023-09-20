package br.com.spring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "tb_pruchases")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name = "user_id",nullable = false)
	private Long userId;
	
	//** para um
	@ManyToOne(fetch = FetchType.LAZY)
	//foregein
	@JoinColumn(name ="user_id", referencedColumnName = "id",insertable = false,updatable = false)
	private User user;
	
	
	
	@Column(name = "device_id",nullable = false)
	private Long deviceId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//foregein
	@JoinColumn(name ="device_id", referencedColumnName = "id",insertable = false,updatable = false)
	private Device device;
	
	@Column(name = "price", nullable = false )
	private Double price;
	
	
	@Column (name = "color", nullable = false)
	private String color;
	
	
	@Column(name = "purchase_time", nullable = false)
	private LocalDateTime purchaseTime;
}
