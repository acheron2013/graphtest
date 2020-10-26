package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rental {
	@Id
	@Column(name = "rental_id", nullable = false)
	private Integer rentalId;
	@Basic
	@Column(name = "rental_date", nullable = false)
	private Timestamp rentalDate;
	@Basic
	@Column(name = "inventory_id", insertable = false, updatable = false, nullable = false)
	private Integer inventoryId;
	@Basic
	@Column(name = "customer_id", insertable = false, updatable = false,  nullable = false)
	private Short customerId;
	@Basic
	@Column(name = "return_date", nullable = true)
	private Timestamp returnDate;
	@Basic
	@Column(name = "staff_id", insertable = false, updatable = false,  nullable = false)
	private Short staffId;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;
	@OneToMany(mappedBy = "rentalByRentalId")
	private Collection<Payment> paymentsByRentalId;
	@ManyToOne
	@JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", nullable = false)
	private Inventory inventoryByInventoryId;
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
	private Customer customerByCustomerId;
	@ManyToOne
	@JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
	private Staff staffByStaffId;

	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public Timestamp getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Short getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Short customerId) {
		this.customerId = customerId;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public Short getStaffId() {
		return staffId;
	}

	public void setStaffId(Short staffId) {
		this.staffId = staffId;
	}

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

	public Collection<Payment> getPaymentsByRentalId() {
		return paymentsByRentalId;
	}

	public void setPaymentsByRentalId(Collection<Payment> paymentsByRentalId) {
		this.paymentsByRentalId = paymentsByRentalId;
	}

	public Inventory getInventoryByInventoryId() {
		return inventoryByInventoryId;
	}

	public void setInventoryByInventoryId(Inventory inventoryByInventoryId) {
		this.inventoryByInventoryId = inventoryByInventoryId;
	}

	public Customer getCustomerByCustomerId() {
		return customerByCustomerId;
	}

	public void setCustomerByCustomerId(Customer customerByCustomerId) {
		this.customerByCustomerId = customerByCustomerId;
	}

	public Staff getStaffByStaffId() {
		return staffByStaffId;
	}

	public void setStaffByStaffId(Staff staffByStaffId) {
		this.staffByStaffId = staffByStaffId;
	}
}
