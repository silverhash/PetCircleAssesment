package com.petcircle.car.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petcircle.car.booking.entity.CustomerEntity;
import com.petcircle.car.booking.repository.CustomerRepository;
import com.petcircle.car.booking.repository.DriverRepository;
import com.petcircle.car.booking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepo;
	private DriverRepository driverRepo;
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepo,
			DriverRepository driverRepo,
			BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.customerRepo = customerRepo;
		this.driverRepo = driverRepo;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}

	@Override
	public CustomerEntity createUser(CustomerEntity customer) {
		customer.setEncryptedPassword(this.bcryptPasswordEncoder.encode(customer.getPassword()));
		customer.getDriverDetails().stream().forEach(d -> {
			d.setCustomer(customer);
			d.setValid(false);
		});
		CustomerEntity cust = this.customerRepo.save(customer);
		this.driverRepo.saveAll(cust.getDriverDetails());
		return cust;
	}

}
