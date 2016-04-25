/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastian.restserver.handlers;

import com.sebastian.restserver.Utils;
import com.google.gson.Gson;
import com.sebastian.restserver.communication.PersonCommunicator;
import com.sebastian.restserver.models.Person;
import com.sebastian.restserver.models.StatusResponse;

/**
 *
 * @author sebastian
 */
public class PersonGetHandler {
    
    public String run(String ci){
        Person person;
        Gson gson;
        PersonCommunicator personCommunicator;
        
        gson = new Gson();
        person = new Person();
        personCommunicator = new PersonCommunicator();
        
        if (ci == null) {
            person.setStatusCode("-1");
        }
        
        if (ci.equals("")) {
            person.setStatusCode("-2");
        }
        
        if (person.getStatusCode() != null && !person.getStatusCode().equals("0")) {
            StatusResponse status;
            
            status = new StatusResponse();
            
            status.setStatusCode(person.getStatusCode());
            status.setStatusMessage(Utils.getStatusMessage(person.getStatusCode()));
            
            return gson.toJson(status, StatusResponse.class);
        }
        
        person = personCommunicator.run(ci);
        
        if (!person.getStatusCode().equals("0")) {
            StatusResponse status;
            
            status = new StatusResponse();
            
            status.setStatusCode(person.getStatusCode());
            status.setStatusMessage(Utils.getStatusMessage(person.getStatusCode()));
            
            return gson.toJson(status, StatusResponse.class);
        }
        
        return gson.toJson(person, Person.class);
    }
}
