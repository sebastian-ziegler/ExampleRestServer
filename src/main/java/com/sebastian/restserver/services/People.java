/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastian.restserver.services;

import com.sebastian.restserver.handlers.PersonGetHandler;
import com.sebastian.restserver.models.Person;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sebastian
 */
@Path("/people")
public class People {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@QueryParam("ci") String ci){
        PersonGetHandler handler = new PersonGetHandler();
        String response;
        
        response = handler.run(ci);
        
        return response;
    }
}
