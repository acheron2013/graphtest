package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Store {
	private Integer storeId;
	private Short managerStaffId;
	private Short addressId;
	private Timestamp lastUpdate;
	private Staff staffByManagerStaffId;
	private Address addressByAddressId;

	@Id
	@Column(name = "store_id", nullable = false)
	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	@Basic
	@Column(name = "manager_staff_id", nullable = false)
	public Short getManagerStaffId() {
		return managerStaffId;
	}

	public void setManagerStaffId(Short managerStaffId) {
		this.managerStaffId = managerStaffId;
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
		Store store = (Store) o;
		return Objects.equals(storeId, store.storeId) &&
				Objects.equals(managerStaffId, store.managerStaffId) &&
				Objects.equals(addressId, store.addressId) &&
				Objects.equals(lastUpdate, store.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(storeId, managerStaffId, addressId, lastUpdate);
	}

	@ManyToOne
	@JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
	public Staff getStaffByManagerStaffId() {
		return staffByManagerStaffId;
	}

	public void setStaffByManagerStaffId(Staff staffByManagerStaffId) {
		this.staffByManagerStaffId = staffByManagerStaffId;
	}

	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
	public Address getAddressByAddressId() {
		return addressByAddressId;
	}

	public void setAddressByAddressId(Address addressByAddressId) {
		this.addressByAddressId = addressByAddressId;
	}
}
