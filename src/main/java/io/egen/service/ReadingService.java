package io.egen.service;

import io.egen.entity.Reading;
import java.util.Date;
import java.util.List;

public interface ReadingService {
	List<Reading> findAll();
	Reading create(Reading v);
	List<Reading> findByVinAndTimestampAfter(String vin, Date d);
}
