package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_category", schema = "public", catalog = "dvdrental")
@IdClass(FilmCategoryPK.class)
public class FilmCategory {
	private Short filmId;
	private Short categoryId;
	private Timestamp lastUpdate;
	private Film filmByFilmId;
	private Category categoryByCategoryId;

	@Id
	@Column(name = "film_id", nullable = false)
	public Short getFilmId() {
		return filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	@Id
	@Column(name = "category_id", nullable = false)
	public Short getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Short categoryId) {
		this.categoryId = categoryId;
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
		FilmCategory that = (FilmCategory) o;
		return Objects.equals(filmId, that.filmId) &&
				Objects.equals(categoryId, that.categoryId) &&
				Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmId, categoryId, lastUpdate);
	}

	@ManyToOne
	@JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
	public Film getFilmByFilmId() {
		return filmByFilmId;
	}

	public void setFilmByFilmId(Film filmByFilmId) {
		this.filmByFilmId = filmByFilmId;
	}

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
	public Category getCategoryByCategoryId() {
		return categoryByCategoryId;
	}

	public void setCategoryByCategoryId(Category categoryByCategoryId) {
		this.categoryByCategoryId = categoryByCategoryId;
	}
}
