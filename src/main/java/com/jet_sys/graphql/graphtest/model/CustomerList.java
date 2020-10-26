package com.jet_sys.graphql.graphtest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

//@Entity
//@Table(name = "customer_list", schema = "public", catalog = "dvdrental")
public class CustomerList {
	@Basic
	@Column(name = "id", nullable = true)
	private Integer id;
	@Basic
	@Column(name = "name", nullable = true, length = -1)
	private String name;
	@Basic
	@Column(name = "address", nullable = true, length = 50)
	private String address;
	@Basic
	@Column(name = "zip code", nullable = true, length = 10)
	private String zipCode;
	@Basic
	@Column(name = "phone", nullable = true, length = 20)
	private String phone;
	@Basic
	@Column(name = "city", nullable = true, length = 50)
	private String city;
	@Basic
	@Column(name = "country", nullable = true, length = 50)
	private String country;
	@Basic
	@Column(name = "notes", nullable = true, length = -1)
	private String notes;
	@Basic
	@Column(name = "sid", nullable = true)
	private Short sid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Short getSid() {
		return sid;
	}

	public void setSid(Short sid) {
		this.sid = sid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CustomerList that = (CustomerList) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(address, that.address) &&
				Objects.equals(zipCode, that.zipCode) &&
				Objects.equals(phone, that.phone) &&
				Objects.equals(city, that.city) &&
				Objects.equals(country, that.country) &&
				Objects.equals(notes, that.notes) &&
				Objects.equals(sid, that.sid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, address, zipCode, phone, city, country, notes, sid);
	}
}
