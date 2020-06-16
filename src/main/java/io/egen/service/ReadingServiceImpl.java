package io.egen.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.repository.AlertRepository;
import io.egen.repository.ReadingRepository;
import io.egen.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {
	@Autowired
	ReadingRepository repository;
	
	@Autowired
	AlertRepository ar;
	
	@Autowired
	VehicleRepository vr;
	
	@Transactional(readOnly = true)
	public List<Reading> findAll() {
		return (List<Reading>)repository.findAll();
	}

	@Transactional
	public Reading create(Reading r) {
		Optional<Vehicle> v = vr.findById(r.getVin());
		Alert a = new Alert();
		a.setVin(r.getVin());
		a.setTimestamp(new Date());
		
		if(r.getEngineRpm() > v.get().getRedlineRpm()) {
			a.setDescr("rpm");
			a.setPriority("high");
		} else if (r.getFuelVolume() < 0.1*v.get().getMaxFuelVolume()) {
			a.setDescr("fuel");
			a.setPriority("med");
		} else if (r.getTires().getFrontLeft() < 32 || r.getTires().getFrontRight() < 32 ||
				r.getTires().getRearLeft() < 32 || r.getTires().getRearRight() < 32 ) {
			a.setDescr("tyre");
			a.setPriority("low");
		} else if (r.isEngineCoolantLow() || r.isCheckEngineLightOn()) {
			a.setDescr("coolant/enginelight");
			a.setPriority("low");
		}
		ar.save(a);
		return repository.save(r);
	}
	
	@Transactional(readOnly = true)
	public List<Reading> findByVinAndTimestampAfter(String vin, Date d){
		return repository.findByVinAndTimestampAfter(vin,d);
	}
}
