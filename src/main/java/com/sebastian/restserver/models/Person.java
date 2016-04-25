/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebastian.restserver.models;

import java.io.Serializable;

/**
 *
 * @author sebastian
 */
public class Person extends StatusResponse implements Serializable{
    String ci;
    String name;
    String lastName;

    public Person() {
    }

    public Person(String ci, String name, String lastName) {
        this.ci = ci;
        this.name = name;
        this.lastName = lastName;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
   
    
}
