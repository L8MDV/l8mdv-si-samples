package com.l8mdv.sample;


/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */
public class SleeperService {

    public static final String INTERRUPTED_DURING_SERVICE_CALL = "interrupted during service call";

    public String service(String message) {

        System.out.println("Going into wait...");
        try {
            Thread.sleep(Long.parseLong(message)*1000);
            System.out.println("\n\n...waited");
            return message;
        } catch (Exception e) {
            Thread.interrupted();
            return INTERRUPTED_DURING_SERVICE_CALL;
        }
    }
}
