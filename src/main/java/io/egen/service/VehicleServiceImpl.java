package io.egen.service;

import java.util.List;
import java.util.Optional;
import io.egen.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	CrudRepository<Vehicle, String> repository;
	
	@Transactional(readOnly = true)
	public List<Vehicle> findAll() {
		return (List<Vehicle>)repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional findOne(String vin) {
		return repository.findById(vin);
	}

	@Transactional
	public Vehicle create(Vehicle v) { // we know that VIN is always unique
		return repository.save(v);
	}

}
