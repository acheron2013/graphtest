package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
	private Integer countryId;
	private String country;
	private Timestamp lastUpdate;
	private Collection<City> citiesByCountryId;

	@Id
	@Column(name = "country_id", nullable = false)
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Basic
	@Column(name = "country", nullable = false, length = 50)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
		Country country1 = (Country) o;
		return Objects.equals(countryId, country1.countryId) &&
				Objects.equals(country, country1.country) &&
				Objects.equals(lastUpdate, country1.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryId, country, lastUpdate);
	}

	@OneToMany(mappedBy = "countryByCountryId")
	public Collection<City> getCitiesByCountryId() {
		return citiesByCountryId;
	}

	public void setCitiesByCountryId(Collection<City> citiesByCountryId) {
		this.citiesByCountryId = citiesByCountryId;
	}
}
