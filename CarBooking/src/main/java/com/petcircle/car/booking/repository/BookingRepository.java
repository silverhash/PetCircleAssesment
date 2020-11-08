/**
 * 
 */
package com.petcircle.car.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.petcircle.car.booking.entity.BookingEntity;

/**
 * @author RS
 *
 */
public interface BookingRepository extends CrudRepository<BookingEntity, Long> {

}
