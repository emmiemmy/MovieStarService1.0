package com.moviestar.service;
import java.io.IOException;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
 * Klassen hämtar information från api omdb.com
 * @author emmashakespeare, evelyn, juicy
 * 
 * @Path		URI-endpointen. så att man hittar till klassen.
 *
 */

@Path("/collection")
public class MovieService {

	/**
	 * Metod getMovie som hämtar ett response från omdbapi.com, har parametern movietitle som läggs till i query-strängen.
	 * metoden retunrnerar resultatet i en String.
	 * @param movieTitle	String. Titel på film som skall sökas efter.
	 * @return result		String. Resultatet från söningen i jason format.
	 * 
	 * 
	 * @Path		URI end-pointen. så att man kan hitta till metoden.
	 * @Get			Metod som anropet skall använda mot api't.
	 * @Produces 	Returtyp som skall genereas.
	 */

	@Path("/{movietitle}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMovie(@PathParam("movietitle") String movieTitle) { 
		String result = "";
		HttpResponse<JsonNode> response;

		try {
			

			response = Unirest.get("http://www.omdbapi.com")
					.queryString("format", "json")
					.queryString("plot", "full")
					.queryString("t", movieTitle).asJson();

			System.out.println(response.getBody());
			JsonNode json = response.getBody();
			JSONObject envelope = json.getObject();
			
			result = envelope.toString();

//			 Unirest.shutdown();
		} catch (UnirestException e) {
			e.printStackTrace();
			
	} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		return result;
		
	}
}
