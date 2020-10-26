package com.jet_sys.graphql.graphtest.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

//@Entity
//@Table(name = "film_list", schema = "public", catalog = "dvdrental")
public class FilmList {
	@Basic
	@Column(name = "fid", nullable = true)
	private Integer fid;
	@Basic
	@Column(name = "title", nullable = true, length = 255)
	private String title;
	@Basic
	@Column(name = "description", nullable = true, length = -1)
	private String description;
	@Basic
	@Column(name = "category", nullable = true, length = 25)
	private String category;
	@Basic
	@Column(name = "price", nullable = true, precision = 2)
	private BigDecimal price;
	@Basic
	@Column(name = "length", nullable = true)
	private Short length;
	@Basic
	@Column(name = "rating", nullable = true)
	private Object rating;
	@Basic
	@Column(name = "actors", nullable = true, length = -1)
	private String actors;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Short getLength() {
		return length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	public Object getRating() {
		return rating;
	}

	public void setRating(Object rating) {
		this.rating = rating;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FilmList filmList = (FilmList) o;
		return Objects.equals(fid, filmList.fid) &&
				Objects.equals(title, filmList.title) &&
				Objects.equals(description, filmList.description) &&
				Objects.equals(category, filmList.category) &&
				Objects.equals(price, filmList.price) &&
				Objects.equals(length, filmList.length) &&
				Objects.equals(rating, filmList.rating) &&
				Objects.equals(actors, filmList.actors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fid, title, description, category, price, length, rating, actors);
	}
}
