package com.jet_sys.graphql.graphtest.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmCategoryPK implements Serializable {
	@Column(name = "film_id", insertable = false, updatable = false, nullable = false)
	@Id
	private Short filmId;
	@Column(name = "category_id", insertable = false, updatable = false, nullable = false)
	@Id
	private Short categoryId;

	public Short getFilmId() {
		return filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	public Short getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Short categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FilmCategoryPK that = (FilmCategoryPK) o;
		return Objects.equals(filmId, that.filmId) &&
				Objects.equals(categoryId, that.categoryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmId, categoryId);
	}
}
