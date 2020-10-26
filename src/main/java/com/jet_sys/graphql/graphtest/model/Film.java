package com.jet_sys.graphql.graphtest.model;

import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@TypeDefs({
		@TypeDef(
				typeClass = StringArrayType.class,
				defaultForType = String[].class
		),
//		@TypeDef(
//				typeClass = IntArrayType.class,
//				defaultForType = int[].class
//		),
//		@TypeDef(
//				typeClass = EnumArrayType.class,
//				defaultForType = SensorState[].class,
//				parameters = {
//						@Parameter(
//								name = EnumArrayType.SQL_ARRAY_TYPE,
//								value = "sensor_state"
//						)
//				}
		@TypeDef(
				typeClass = EnumArrayType.class,
				defaultForType = MpaaRating.class
//				parameters = {
//						@Parameter(
//								name = EnumArrayType.SQL_ARRAY_TYPE,
//								value = "sensor_state"
//						)
//				}
		)
})
public class Film {
	@Id
	@Column(name = "film_id", nullable = false)
	private Integer filmId;
	@Basic
	@Column(name = "title", nullable = false, length = 255)
	private String title;
	@Basic
	@Column(name = "description", nullable = true, length = -1)
	private String description;
	@Basic
	@Column(name = "release_year", nullable = true, columnDefinition = "Integer")
	private Integer releaseYear;
	@Basic
	@Column(name = "language_id", insertable = false, updatable = false, nullable = false)
	private Short languageId;
	@Basic
	@Column(name = "rental_duration", nullable = false)
	private Short rentalDuration;
	@Basic
	@Column(name = "rental_rate", nullable = false, precision = 2)
	private BigDecimal rentalRate;
	@Basic
	@Column(name = "length", nullable = true)
	private Short length;
	@Basic
	@Column(name = "replacement_cost", nullable = false, precision = 2)
	private BigDecimal replacementCost;
	@Basic
	@Column(name = "rating", nullable = true, columnDefinition = "rating")
	private MpaaRating rating;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;
	@Lob
	@Column(name = "special_features", nullable = true, length = -1)
	private String specialFeatures;
	@Lob
	@Column(name = "fulltext", nullable = false)
	private String fulltext;
	@ManyToOne
	@JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
	private Language languageByLanguageId;
	@OneToMany(mappedBy = "filmByFilmId")
	private Collection<FilmActor> filmActorsByFilmId;
	@OneToMany(mappedBy = "filmByFilmId")
	private Collection<FilmCategory> filmCategoriesByFilmId;
	@OneToMany(mappedBy = "filmByFilmId")
	private Collection<Inventory> inventoriesByFilmId;

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Short getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Short languageId) {
		this.languageId = languageId;
	}

	public Short getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Short rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public MpaaRating getRating() {
		return rating;
	}

	public void setRating(MpaaRating rating) {
		this.rating = rating;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getFulltext() {
		return fulltext;
	}

	public void setFulltext(String fulltext) {
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

	public Language getLanguageByLanguageId() {
		return languageByLanguageId;
	}

	public void setLanguageByLanguageId(Language languageByLanguageId) {
		this.languageByLanguageId = languageByLanguageId;
	}

	public Collection<FilmActor> getFilmActorsByFilmId() {
		return filmActorsByFilmId;
	}

	public void setFilmActorsByFilmId(Collection<FilmActor> filmActorsByFilmId) {
		this.filmActorsByFilmId = filmActorsByFilmId;
	}

	public Collection<FilmCategory> getFilmCategoriesByFilmId() {
		return filmCategoriesByFilmId;
	}

	public void setFilmCategoriesByFilmId(
			Collection<FilmCategory> filmCategoriesByFilmId) {
		this.filmCategoriesByFilmId = filmCategoriesByFilmId;
	}

	public Collection<Inventory> getInventoriesByFilmId() {
		return inventoriesByFilmId;
	}

	public void setInventoriesByFilmId(Collection<Inventory> inventoriesByFilmId) {
		this.inventoriesByFilmId = inventoriesByFilmId;
	}
}
