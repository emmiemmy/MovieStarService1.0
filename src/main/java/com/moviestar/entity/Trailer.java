package com.moviestar.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Klass som avänds för att hämta en inre tag till trailern.
 * 
 * @author Evy
 *
 */
@XmlRootElement(name = "trailer") // Hänvisar till taggen "trailer"
public class Trailer {
	private String movieTitle;
	private String trailerID;

	@XmlElement
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	@XmlElement
	public void setTrailerID(String trailerID) {
		this.trailerID = trailerID;
	}

	public String getMovieTitle() {
		return this.movieTitle;
	}

	public String getTrailerID() {
		return this.trailerID;
	}

	public String toString() {
		return "Title: " + movieTitle + "\nTrailerID: " + trailerID;
	}
}