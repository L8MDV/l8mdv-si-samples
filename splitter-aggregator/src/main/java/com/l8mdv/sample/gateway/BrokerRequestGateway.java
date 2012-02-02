package com.l8mdv.sample.gateway;


import com.l8mdv.sa.BrokerQuoteResponseMessage;
import com.l8mdv.sa.BrokerRequestMessage;
import com.l8mdv.sample.exception.BrokerException;
import org.springframework.integration.annotation.Gateway;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 12/01/2012
 */
public interface BrokerRequestGateway {

    @Gateway (requestChannel = "broker-request-channel")
    public BrokerQuoteResponseMessage send(BrokerRequestMessage message) throws BrokerException;
}
