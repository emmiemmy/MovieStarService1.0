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
import com.moviestar.entity.TrailerE;
import com.moviestar.entity.Trailers;

@Path("/watchtrailer")
public class EmmaTrailer {

	@Path("/{movietitle}")
	@GET
//	@Produces(MediaType.TEXT_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public TrailerE getTrailer(@PathParam("movietitle")String title) throws Exception
	{
		String link = "";
		String movieTitle = title.replaceAll(" ", "-");
		String url = "http://api.traileraddict.com/?film=" + movieTitle + "&count=1";
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    try
	    {
	        //Define a HttpGet request; You can choose between HttpPost, HttpDelete or HttpPut also.
	        //Choice depends on type of method you will be invoking.
	        HttpGet getRequest = new HttpGet(url);
	         
	        //Set the API media type in http accept header
	        getRequest.addHeader("accept", "application/xml");
	          
	        //Send the request; It will immediately return the response in HttpResponse object
	        HttpResponse response = httpClient.execute(getRequest);
	         
	        //verify the valid error code first
	        int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != 200)
	        {
	            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	        }
	         
	        //Now pull back the response object
	        HttpEntity httpEntity = response.getEntity();
	        String apiOutput = EntityUtils.toString(httpEntity);
	         
	        //Lets see what we got from API
	        System.out.println(apiOutput); //<user id="10"><firstName>demo</firstName><lastName>user</lastName></user>
	        
	         
	        //In realtime programming, you will need to convert this http response to some java object to re-use it.
	        //Lets see how to jaxb unmarshal the api response content
	        JAXBContext jaxbContext = JAXBContext.newInstance(Trailers.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        Trailers trailers = (Trailers) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));
	         
//	        Verify the populated object
	        link = trailers.getTrailer().getLink();
	        System.out.println(link);
	        trailers.getTrailer().setTrailerLink();
	        System.out.println("Länk: " + trailers.getTrailer().getTrailerLink());
	        return trailers.getTrailer();
	    }
	    finally
	    {
	        //Important: Close the connect
	        httpClient.close();
	    }
		
	}
	
	public static void main(String[] args) throws Exception {
		EmmaTrailer run = new EmmaTrailer();
//		run.demoGetRESTAPI();
//		run.getTrailer("heat");
	}

}
