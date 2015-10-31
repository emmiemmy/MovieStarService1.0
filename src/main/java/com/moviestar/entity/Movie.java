package com.moviestar.entity;

import java.util.HashMap;
import java.util.Map;
/**
 * Klassen representerar en Film med lämpliga attribut
 * @author Emma Shakespeare, Evelyn Gustavsson, Jody O'neill
 *
 */
public class Movie {
	
	private String title;
	private String plot;
	private String director;
	private String actor;
	
	public Map<String, Object> getMap(){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("title", this.title);
		map.put("plot", this.plot);
		map.put("director", this.director);
		map.put("actor", this.actor);
		return map;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

}
