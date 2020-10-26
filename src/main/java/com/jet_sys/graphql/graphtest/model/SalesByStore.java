package com.jet_sys.graphql.graphtest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Objects;

//@Entity
//@Table(name = "sales_by_store", schema = "public", catalog = "dvdrental")
public class SalesByStore {
	@Basic
	@Column(name = "store", nullable = true, length = -1)
	private String store;
	@Basic
	@Column(name = "manager", nullable = true, length = -1)
	private String manager;
	@Basic
	@Column(name = "total_sales", nullable = true, precision = 0)
	private BigInteger totalSales;

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public BigInteger getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(BigInteger totalSales) {
		this.totalSales = totalSales;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SalesByStore that = (SalesByStore) o;
		return Objects.equals(store, that.store) &&
				Objects.equals(manager, that.manager) &&
				Objects.equals(totalSales, that.totalSales);
	}

	@Override
	public int hashCode() {
		return Objects.hash(store, manager, totalSales);
	}
}
