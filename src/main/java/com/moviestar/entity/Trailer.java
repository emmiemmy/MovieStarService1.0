package com.moviestar.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.internal.ws.util.xml.CDATA;

/**
 * Klassen representerar en Trailer med lämpliga attribut. Klassen används för att vi skall kunna hantera XML data
 * @author Emma Shakespeare, Evelyn Gustavsson, Jody O'neill
 * XmlType hanterar XML datan och de "taggar" som denna innehåller. Vi lagrar denna i vårt java objekt
 *
 */
@XmlType(propOrder = { "title", "link", "pubDate", "embed" })
@XmlRootElement(name = "trailer")
public class Trailer {

	private String link;
	private String title;
	private String trailerId;
	private String pubDate;
	private String embed;
	private String trailerLink = null;

	public Trailer() {
	}

	@XmlElement(name = "link")
	public void setLink(String link) {
		this.link = link;
	}

	@XmlElement(name = "title")
	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "pubDate")
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@XmlElement(name = "embed")
	public void setEmbed(String embed) {
		this.embed = embed;
	}

	// @XmlElement (name = "trailer_id")
	// public void setTitleId(String trailer_id) {
	// this.trailerId = trailer_id;
	// }

	// @XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	// @XmlElement(name = "link")
	public String getLink() {
		return link;
	}

	// @XmlElement(name = "trailer_id")
	// public String getTrailerId() {
	// return trailerId;
	// }

	// @XmlElement(name = "pubDate")
	public String getPubDate() {
		return pubDate;
	}

	public String getEmbed() {
		return embed;
	}

//	@XmlElement
	public void setTrailerLink() {
		String startTag = "src=\"";
		String endTag = "\"";
		System.out.println(embed);
		System.out.println("START: " +startTag);
		System.out.println("END: " +endTag);
		int beginIndex = embed.indexOf(startTag) + startTag.length();
		int endIndex = embed.indexOf(endTag, beginIndex);
		System.out.println(beginIndex);
		System.out.println(endIndex);
		this.trailerLink = "http:" + embed.substring(beginIndex, endIndex);
	}

	public String getTrailerLink() {
		return trailerLink;
	}

}
