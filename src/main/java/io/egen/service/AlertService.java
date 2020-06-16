package io.egen.service;

import io.egen.entity.Alert;

import java.util.Date;
import java.util.List;

public interface AlertService {
	List<Alert> findAll();
	
	//i am directly going to call Repository.save, do i need create()?
	//Alert create(Alert emp);
	
	//find by vin
	List<Alert> findByVin(String vin);
	
	//find high alerts for ALL vehicles in last 2 hours
	List<Alert> findByPriorityAndTimestampAfter(String priority, Date d);
}
