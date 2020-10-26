package com.jet_sys.graphql.graphtest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Objects;

//@Entity
//@Table(name = "sales_by_film_category", schema = "public", catalog = "dvdrental")
public class SalesByFilmCategory {
	@Basic
	@Column(name = "category", nullable = true, length = 25)
	private String category;
	@Basic
	@Column(name = "total_sales", nullable = true, precision = 0)
	private BigInteger totalSales;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
		SalesByFilmCategory that = (SalesByFilmCategory) o;
		return Objects.equals(category, that.category) &&
				Objects.equals(totalSales, that.totalSales);
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, totalSales);
	}
}
