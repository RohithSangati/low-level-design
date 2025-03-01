package model;

import java.util.UUID;

public class Movie {

	private String movieId;
	private String name;
	private String description;
	private int durationInMinutes;

	public Movie(String name, String description, int durationInMinutes) {
		super();
		this.movieId = UUID.randomUUID().toString();
		this.name = name;
		this.description = description;
		this.durationInMinutes = durationInMinutes;
	}

	public String getMovieId() {
		return movieId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", description=" + description + ", durationInMinutes="
				+ durationInMinutes + "]";
	}

}
