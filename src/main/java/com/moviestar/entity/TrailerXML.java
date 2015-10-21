package com.moviestar.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Klass som används för att hämta trailers.
 * 
 * @author Evy
 *
 */
@XmlRootElement(name = "trailers") // Hänvisar till taggen "trailers".
public class TrailerXML {
	private Trailer trailer;

	@XmlElement
	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

	public Trailer getTrailer() {
		return this.trailer;
	}
}