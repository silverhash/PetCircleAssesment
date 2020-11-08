/**
 * 
 */
package com.petcircle.car.booking.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.petcircle.car.booking.request.model.BookingRequestModel;
import com.petcircle.car.booking.response.model.BookingAvailabilityResponseModel;
import com.petcircle.car.booking.service.BookingService;

/**
 * @author RS
 *
 */
@RestController
@RequestMapping("booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping
	public ResponseEntity<List<BookingAvailabilityResponseModel>> getAllAvailableBookings() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		List<BookingAvailabilityResponseModel> response = bookingService.getAllAvailableBookings().stream().
				map(entity -> mapper.map(entity, BookingAvailabilityResponseModel.class)).collect(Collectors.toList());
		return new ResponseEntity<List<BookingAvailabilityResponseModel>>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> bookVehicle(@RequestBody BookingRequestModel request ) {
		String message  = bookingService.addBooking(request.getId(), request.getUsername());
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
