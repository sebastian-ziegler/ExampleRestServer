package com.sebastian.restserver;


import com.sebastian.restserver.messages.MessageStatus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastian
 */
public class Utils {
    public static final String getStatusMessage(String code){
        return MessageStatus.messages.getOrDefault(code, "Error");
    }
}
