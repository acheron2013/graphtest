package com.jet_sys.graphql.graphtest.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Data
public class FilmActorPK implements Serializable {

	private Short actorId;
	private Short filmId;

//	public Short getActorId() {
//		return actorId;
//	}
//
//	public void setActorId(Short actorId) {
//		this.actorId = actorId;
//	}
//
//	public Short getFilmId() {
//		return filmId;
//	}
//
//	public void setFilmId(Short filmId) {
//		this.filmId = filmId;
//	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FilmActorPK that = (FilmActorPK) o;
		return Objects.equals(actorId, that.actorId) &&
				Objects.equals(filmId, that.filmId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, filmId);
	}
}
