package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.service.ReadingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/readings")
@Api(description = "Vehicle readings") //this is for Swagger
public class ReadingController {
	
	@Autowired
	ReadingService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Reading> findAll(){ //this is not asked
		return service.findAll();
	}
	
	//will fetch vehicle readings by vin, filtered by last 30min
	@RequestMapping(method = RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Reading> findByVinAndTimestampAfter(@PathVariable String vin){
		Date d = new Date(System.currentTimeMillis() - 1800 * 1000); //current GMT - 30min
		return service.findByVinAndTimestampAfter(vin,d);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reading create(@RequestBody Reading v) { //magic is happening here
		return service.create(v);
	}
}
