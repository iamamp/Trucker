package io.egen.controller;

import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
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
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vehicles")
@Api(description = "Vehicle info") //this is for Swagger
public class VehicleController {
	
	@Autowired
	VehicleService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Optional<Vehicle> findOne(@PathVariable String vin){
		return service.findOne(vin);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehicle create(@RequestBody Vehicle v) { //magic is happening here
		return service.create(v);
	}
}
