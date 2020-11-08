/**
 * 
 */
package com.petcircle.car.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.petcircle.car.booking.entity.DriverEntity;

/**
 * @author RS
 *
 */
public interface DriverRepository extends CrudRepository<DriverEntity, Long> {

}
