package br.com.spring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.model.Device;
import br.com.spring.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService{
	
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	
	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}
	//metodo para salvar device o dispositivo
	
	@Override
	public Device saveDevice(Device device ) {
		
		device.setCreateTime(LocalDateTime.now());
		
		
		return deviceRepository.save(device);
		
	}
	//delete device
	
	@Override
	public void deleteDevice(Long id) {
	
		deviceRepository.deleteById(id);
		
	}
	
	@Override
	public List<Device>findAll(){
		
		return deviceRepository.findAll();
	}
	

}
