package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actor_info", schema = "public", catalog = "dvdrental")
public class ActorInfo {
	@Id
	@Column(name = "actor_id", nullable = true)
	private Integer actorId;
	@Basic
	@Column(name = "first_name", nullable = true, length = 45)
	private String firstName;
	@Basic
	@Column(name = "last_name", nullable = true, length = 45)
	private String lastName;
	@Basic
	@Column(name = "film_info", nullable = true, length = -1)
	private String filmInfo;

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

	public String getFilmInfo() {
		return filmInfo;
	}

	public void setFilmInfo(String filmInfo) {
		this.filmInfo = filmInfo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ActorInfo actorInfo = (ActorInfo) o;
		return Objects.equals(actorId, actorInfo.actorId) &&
				Objects.equals(firstName, actorInfo.firstName) &&
				Objects.equals(lastName, actorInfo.lastName) &&
				Objects.equals(filmInfo, actorInfo.filmInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, firstName, lastName, filmInfo);
	}
}
