package com.moviestar.entity;

import java.awt.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trailers {

	TrailerE trailers;

	@XmlElement(name = "trailer")
	public void setTrailers(TrailerE trailers) {

		this.trailers = trailers;

	}
	
//	@XmlElement(name = "trailer")
	public TrailerE getTrailer(){
		return trailers;
	}

}
