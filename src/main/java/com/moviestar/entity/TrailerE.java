package com.moviestar.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.internal.ws.util.xml.CDATA;

@XmlType(propOrder = { "title", "link", "pubDate", "embed", "iframe" })
@XmlRootElement(name = "trailer")
public class TrailerE {

	private String link;
	private String title;
	private String trailerId;
	private String pubDate;
	private String embed;
	private String iFrame;

	public TrailerE() {
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
	
	public String getEmbed(){
		return embed;
	}
	@XmlElement
	public void setIframe(String iframe){
		String startTag = "<iframe>";
		String endTag = "</iframe>";
        int beginIndex = embed.indexOf(startTag) + startTag.length();
        int endIndex = embed.indexOf(endTag) -1;
        this.iFrame =  embed.substring(beginIndex, endIndex);

	}
	
	public String getIframe(){
		return iFrame;
	}
	

}
