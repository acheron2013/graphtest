package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_actor", schema = "public", catalog = "dvdrental")
@IdClass(FilmActorPK.class)
public class FilmActor {
	@Id
	@Column(name = "actor_id", nullable = false)
	private Short actorId;
	@Id
	@Column(name = "film_id", nullable = false)
	private Short filmId;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;

	@ManyToOne
	@JoinColumn(name = "actorByActorId", referencedColumnName = "actor_id", nullable = false)
	private Actor actorByActorId;

	@ManyToOne
	@JoinColumn(name = "filmByFildIdid", referencedColumnName = "film_id", nullable = false)
	private Film filmByFilmId;

	public Short getActorId() {
		return actorId;
	}

	public void setActorId(Short actorId) {
		this.actorId = actorId;
	}

	public Short getFilmId() {
		return filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
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
		FilmActor filmActor = (FilmActor) o;
		return Objects.equals(actorId, filmActor.actorId) &&
				Objects.equals(filmId, filmActor.filmId) &&
				Objects.equals(lastUpdate, filmActor.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, filmId, lastUpdate);
	}

	public Actor getActorByActorId() {
		return actorByActorId;
	}

	public void setActorByActorId(Actor actorByActorId) {
		this.actorByActorId = actorByActorId;
	}

	public Film getFilmByFilmId() {
		return filmByFilmId;
	}

	public void setFilmByFilmId(Film filmByFilmId) {
		this.filmByFilmId = filmByFilmId;
	}
}
