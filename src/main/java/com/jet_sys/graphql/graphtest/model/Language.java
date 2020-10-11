package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Language {
	private Integer languageId;
	private String name;
	private Timestamp lastUpdate;
	private Collection<Film> filmsByLanguageId;

	@Id
	@Column(name = "language_id", nullable = false)
	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Language language = (Language) o;
		return Objects.equals(languageId, language.languageId) &&
				Objects.equals(name, language.name) &&
				Objects.equals(lastUpdate, language.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(languageId, name, lastUpdate);
	}

	@OneToMany(mappedBy = "languageByLanguageId")
	public Collection<Film> getFilmsByLanguageId() {
		return filmsByLanguageId;
	}

	public void setFilmsByLanguageId(Collection<Film> filmsByLanguageId) {
		this.filmsByLanguageId = filmsByLanguageId;
	}
}
