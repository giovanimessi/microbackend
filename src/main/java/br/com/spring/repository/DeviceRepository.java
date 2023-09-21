package br.com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {

}
