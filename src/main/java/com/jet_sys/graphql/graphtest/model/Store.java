package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Store {
	@Id
	@Column(name = "store_id", nullable = false)
	private Integer storeId;
	@Basic
	@Column(name = "manager_staff_id", insertable = false, updatable = false, nullable = false)
	private Short managerStaffId;
	@Basic
	@Column(name = "address_id", insertable = false, updatable = false, nullable = false)
	private Short addressId;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;
	@ManyToOne
	@JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
	private Staff staffByManagerStaffId;
	@ManyToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
	private Address addressByAddressId;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Short getManagerStaffId() {
		return managerStaffId;
	}

	public void setManagerStaffId(Short managerStaffId) {
		this.managerStaffId = managerStaffId;
	}

	public Short getAddressId() {
		return addressId;
	}

	public void setAddressId(Short addressId) {
		this.addressId = addressId;
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

	public Staff getStaffByManagerStaffId() {
		return staffByManagerStaffId;
	}

	public void setStaffByManagerStaffId(Staff staffByManagerStaffId) {
		this.staffByManagerStaffId = staffByManagerStaffId;
	}

	public Address getAddressByAddressId() {
		return addressByAddressId;
	}

	public void setAddressByAddressId(Address addressByAddressId) {
		this.addressByAddressId = addressByAddressId;
	}
}
