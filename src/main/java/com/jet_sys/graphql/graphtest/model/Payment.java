package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payment {
	private Integer paymentId;
	private Short customerId;
	private Short staffId;
	private Integer rentalId;
	private BigDecimal amount;
	private Timestamp paymentDate;
	private Customer customerByCustomerId;
	private Staff staffByStaffId;
	private Rental rentalByRentalId;

	@Id
	@Column(name = "payment_id", nullable = false)
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
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
	@Column(name = "staff_id", nullable = false)
	public Short getStaffId() {
		return staffId;
	}

	public void setStaffId(Short staffId) {
		this.staffId = staffId;
	}

	@Basic
	@Column(name = "rental_id", nullable = false)
	public Integer getRentalId() {
		return rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	@Basic
	@Column(name = "amount", nullable = false, precision = 2)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Basic
	@Column(name = "payment_date", nullable = false)
	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Payment payment = (Payment) o;
		return Objects.equals(paymentId, payment.paymentId) &&
				Objects.equals(customerId, payment.customerId) &&
				Objects.equals(staffId, payment.staffId) &&
				Objects.equals(rentalId, payment.rentalId) &&
				Objects.equals(amount, payment.amount) &&
				Objects.equals(paymentDate, payment.paymentDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentId, customerId, staffId, rentalId, amount, paymentDate);
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

	@ManyToOne
	@JoinColumn(name = "rental_id", referencedColumnName = "rental_id", nullable = false)
	public Rental getRentalByRentalId() {
		return rentalByRentalId;
	}

	public void setRentalByRentalId(Rental rentalByRentalId) {
		this.rentalByRentalId = rentalByRentalId;
	}
}
