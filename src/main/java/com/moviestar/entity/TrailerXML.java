package com.moviestar.entity;

/**
 * Klass som används för att hämta trailers.
 * 
 * @author Evy
 *
 */
//@XmlRootElement(name = "trailers") // HÄNVISAR TILL TAG<trailers>
public class TrailerXML {
	private Trailer trailer;

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public Trailer getTrailer() {
		return this.trailer;
	}
}