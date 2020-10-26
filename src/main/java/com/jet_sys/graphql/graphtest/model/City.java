package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class City {
	@Id
	@Column(name = "city_id", nullable = false)
	private Integer cityId;
	@Basic
	@Column(name = "city", nullable = false, length = 50)
	private String city;
	@Basic
	@Column(name = "country_id", insertable = false, updatable = false, nullable = false)
	private Short countryId;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;
	@OneToMany(mappedBy = "cityByCityId")
	private Collection<Address> addressesByCityId;
	@ManyToOne
	@JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
	private Country countryByCountryId;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Short getCountryId() {
		return countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
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
		City city1 = (City) o;
		return Objects.equals(cityId, city1.cityId) &&
				Objects.equals(city, city1.city) &&
				Objects.equals(countryId, city1.countryId) &&
				Objects.equals(lastUpdate, city1.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityId, city, countryId, lastUpdate);
	}

	public Collection<Address> getAddressesByCityId() {
		return addressesByCityId;
	}

	public void setAddressesByCityId(Collection<Address> addressesByCityId) {
		this.addressesByCityId = addressesByCityId;
	}

	public Country getCountryByCountryId() {
		return countryByCountryId;
	}

	public void setCountryByCountryId(Country countryByCountryId) {
		this.countryByCountryId = countryByCountryId;
	}
}
