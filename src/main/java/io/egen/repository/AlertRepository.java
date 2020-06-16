package io.egen.repository;

import io.egen.entity.Alert;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AlertRepository extends CrudRepository<Alert, String>{
	List<Alert> findByPriorityAndTimestampAfter(String priority, Date d);
	List<Alert> findByVin(String vin);
}
