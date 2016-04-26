package com.sebastian.restserver;

import com.sebastian.restserver.messages.MessageStatus;

/**
 *
 * @author sebastian
 */
public class Utils {

    public static final String getStatusMessage(String code) {
        String status;
        try {
            status = MessageStatus.messages.get(code);
        } catch (Exception ex) {
            status = "Error";
        }

        return status;
    }
}
