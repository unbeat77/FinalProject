package com.hexa;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;  
import javax.ws.rs.Path;  
import javax.ws.rs.core.Response;  
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//  ../rest/product/add

@Path("/product")  
public class ProductService{  
    @POST  
    @Path("/add")  
   	@Produces(MediaType.APPLICATION_JSON)
    public Response addUser(  
        @FormParam("id") int id,  
        @FormParam("name") String name,  
        @FormParam("price") float price) {  
        /*    
        return Response.status(200)  
            .entity(" Product added successfuly!<br> Id: "+id+"<br> Name: " + name+"<br> Price: "+price)  
            .build();  
        */
        String str = "{\"result\":\"product added successfull\", " + 
            "\"id\":\""+ id + "\"," +
            "\"name\":\""+ name + "\"," +
            "\"price\":\""+ price + "\"" +
            "}";
        return Response.status(200)  
            .entity(str)  
            .build();    
    }  
}  