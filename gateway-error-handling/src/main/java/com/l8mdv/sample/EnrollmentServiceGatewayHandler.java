package com.l8mdv.sample;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */
public class EnrollmentServiceGatewayHandler {

    public static final String GATEWAY_TIMEOUT_HANDLED = "gateway timeout caught and handled.";
    @Autowired
    EnrollmentServiceGateway timeoutHandlingGateway;

    public String send(String message) {

        try {
            String response = timeoutHandlingGateway.send(message);
            if (response == null) {
                // A gateway timeout occurred.
                response = GATEWAY_TIMEOUT_HANDLED;
            }
            return response;
        }
        catch(Exception e) {
            e.printStackTrace();
            return GATEWAY_TIMEOUT_HANDLED;
        }
    }
}
