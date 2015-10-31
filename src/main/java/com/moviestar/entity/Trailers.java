package com.moviestar.entity;

import java.awt.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trailers {

	Trailer trailers;

	@XmlElement(name = "trailer")
	public void setTrailers(Trailer trailers) {

		this.trailers = trailers;

	}
	
//	@XmlElement(name = "trailer")
	public Trailer getTrailer(){
		return trailers;
	}

}
