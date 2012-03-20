package com.l8mdv.sample;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */
public class EnrollmentServiceGatewayHandler implements EnrollmentServiceGateway {

    public static final String GATEWAY_TIMEOUT_HANDLED = "gateway timeout caught and handled.";
    public EnrollmentServiceAdaptedGateway enrollmentServiceAdaptedGateway;

    public EnrollmentServiceGatewayHandler(EnrollmentServiceAdaptedGateway enrollmentServiceAdaptedGateway){
        this.enrollmentServiceAdaptedGateway = enrollmentServiceAdaptedGateway;
    }

    public String send(String message) {

        try {
            String response = enrollmentServiceAdaptedGateway.send(message);
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
