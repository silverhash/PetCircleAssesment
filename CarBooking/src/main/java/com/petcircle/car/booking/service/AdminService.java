/**
 * 
 */
package com.petcircle.car.booking.service;

import com.petcircle.car.booking.entity.AdminEntity;

/**
 * @author RS
 *
 */
public interface AdminService {
	AdminEntity createAdmin(AdminEntity admin);
	String updateBookingStatus(Integer bookingid, String status);
}
