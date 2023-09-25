package br.com.spring.service;

import java.util.List;

import br.com.spring.model.Device;

public interface DeviceService {

	Device saveDevice(Device device);

	void deleteDevice(Long id);

	

	List<Device> findAll();

}
