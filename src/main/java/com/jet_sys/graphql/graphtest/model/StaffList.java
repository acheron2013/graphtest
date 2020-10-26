package com.jet_sys.graphql.graphtest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

//@Entity
//@Table(name = "staff_list", schema = "public", catalog = "dvdrental")
public class StaffList {
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
		StaffList staffList = (StaffList) o;
		return Objects.equals(id, staffList.id) &&
				Objects.equals(name, staffList.name) &&
				Objects.equals(address, staffList.address) &&
				Objects.equals(zipCode, staffList.zipCode) &&
				Objects.equals(phone, staffList.phone) &&
				Objects.equals(city, staffList.city) &&
				Objects.equals(country, staffList.country) &&
				Objects.equals(sid, staffList.sid);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, address, zipCode, phone, city, country, sid);
	}
}
