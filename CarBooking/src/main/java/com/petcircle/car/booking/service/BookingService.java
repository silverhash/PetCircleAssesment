/**
 * 
 */
package com.petcircle.car.booking.service;

import java.util.List;

import com.petcircle.car.booking.entity.BookingEntity;

/**
 * @author RS
 *
 */
public interface BookingService {
	String createBooking(BookingEntity booking);
	
	String updateBooking(BookingEntity booking);
	
	List<BookingEntity> getAllBookings();
	
	List<BookingEntity> getAllAvailableBookings();

	String addBooking(Integer id, String username);
}
