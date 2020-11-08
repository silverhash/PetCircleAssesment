package com.petcircle.car.booking.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petcircle.car.booking.entity.AdminEntity;
import com.petcircle.car.booking.entity.BookingEntity;
import com.petcircle.car.booking.repository.AdminRepository;
import com.petcircle.car.booking.repository.BookingRepository;
import com.petcircle.car.booking.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	private AdminRepository adminRepo;
	private BCryptPasswordEncoder passwordEncoder;
	private BookingRepository bookingRepo;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepo,
			BookingRepository bookingRepo,
			BCryptPasswordEncoder passwordEncoder) {
		this.adminRepo = adminRepo;
		this.bookingRepo = bookingRepo;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public AdminEntity createAdmin(AdminEntity admin) {
		admin.setEncryptedPassword(this.passwordEncoder.encode(admin.getPassword()));
		return this.adminRepo.save(admin);
	}
	@Override
	public String updateBookingStatus(Integer bookingId, String status) {
		Optional<BookingEntity> booking = this.bookingRepo.findById(bookingId.longValue());
		BookingEntity bookingEntity = booking.get();
		if(null != bookingEntity) {
			bookingEntity.setStatus(status);
			this.bookingRepo.save(bookingEntity);
			return "Booking Status Updated Successfully to " + status;
		} else {
			return "Booking Status not updated. Booking not found";
		}
	}

}
