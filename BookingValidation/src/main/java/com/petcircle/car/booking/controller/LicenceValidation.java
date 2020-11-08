/**
 * 
 */
package com.petcircle.car.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RS
 *
 */
@RestController
@RequestMapping("/validate")
public class LicenceValidation {
	@GetMapping(path = "/{licenceNo}")
	public String validateDriverLicense(@PathVariable("licenceNo") String licenceNo) {
		if (Math.random() > 0.5) {
			return "VALID";
		} else {
			return "INVALID";
		}
	}
}
