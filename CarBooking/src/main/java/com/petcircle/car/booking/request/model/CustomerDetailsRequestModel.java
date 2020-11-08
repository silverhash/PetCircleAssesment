/**
 * 
 */
package com.petcircle.car.booking.request.model;

import java.util.List;

/**
 * @author RS
 *
 */
public class CustomerDetailsRequestModel {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<DriverDetailsRequestModel> driverDetails;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<DriverDetailsRequestModel> getDriverDetails() {
		return driverDetails;
	}

	public void setDriverDetails(List<DriverDetailsRequestModel> driverDetails) {
		this.driverDetails = driverDetails;
	}


}
