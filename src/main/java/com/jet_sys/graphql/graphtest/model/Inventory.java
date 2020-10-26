package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Inventory {
	@Id
	@Column(name = "inventory_id", nullable = false)
	private Integer inventoryId;
	@Basic
	@Column(name = "film_id", insertable = false, updatable = false, nullable = false)
	private Short filmId;
	@Basic
	@Column(name = "store_id", nullable = false)
	private Short storeId;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;
	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
	private Film filmByFilmId;
	@OneToMany(mappedBy = "inventoryByInventoryId")
	private Collection<Rental> rentalsByInventoryId;

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Short getFilmId() {
		return filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	public Short getStoreId() {
		return storeId;
	}

	public void setStoreId(Short storeId) {
		this.storeId = storeId;
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
		Inventory inventory = (Inventory) o;
		return Objects.equals(inventoryId, inventory.inventoryId) &&
				Objects.equals(filmId, inventory.filmId) &&
				Objects.equals(storeId, inventory.storeId) &&
				Objects.equals(lastUpdate, inventory.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(inventoryId, filmId, storeId, lastUpdate);
	}

	public Film getFilmByFilmId() {
		return filmByFilmId;
	}

	public void setFilmByFilmId(Film filmByFilmId) {
		this.filmByFilmId = filmByFilmId;
	}

	public Collection<Rental> getRentalsByInventoryId() {
		return rentalsByInventoryId;
	}

	public void setRentalsByInventoryId(Collection<Rental> rentalsByInventoryId) {
		this.rentalsByInventoryId = rentalsByInventoryId;
	}
}
