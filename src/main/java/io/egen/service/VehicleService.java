package io.egen.service;

import io.egen.entity.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
	List<Vehicle> findAll();
	Optional<Vehicle> findOne(String vin);
	Vehicle create(Vehicle v);
	
	//findbyVin in last 30min (Geolocation attribute only)
}
