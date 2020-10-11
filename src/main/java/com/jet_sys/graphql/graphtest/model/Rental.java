package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rental {
	private Integer rentalId;
	private Timestamp rentalDate;
	private Integer inventoryId;
	private Short customerId;
	private Timestamp returnDate;
	private Short staffId;
	private Timestamp lastUpdate;
	private Collection<Payment> paymentsByRentalId;
	private Inventory inventoryByInventoryId;
	private Customer customerByCustomerId;
	private Staff staffByStaffId;

	@Id
	@Column(name = "rental_id", nullable = false)
	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	@Basic
	@Column(name = "rental_date", nullable = false)
	public Timestamp getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	@Basic
	@Column(name = "inventory_id", nullable = false)
	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@Basic
	@Column(name = "customer_id", nullable = false)
	public Short getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Short customerId) {
		this.customerId = customerId;
	}

	@Basic
	@Column(name = "return_date", nullable = true)
	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	@Basic
	@Column(name = "staff_id", nullable = false)
	public Short getStaffId() {
		return staffId;
	}

	public void setStaffId(Short staffId) {
		this.staffId = staffId;
	}

	@Basic
	@Column(name = "last_update", nullable = false)
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Rental rental = (Rental) o;
		return Objects.equals(rentalId, rental.rentalId) &&
				Objects.equals(rentalDate, rental.rentalDate) &&
				Objects.equals(inventoryId, rental.inventoryId) &&
				Objects.equals(customerId, rental.customerId) &&
				Objects.equals(returnDate, rental.returnDate) &&
				Objects.equals(staffId, rental.staffId) &&
				Objects.equals(lastUpdate, rental.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
	}

	@OneToMany(mappedBy = "rentalByRentalId")
	public Collection<Payment> getPaymentsByRentalId() {
		return paymentsByRentalId;
	}

	public void setPaymentsByRentalId(Collection<Payment> paymentsByRentalId) {
		this.paymentsByRentalId = paymentsByRentalId;
	}

	@ManyToOne
	@JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", nullable = false)
	public Inventory getInventoryByInventoryId() {
		return inventoryByInventoryId;
	}

	public void setInventoryByInventoryId(Inventory inventoryByInventoryId) {
		this.inventoryByInventoryId = inventoryByInventoryId;
	}

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	public Customer getCustomerByCustomerId() {
		return customerByCustomerId;
	}

	public void setCustomerByCustomerId(Customer customerByCustomerId) {
		this.customerByCustomerId = customerByCustomerId;
	}

	@ManyToOne
	@JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
	public Staff getStaffByStaffId() {
		return staffByStaffId;
	}

	public void setStaffByStaffId(Staff staffByStaffId) {
		this.staffByStaffId = staffByStaffId;
	}
}
