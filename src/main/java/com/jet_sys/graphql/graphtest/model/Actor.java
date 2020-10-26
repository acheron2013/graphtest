package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Actor {
	@Id
	@Column(name = "actor_id", nullable = false)
	private Integer actorId;
	@Basic
	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;
	@Basic
	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;
	@OneToMany(mappedBy = "actorByActorId")
	private Collection<FilmActor> filmActorsByActorId;

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		Actor actor = (Actor) o;
		return Objects.equals(actorId, actor.actorId) &&
				Objects.equals(firstName, actor.firstName) &&
				Objects.equals(lastName, actor.lastName) &&
				Objects.equals(lastUpdate, actor.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, firstName, lastName, lastUpdate);
	}

	public Collection<FilmActor> getFilmActorsByActorId() {
		return filmActorsByActorId;
	}

	public void setFilmActorsByActorId(Collection<FilmActor> filmActorsByActorId) {
		this.filmActorsByActorId = filmActorsByActorId;
	}
}
