package com.moviestar.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/version")

/**
 * Class version.
 * Representerar nuvarande version.
 *
 */
public class Version {
	

	private static final String VERSION = "v 1.0";
	
	@Path("/check")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getVersion(){
		return VERSION;
	}

}

