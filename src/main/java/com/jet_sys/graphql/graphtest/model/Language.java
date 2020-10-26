package com.jet_sys.graphql.graphtest.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Language {
	@Id
	@Column(name = "language_id", nullable = false)
	private Integer languageId;
	@Basic
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	@Basic
	@Column(name = "last_update", nullable = false)
	private Timestamp lastUpdate;
	@OneToMany(mappedBy = "languageByLanguageId")
	private Collection<Film> filmsByLanguageId;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Language language = (Language) o;
		return Objects.equals(languageId, language.languageId) &&
				Objects.equals(name, language.name) &&
				Objects.equals(lastUpdate, language.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(languageId, name, lastUpdate);
	}

	public Collection<Film> getFilmsByLanguageId() {
		return filmsByLanguageId;
	}

	public void setFilmsByLanguageId(Collection<Film> filmsByLanguageId) {
		this.filmsByLanguageId = filmsByLanguageId;
	}
}
