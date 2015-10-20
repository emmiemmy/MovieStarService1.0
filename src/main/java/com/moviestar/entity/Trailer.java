package com.moviestar.entity;

/**
 * Klass som avänds för att hämta en inre tag till trailern.
 * @author Evy
 *
 */
//@XmlRootElement(name="trailer")	//HÄNVISAR TILL TAG<trailer>
public class Trailer {
	private String movieTitle;
	private String trailerID;
//	private String link; // Ta eventuellt bort.
//	
//	public Trailer(String link) {
//		this.link = link;
//	}
//	
//	public String getLink() {
//		return link;
//	}
	
//	@XmlElement
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
//	@XmlElement
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
		return "Title: " + movieTitle + "TrailerID: " + trailerID;
	}
}
