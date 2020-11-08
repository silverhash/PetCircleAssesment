/**
 * 
 */
package com.petcircle.car.booking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.petcircle.car.booking.entity.CustomerEntity;

/**
 * @author RS
 *
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	Optional<CustomerEntity> findByEmail(String email);
}
