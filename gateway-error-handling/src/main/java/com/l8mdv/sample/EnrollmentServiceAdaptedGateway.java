package com.l8mdv.sample;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */
public interface EnrollmentServiceAdaptedGateway extends GatewayTestingGateway {
    public String send(String payload);
}
