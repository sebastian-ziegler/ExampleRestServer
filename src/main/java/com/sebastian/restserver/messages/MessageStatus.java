package com.sebastian.restserver.messages;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sebastian
 */
public class MessageStatus {
    public static Map<String, String> messages;
    static{
        messages = new HashMap<String, String>();
        
        messages.put("-1", "Ci null");
        messages.put("-2", "Ci empty");
        messages.put("-99", "Backend error");
    }
}
