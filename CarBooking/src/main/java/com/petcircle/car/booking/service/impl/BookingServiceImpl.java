/**
 * 
 */
package com.petcircle.car.booking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.petcircle.car.booking.entity.BookingEntity;
import com.petcircle.car.booking.entity.CustomerEntity;
import com.petcircle.car.booking.repository.BookingRepository;
import com.petcircle.car.booking.repository.CustomerRepository;
import com.petcircle.car.booking.service.BookingService;

/**
 * @author RS
 *
 */
@Service
public class BookingServiceImpl implements BookingService {
	private BookingRepository bookingRepository;
	private CustomerRepository customerRepository;
	private RestTemplate template;
	
	@Autowired
	public BookingServiceImpl(BookingRepository bookingRepository,
			CustomerRepository customerRepository,
			RestTemplate template) {
		this.bookingRepository = bookingRepository;
		this.customerRepository = customerRepository;
		this.template = template;
	}
	
	@Override
	public String createBooking(BookingEntity booking) {
		return null;
	}

	@Override
	public String updateBooking(BookingEntity booking) {
		return null;
	}

	@Override
	public List<BookingEntity> getAllBookings() {
		return Lists.from(this.bookingRepository.findAll().iterator());
	}
	
	public List<BookingEntity> getAllAvailableBookings() {
		List<BookingEntity> list = Lists.from(this.bookingRepository.findAll().iterator());
		List<BookingEntity> availableBookings = list.stream().
				filter(b -> ! (b.getStatus().equalsIgnoreCase("booked") ||
						b.getStatus().equalsIgnoreCase("pending") || 
						b.getStatus().equalsIgnoreCase("request"))).collect(Collectors.toList());
		return availableBookings;
	}

	@Override
	public String addBooking(Integer id, String username) {
		Optional<BookingEntity> entity = this.bookingRepository.findById(id.longValue());
		Optional<CustomerEntity> customer = this.customerRepository.findByEmail(username);
		Map<String, String> validateResponse = new HashMap<>();
		if(null != customer.get()) {
			CustomerEntity ce = customer.get();
			ce.getDriverDetails().stream().forEach(driver -> {
				String url = String.format("http://localhost:8050/validate/%s", driver.getLicenceNo());
				ResponseEntity<String> response = this.template.exchange(url, HttpMethod.GET, null, String.class);
				validateResponse.put(driver.getLicenceNo(), response.getBody());
			});
		}else {
			return "Username not found in the system. Please register for booking";
		}
		BookingEntity booking = entity.get();
		if(null == booking) {
			return "Booking not Successfull. Booking id not found. Please try again Later";
		}

		booking.setCustdetails(customer.get());
		for(Map.Entry<String, String> entry: validateResponse.entrySet()) {
			if (entry.getValue() == "VALID") {
				booking.setStatus("APPROVED");
				break;
			}else {
				booking.setStatus("APPROVAL_REQUIRED");
			}
		}
		this.bookingRepository.save(booking);
		return "Booking Successfull. Please check the booking status";
	}
	
	
	

}
