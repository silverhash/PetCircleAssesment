/**
 * 
 */
package com.petcircle.car.booking.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcircle.car.booking.entity.AdminEntity;
import com.petcircle.car.booking.request.model.AdminDetailsRequestModel;
import com.petcircle.car.booking.request.model.UpdateBookingStatusRequestModel;
import com.petcircle.car.booking.response.model.AdminDetailsResponseModel;
import com.petcircle.car.booking.service.AdminService;

/**
 * @author RS
 *
 */
@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public ResponseEntity<AdminDetailsResponseModel> createAdminUser(@RequestBody AdminDetailsRequestModel adminDetails) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AdminEntity adminEntity = mapper.map(adminDetails, AdminEntity.class);
		AdminEntity savedEntity = this.adminService.createAdmin(adminEntity);
		AdminDetailsResponseModel adminResponse = mapper.map(savedEntity, AdminDetailsResponseModel.class);
		return new ResponseEntity<AdminDetailsResponseModel>(adminResponse, HttpStatus.CREATED);
	}
	
	
	@PostMapping(path="/updatestatus")
	public String updateBookingStatus(@RequestBody UpdateBookingStatusRequestModel updateRequest) {
		return adminService.updateBookingStatus(updateRequest.getId(), updateRequest.getStatus());
	}
	
}
