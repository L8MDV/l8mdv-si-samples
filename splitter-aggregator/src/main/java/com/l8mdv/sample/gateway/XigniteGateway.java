package com.l8mdv.sample.gateway;

import com.l8mdv.sa.BrokerQuoteRequestMessage;
import com.l8mdv.sa.BrokerQuoteResponseMessage;
import com.l8mdv.sample.exception.BrokerException;
import org.springframework.integration.annotation.Gateway;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 18/01/2012
 */
public interface XigniteGateway {

    @Gateway
    public BrokerQuoteRequestMessage send(BrokerQuoteResponseMessage response) throws BrokerException;
}
