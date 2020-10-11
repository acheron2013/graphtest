package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Inventory {
	private Integer inventoryId;
	private Short filmId;
	private Short storeId;
	private Timestamp lastUpdate;
	private Film filmByFilmId;
	private Collection<Rental> rentalsByInventoryId;

	@Id
	@Column(name = "inventory_id", nullable = false)
	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@Basic
	@Column(name = "film_id", nullable = false)
	public Short getFilmId() {
		return filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	@Basic
	@Column(name = "store_id", nullable = false)
	public Short getStoreId() {
		return storeId;
	}

	public void setStoreId(Short storeId) {
		this.storeId = storeId;
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

	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
	public Film getFilmByFilmId() {
		return filmByFilmId;
	}

	public void setFilmByFilmId(Film filmByFilmId) {
		this.filmByFilmId = filmByFilmId;
	}

	@OneToMany(mappedBy = "inventoryByInventoryId")
	public Collection<Rental> getRentalsByInventoryId() {
		return rentalsByInventoryId;
	}

	public void setRentalsByInventoryId(Collection<Rental> rentalsByInventoryId) {
		this.rentalsByInventoryId = rentalsByInventoryId;
	}
}
