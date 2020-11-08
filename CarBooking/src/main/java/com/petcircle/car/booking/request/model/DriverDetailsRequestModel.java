/**
 * 
 */
package com.petcircle.car.booking.request.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author RS
 *
 */
public class DriverDetailsRequestModel {
	private String firstName;
	private String lastName;
	private String licenceNo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfExpiry;
	private Integer age;
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
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
