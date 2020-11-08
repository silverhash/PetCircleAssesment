/**
 * 
 */
package com.petcircle.car.booking.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author RS
 *
 */
@Entity
@Table(name="customer")
public class CustomerEntity implements Serializable{
	
	/**
	 * serial id
	 */
	private static final long serialVersionUID = 7377279697384044599L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	@Column(nullable = false, length = 50)
	private String lastName;
	@Column(nullable = false, length = 120, unique = true)
	private String email;
	
	@Transient
	private String password;
	
	@Column(nullable = false, unique = true)
	private String encryptedPassword;
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<DriverEntity> driverDetails = new HashSet<>();
	
	@OneToOne(mappedBy = "custdetails")
	private BookingEntity bookingEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<DriverEntity> getDriverDetails() {
		return driverDetails;
	}

	public void setDriverDetails(Set<DriverEntity> driverDetails) {
		this.driverDetails = driverDetails;
	}

	
	
}
