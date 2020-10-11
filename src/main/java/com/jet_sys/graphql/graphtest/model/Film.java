package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Film {
	private Integer filmId;
	private String title;
	private String description;
	private Object releaseYear;
	private Short languageId;
	private Short rentalDuration;
	private BigDecimal rentalRate;
	private Short length;
	private BigDecimal replacementCost;
	private Object rating;
	private Timestamp lastUpdate;
	private Object specialFeatures;
	private Object fulltext;
	private Language languageByLanguageId;
	private Collection<FilmActor> filmActorsByFilmId;
	private Collection<FilmCategory> filmCategoriesByFilmId;
	private Collection<Inventory> inventoriesByFilmId;

	@Id
	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "description", nullable = true, length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "release_year", nullable = true)
	public Object getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Object releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Basic
	@Column(name = "language_id", nullable = false)
	public Short getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Short languageId) {
		this.languageId = languageId;
	}

	@Basic
	@Column(name = "rental_duration", nullable = false)
	public Short getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Short rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	@Basic
	@Column(name = "rental_rate", nullable = false, precision = 2)
	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	@Basic
	@Column(name = "length", nullable = true)
	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	@Basic
	@Column(name = "replacement_cost", nullable = false, precision = 2)
	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	@Basic
	@Column(name = "rating", nullable = true)
	public Object getRating() {
		return rating;
	}

	public void setRating(Object rating) {
		this.rating = rating;
	}

	@Basic
	@Column(name = "last_update", nullable = false)
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Basic
	@Column(name = "special_features", nullable = true, length = -1)
	public Object getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(Object specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Basic
	@Column(name = "fulltext", nullable = false)
	public Object getFulltext() {
		return fulltext;
	}

	public void setFulltext(Object fulltext) {
		this.fulltext = fulltext;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Film film = (Film) o;
		return Objects.equals(filmId, film.filmId) &&
				Objects.equals(title, film.title) &&
				Objects.equals(description, film.description) &&
				Objects.equals(releaseYear, film.releaseYear) &&
				Objects.equals(languageId, film.languageId) &&
				Objects.equals(rentalDuration, film.rentalDuration) &&
				Objects.equals(rentalRate, film.rentalRate) &&
				Objects.equals(length, film.length) &&
				Objects.equals(replacementCost, film.replacementCost) &&
				Objects.equals(rating, film.rating) &&
				Objects.equals(lastUpdate, film.lastUpdate) &&
				Objects.equals(specialFeatures, film.specialFeatures) &&
				Objects.equals(fulltext, film.fulltext);
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmId, title, description, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, lastUpdate, specialFeatures, fulltext);
	}

	@ManyToOne
	@JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
	public Language getLanguageByLanguageId() {
		return languageByLanguageId;
	}

	public void setLanguageByLanguageId(Language languageByLanguageId) {
		this.languageByLanguageId = languageByLanguageId;
	}

	@OneToMany(mappedBy = "filmByFilmId")
	public Collection<FilmActor> getFilmActorsByFilmId() {
		return filmActorsByFilmId;
	}

	public void setFilmActorsByFilmId(Collection<FilmActor> filmActorsByFilmId) {
		this.filmActorsByFilmId = filmActorsByFilmId;
	}

	@OneToMany(mappedBy = "filmByFilmId")
	public Collection<FilmCategory> getFilmCategoriesByFilmId() {
		return filmCategoriesByFilmId;
	}

	public void setFilmCategoriesByFilmId(
			Collection<FilmCategory> filmCategoriesByFilmId) {
		this.filmCategoriesByFilmId = filmCategoriesByFilmId;
	}

	@OneToMany(mappedBy = "filmByFilmId")
	public Collection<Inventory> getInventoriesByFilmId() {
		return inventoriesByFilmId;
	}

	public void setInventoriesByFilmId(Collection<Inventory> inventoriesByFilmId) {
		this.inventoriesByFilmId = inventoriesByFilmId;
	}
}
