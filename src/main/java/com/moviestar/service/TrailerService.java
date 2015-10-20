package com.moviestar.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.moviestar.entity.Trailer;
import com.moviestar.entity.TrailerXML;
import javax.xml.bind.JAXBContext;

/**
 * Klass som hämtar trailer från TrailerAddicts API. Funkar inte i nuläget.
 * 
 * @author Evy
 *
 */
public class TrailerService {

	public void getTrailer(String request) {
		HttpClient httpClient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;

		try {
			// Skapar klienten som kallar på APIt.
			httpClient = HttpClients.createDefault();
			httpGet = new HttpGet("http://simpleapi.traileraddict.com/Interstellar/trailer");

			// Anropar APIt och verifierar att allt gått bra.
			response = httpClient.execute(httpGet);
			status = response.getStatusLine();

			if (status.getStatusCode() == 200) {

				System.out.println("Det går bra nu!");

				entity = response.getEntity();
				data = entity.getContent();

				try {
					// Konverterar datan till Json.
					JAXBContext jaxb = JAXBContext.newInstance(TrailerXML.class);

					TrailerXML trailers = (TrailerXML) jaxb.createUnmarshaller().unmarshal(data);

					Trailer trailer = trailers.getTrailer();
					System.out.println(trailer.toString());

				} catch (Exception e) {
					// Något gick fel!
					e.printStackTrace();
					System.out.println("TrailerAddicts API svarade inte som väntat..");

				}
			} else {

				// Något gick fel!
				System.out.println("TrailerAddicts API svarade inte som väntat...");

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}