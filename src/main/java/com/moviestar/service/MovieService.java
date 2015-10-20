package com.moviestar.service;
/**
 * Fick något att funka iaf  nudå!
 */
import java.io.IOException;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.codehaus.jettison.json.JSONArray;
//import org.codehaus.jettison.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.moviestar.entity.Movie;
import com.moviestar.util.ToJSON;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * 
 * @author emmashakespeare, evelyn, juicy
 *
 */
@Path("/collection")
public class MovieService {

//	 @Path("/bestmovie")
//	 @GET
//	 @Produces(MediaType.APPLICATION_JSON)
//	 public Response getMovie(){
//	 Response rs = null;
//	
//	
//	 Movie movieObject = new Movie();
//	 JSONArray ja = new JSONArray();
//	 JSONObject jo = new JSONObject();
//	 ToJSON converter = new ToJSON();
//	 Map<String, Object> map;
//	
//	 //Skapa ett objekt
//	 movieObject.setActor("Kiera Knightley");
//	 movieObject.setTitle("Pirates of the carribean");
//	 movieObject.setDirector("Who knows");
//	 movieObject.setPlot("Johnny Depp takes on the world again");
//	 map = movieObject.getMap();
//	
//	 jo = converter.toJSONArray(map);
//	 ja.put(jo);
//	
//	 movieObject.setActor("Billy Boo");
//	 movieObject.setTitle("And on he take sit again");
//	 movieObject.setDirector("Willy Weiner");
//	 movieObject.setPlot("Three en are stuck in the dessert....");
//	 map = movieObject.getMap();
//	
//	 jo = converter.toJSONArray(map);
//	 ja.put(jo);
//	
//	 rs = Response.ok(ja.toString()).build();
//	
//	 return rs;
//	 }

	@Path("/trailer/{movieTitle}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getTrailer(@PathParam("movieTitle") String movieTitle){
		String title = "";
		HttpResponse<JsonNode> response;
		
		try{
			
			
			response = Unirest.get("http://api.traileraddict.com")
					.queryString("format", "xml")
					.queryString("actor", movieTitle).asJson();
			
			JsonNode json = response.getBody();
			JSONObject envelope = json.getObject();
			
			System.out.println(response.getBody());
			title = envelope.getString("title");

			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return title;

	}
	
	
	@Path("/{movietitle}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMovie(@PathParam("movietitle") String movieTitle) { // JSONArray movies = new JSONArray();
		String plot= "";
		String title= "";
		String director= "";
		String year= "";
		String result = "";

		HttpResponse<JsonNode> response;
		// HttpResponse<JsonNode> response2;

		try {
			// response2 =
			// Unirest.get("http://api.traileraddict.com/trailerapi").queryString("format",
			// "json")
			// .queryString("film", "Interstellar").asJson();
			// System.out.println(response2.getBody());
			// JsonNode json2 = response2.getBody();
			// JSONObject envelope2 = json2.getObject();
			// System.out.println("Länk: " + envelope2.getString("link"));

			response = Unirest.get("http://www.omdbapi.com")
					.queryString("format", "json")
					.queryString("t", movieTitle).asJson();

			System.out.println(response.getBody());
			JsonNode json = response.getBody();
			JSONObject envelope = json.getObject();
			// System.out.println("Titel: " + envelope.getString("Title"));
			title = envelope.getString("Title");
			year = envelope.getString("Year");
			director = envelope.getString("Director");
			plot = envelope.getString("Plot");
		//	result = "Title: " + title + "\nYear: " + year + "\nDirector: " + "\nPlot: " + plot;
			
			result = envelope.toString();

			// Unirest.shutdown();
		} catch (UnirestException e) {
			e.printStackTrace();
			// } catch (IOException e) {
			// e.printStackTrace();
			// }

			// HttpResponse<JsonNode> response2;

			// response2 =
			// Unirest.get("http://api.traileraddict.com/trailerapi").queryString("format",
			// "json")
			// .queryString("film", "Interstellar").asJson();
			// System.out.println(response2.getBody());
			// JsonNode json2 = response2.getBody();
			// JSONObject envelope2 = json2.getObject();
			// System.out.println("Länk: " + envelope2.getString("link"));
		}
		return result;
		
	}
}
