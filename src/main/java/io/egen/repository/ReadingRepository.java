package io.egen.repository;

import io.egen.entity.Reading;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ReadingRepository extends CrudRepository<Reading, String> {
	List<Reading> findByVinAndTimestampAfter(String vin, Date d);
}
