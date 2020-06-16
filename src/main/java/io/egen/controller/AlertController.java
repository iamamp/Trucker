package io.egen.controller;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.service.AlertService;
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
@RequestMapping(value = "/alerts")
@Api(description = "Vehicle alerts") //this is for Swagger
public class AlertController {
	@Autowired
	AlertService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> findAll(){ //this is not asked
		return service.findAll();
	}
	
	//will fetch ALL vehicle alerts by vin
	@RequestMapping(method = RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> findByVinAndTimestampAfter(@PathVariable String vin){
		return service.findByVin(vin);
	}
	
	//fetch all high alerts of all vehicles in last two hours
	@RequestMapping(method = RequestMethod.GET, value = "recent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> findRecent(){ 
		Date d = new Date(System.currentTimeMillis() - 7200 * 1000); //current GMT - 2h
		return service.findByPriorityAndTimestampAfter("high",d);
	}
}
