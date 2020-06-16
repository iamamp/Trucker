package io.egen.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.entity.Alert;
import io.egen.repository.AlertRepository;

@Service
public class AlertServiceImpl implements AlertService{
	@Autowired
	AlertRepository repository;
	
	@Transactional(readOnly = true)
	public List<Alert> findAll() {
		return (List<Alert>)repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Alert> findByVin(String vin) {
		return repository.findByVin(vin);
	}

	@Transactional(readOnly = true)
	public List<Alert> findByPriorityAndTimestampAfter(String priority, Date d) {
		return repository.findByPriorityAndTimestampAfter(priority, d);
	}
}
