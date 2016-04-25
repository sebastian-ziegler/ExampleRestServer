/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastian.restserver.communication;

import com.sebastian.restserver.communication.stubs.PersonSoapStub;
import com.sebastian.restserver.models.Person;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.axis2.AxisFault;

/**
 *
 * @author sebastian
 */
public class PersonCommunicator {
    public Person run(String ci){
        PersonSoapStub stub;
        PersonSoapStub.Person personSoap = new PersonSoapStub.Person();
        Person responsePerson;
        
        responsePerson = new Person();
        
        try {
            PersonSoapStub.SearchPersonE personSoapE;
            PersonSoapStub.SearchPersonResponseE responseE;
            PersonSoapStub.SearchPersonResponse response;
            
            stub = new PersonSoapStub();
            personSoapE = new PersonSoapStub.SearchPersonE();
            
            responseE = stub.searchPerson(personSoapE);
            response = responseE.getSearchPersonResponse();
            
            personSoap = response.get_return();
            
            if (!personSoap.getStatusCode().equals("-1")) {
                responsePerson.setCi(personSoap.getCi());
                responsePerson.setLastName(personSoap.getLastName());
                responsePerson.setName(personSoap.getName());
                responsePerson.setStatusCode(personSoap.getStatusCode());
            } else {
                responsePerson.setStatusCode("-99");
            }
        } catch (AxisFault ex) {
            responsePerson.setStatusCode("-98");
            Logger.getLogger(PersonCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            responsePerson.setStatusCode("-97");
            Logger.getLogger(PersonCommunicator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Person();
    }
}
