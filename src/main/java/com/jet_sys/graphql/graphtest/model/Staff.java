package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Staff {
	private Integer staffId;
	private String firstName;
	private String lastName;
	private Short addressId;
	private String email;
	private Short storeId;
	private Boolean active;
	private String username;
	private String password;
	private Timestamp lastUpdate;
	private byte[] picture;
	private Collection<Payment> paymentsByStaffId;
	private Collection<Rental> rentalsByStaffId;
	private Address addressByAddressId;
	private Collection<Store> storesByStaffId;

	@Id
	@Column(name = "staff_id", nullable = false)
	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Basic
	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "last_name", nullable = false, length = 45)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "address_id", nullable = false)
	public Short getAddressId() {
		return addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
	}

	@Basic
	@Column(name = "email", nullable = true, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "store_id", nullable = false)
	public Short getStoreId() {
		return storeId;
	}

	public void setStoreId(Short storeId) {
		this.storeId = storeId;
	}

	@Basic
	@Column(name = "active", nullable = false)
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Basic
	@Column(name = "username", nullable = false, length = 16)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "password", nullable = true, length = 40)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "last_update", nullable = false)
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Basic
	@Column(name = "picture", nullable = true)
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Staff staff = (Staff) o;
		return Objects.equals(staffId, staff.staffId) &&
				Objects.equals(firstName, staff.firstName) &&
				Objects.equals(lastName, staff.lastName) &&
				Objects.equals(addressId, staff.addressId) &&
				Objects.equals(email, staff.email) &&
				Objects.equals(storeId, staff.storeId) &&
				Objects.equals(active, staff.active) &&
				Objects.equals(username, staff.username) &&
				Objects.equals(password, staff.password) &&
				Objects.equals(lastUpdate, staff.lastUpdate) &&
				Arrays.equals(picture, staff.picture);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(staffId, firstName, lastName, addressId, email, storeId, active, username, password, lastUpdate);
		result = 31 * result + Arrays.hashCode(picture);
		return result;
	}

	@OneToMany(mappedBy = "staffByStaffId")
	public Collection<Payment> getPaymentsByStaffId() {
		return paymentsByStaffId;
	}

	public void setPaymentsByStaffId(Collection<Payment> paymentsByStaffId) {
		this.paymentsByStaffId = paymentsByStaffId;
	}

	@OneToMany(mappedBy = "staffByStaffId")
	public Collection<Rental> getRentalsByStaffId() {
		return rentalsByStaffId;
	}

	public void setRentalsByStaffId(Collection<Rental> rentalsByStaffId) {
		this.rentalsByStaffId = rentalsByStaffId;
	}

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
	public Address getAddressByAddressId() {
		return addressByAddressId;
	}

	public void setAddressByAddressId(Address addressByAddressId) {
		this.addressByAddressId = addressByAddressId;
	}

	@OneToMany(mappedBy = "staffByManagerStaffId")
	public Collection<Store> getStoresByStaffId() {
		return storesByStaffId;
	}

	public void setStoresByStaffId(Collection<Store> storesByStaffId) {
		this.storesByStaffId = storesByStaffId;
	}
}
