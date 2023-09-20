package br.com.spring.model;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_devices")
public class Device {
	
	//tipo de dispositivo
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name = "name",nullable = false, length = 100)
	private String name;
	
	@Column(name = "description", nullable = false, length = 100)
	private String description;
	
	@Column(name = "price",nullable = false)
	private Double price;
	
	@Column(name = "create_time", nullable = false)
	private LocalDateTime createTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "device_type",nullable = false)
	private DeviceType devicetype;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
	//private Set<Purchase> putchaseList;
	
	

}
