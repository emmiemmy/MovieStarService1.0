 package com.moviestar.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.CDATASection;

//import com.moviestar.entity.Trailer;
import com.moviestar.entity.Trailer;
import com.moviestar.entity.Trailers;
/**
 * Klassen kommunicerar med TrailerAddicts API. Då Traileraddict bara pratar XML måste vi använda oss av unmarschalling.
 * @author Emma Shakespeare, Evelyn Gustavsson, Jody O'neill
 *
 */
@Path("/watchtrailer")
public class TrailerService {

	/**
	 * Metoden skapar ett GET request till traileraddicts API. Användarens inmatade data hanteras som inparametrar.
	 * @param title - den filmtitel som skall sökas efter
	 * @return - En representation av resursen som JSON format
	 * @throws Exception
	 */
	@Path("/{movietitle}")
	@GET
//	@Produces(MediaType.TEXT_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Trailer getTrailer(@PathParam("movietitle") String title) throws Exception
	{
		String link = "";
		String movieTitle = title.replaceAll(" ", "-");
		String url = "http://api.traileraddict.com/?film=" + movieTitle + "&count=1";
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    try
	    {
	        //Definiera ett Http Request, GET i dett afall då det bara skall hämtas information från aktuellt API
	        HttpGet getRequest = new HttpGet(url);
	         
	        //Ange mediatyp so API accepterar
	        getRequest.addHeader("accept", "application/xml");
	          
	        //Skicka förfrågan till aktuellt API
	        HttpResponse response = httpClient.execute(getRequest);
	         
	        //validera svarskoden
	        int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != 200)
	        {
	            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	        }
	         
	        //Ta emot svaret
	        HttpEntity httpEntity = response.getEntity();
	        String apiOutput = EntityUtils.toString(httpEntity);
	         
	        //Skriv ut den information som mottagits i consolen
	        System.out.println(apiOutput); 	        
	         
	        //Eftersom informationen mottags som XML måsta vi unmarshalla
	        //Görs med JAXB
	        JAXBContext jaxbContext = JAXBContext.newInstance(Trailers.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        Trailers trailers = (Trailers) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));
	         
	        //Anropa metod som hanterar CDATA och plockar ut vääsentlig information
	        try{
	        trailers.getTrailer().setTrailerLink();
	        }catch (Exception e){
	        	System.out.println("Finns ingen länk att hämta");
	        }
	        return trailers.getTrailer();
	    }
	    finally
	    {
	        //Stäng uppkopplingen
	        httpClient.close();
	    }
		
	}

}
