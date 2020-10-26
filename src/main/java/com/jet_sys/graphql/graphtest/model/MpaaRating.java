package com.jet_sys.graphql.graphtest.model;

public enum MpaaRating {

	G("G"),
	PG("PG"),
	PG13("PG-13"),
	R("R"),
	NC17("NC-17");

	public final String rating;

	private MpaaRating(String rating) { this.rating = rating; }
}
