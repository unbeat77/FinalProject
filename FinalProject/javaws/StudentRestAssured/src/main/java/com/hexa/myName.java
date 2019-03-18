package com.hexa;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.Response;

@Path("/myName")
public class myName{

  @GET
  @Produces("text/html")
  public Response displayMyName(@QueryParam("stname") String namevalue) {
    String str = "My name is " + namevalue;
    return Response.status(200).entity(str).build();
  }
}
