package com.l8mdv.sample.gateway;


import com.l8mdv.sa.BrokerQuoteRequestMessage;
import com.l8mdv.sa.BrokerQuoteResponseMessage;
import com.l8mdv.sample.exception.BrokerException;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 12/01/2012
 */
public interface BrokerRequestGateway {

    public BrokerQuoteResponseMessage send(BrokerQuoteRequestMessage message) throws BrokerException;
}
