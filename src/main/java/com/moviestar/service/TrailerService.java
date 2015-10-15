package com.moviestar.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;
import com.moviestar.entity.Movie;
import com.moviestar.entity.Trailer;

public class TrailerService {
	private static Trailer trailer;
	private static Movie movie;
	
	public static void main(String[] args) {
		
//		String url = "http://api.sr.se/api/v2/playlists/rightnow?channelid=2576&format=json";

//		String url = "http://api.traileraddict.com/";
		String url = "http://www.traileraddict.com/trailerapi";
		// Saknas förmodligen något i länken.

		HttpClient httpClient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;
		Reader reader = null;
		Gson json = new Gson();

		try {
			// Create the client that will call the API
			httpClient = HttpClients.createDefault();
			httpGet = new HttpGet(url);

			// Call the API and verify that all went well
			response = httpClient.execute(httpGet);
			status = response.getStatusLine();
			if (status.getStatusCode() == 200) {
				// All went well. Let's fetch the data
				entity = response.getEntity();
				data = entity.getContent();

				try {
					// Attempt to parse the data as JSON
					reader = new InputStreamReader(data);
					
					trailer = json.fromJson(reader, Trailer.class);
					
//					envelope = json.fromJson(reader, Envelope.class);
//					trailer = envelope.getPlaylist();

					// Print the info
					printTrailer(trailer.getLink());
					if (trailer.getLink() != null) {
						printTrailer(trailer.getLink());
					}
				} catch (Exception e) {
					// Something didn't went well. No calls for us.
					e.printStackTrace();
					System.out.println("Something went wrong!");
				}
			} else {
				// Something didn't went well. No calls for us.
				System.out.println("Something went wrong!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printTrailer(String link) {
		System.out.println("Trailer: " + trailer.getLink());
	}
}