package br.com.spring.repository.projection;

import java.time.LocalDateTime;

import br.com.spring.model.DeviceType;

public interface PurchaseItem {
	
	String getName();
	DeviceType getType();
	Double getPrice();
	String getColor();
	LocalDateTime getPurchase();

}
