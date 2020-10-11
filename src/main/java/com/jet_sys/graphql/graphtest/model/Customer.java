package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
	private Integer customerId;
	private Short storeId;
	private String firstName;
	private String lastName;
	private String email;
	private Short addressId;
	private Boolean activebool;
	private Date createDate;
	private Timestamp lastUpdate;
	private Integer active;
	private Address addressByAddressId;
	private Collection<Payment> paymentsByCustomerId;
	private Collection<Rental> rentalsByCustomerId;

	@Id
	@Column(name = "customer_id", nullable = false)
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	@Column(name = "email", nullable = true, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	@Column(name = "activebool", nullable = false)
	public Boolean getActivebool() {
		return activebool;
	}

	public void setActivebool(Boolean activebool) {
		this.activebool = activebool;
	}

	@Basic
	@Column(name = "create_date", nullable = false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Basic
	@Column(name = "last_update", nullable = true)
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Basic
	@Column(name = "active", nullable = true)
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Customer customer = (Customer) o;
		return Objects.equals(customerId, customer.customerId) &&
				Objects.equals(storeId, customer.storeId) &&
				Objects.equals(firstName, customer.firstName) &&
				Objects.equals(lastName, customer.lastName) &&
				Objects.equals(email, customer.email) &&
				Objects.equals(addressId, customer.addressId) &&
				Objects.equals(activebool, customer.activebool) &&
				Objects.equals(createDate, customer.createDate) &&
				Objects.equals(lastUpdate, customer.lastUpdate) &&
				Objects.equals(active, customer.active);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, storeId, firstName, lastName, email, addressId, activebool, createDate, lastUpdate, active);
	}

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
	public Address getAddressByAddressId() {
		return addressByAddressId;
	}

	public void setAddressByAddressId(Address addressByAddressId) {
		this.addressByAddressId = addressByAddressId;
	}

	@OneToMany(mappedBy = "customerByCustomerId")
	public Collection<Payment> getPaymentsByCustomerId() {
		return paymentsByCustomerId;
	}

	public void setPaymentsByCustomerId(Collection<Payment> paymentsByCustomerId) {
		this.paymentsByCustomerId = paymentsByCustomerId;
	}

	@OneToMany(mappedBy = "customerByCustomerId")
	public Collection<Rental> getRentalsByCustomerId() {
		return rentalsByCustomerId;
	}

	public void setRentalsByCustomerId(Collection<Rental> rentalsByCustomerId) {
		this.rentalsByCustomerId = rentalsByCustomerId;
	}
}
