/**
 * 
 */
package com.petcircle.car.booking.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcircle.car.booking.entity.CustomerEntity;
import com.petcircle.car.booking.request.model.CustomerDetailsRequestModel;
import com.petcircle.car.booking.response.model.CustomerDetailsResponseModel;
import com.petcircle.car.booking.service.CustomerService;

/**
 * @author RS
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path = "/status/check")
	public String getStatus() {
		return "Customer Service Status working";
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<CustomerDetailsResponseModel> createCustomerProfile(@RequestBody CustomerDetailsRequestModel customer) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
		CustomerEntity savedCustomer = customerService.createUser(customerEntity);
		CustomerDetailsResponseModel customerResponse = mapper.map(savedCustomer, CustomerDetailsResponseModel.class);
		
		return new ResponseEntity<CustomerDetailsResponseModel>(customerResponse, HttpStatus.CREATED);
	}
}
