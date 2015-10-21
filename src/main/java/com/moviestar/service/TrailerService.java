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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.*;

/**
 * Klass som hämtar trailer från TrailerAddicts API. Funkar inte i nuläget.
 * 
 * @author Evy
 *
 */
@Path("/trailer")
public class TrailerService {

	@Path("/{trailerID}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	 public static void getTrailer(@PathParam("trailerID") String id) {
		HttpClient httpClient = null;
		HttpGet httpGet = null;
		HttpResponse response = null;
		StatusLine status = null;
		HttpEntity entity = null;
		InputStream data = null;

		try {
			// Skapar klienten som kallar på APIt.
			httpClient = HttpClients.createDefault();
//			httpGet = new HttpGet(
//					"http://simpleapi.traileraddict.com/The-Shining/trailer");
//			String url = "http://v.traileraddict.com/" + id;
			String url = "http://v.traileraddict.com/12";
			httpGet = new HttpGet(url);

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
	 
	 public static void main(String[] args) {
		 getTrailer(null);
	 }
}