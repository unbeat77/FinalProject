package com.hexa;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

// ..../rest/mydate/10/10/2018
@Path("/mydate")
public class mydate{
  @GET
  @Path("{day}/{month}/{year}")
  public Response displayDate(
    @PathParam("day") int argday,
    @PathParam("month") int argmonth,
    @PathParam("year") int argyear ){

      String urlDate = " Date received from URL is: "
      + argday+ ":" + argmonth + ":"+argyear;
      return Response.status(200).entity(urlDate).build();
    }
}