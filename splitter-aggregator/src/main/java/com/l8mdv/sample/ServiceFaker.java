package com.l8mdv.sample;

import com.l8mdv.sa.BrokerQuoteResponseMessage;
import com.l8mdv.sa.BrokerResponseMessage;
import org.springframework.integration.Message;

import java.math.BigDecimal;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 30/01/2012
 */
public class ServiceFaker {

    BrokerResponseMessage brokerResponseMessage;
    public ServiceFaker(BrokerResponseMessage response) {
        this.brokerResponseMessage = response;
    }

    public BrokerQuoteResponseMessage service(Message<?> message) {

        BrokerQuoteResponseMessage brokerQuoteResponseMessage =
                new BrokerQuoteResponseMessage();
        brokerQuoteResponseMessage.setBrokerName(brokerResponseMessage.getBrokerName());
        brokerQuoteResponseMessage.setSellPrice(new BigDecimal(brokerResponseMessage.getValue()));

        return brokerQuoteResponseMessage;
    }
}
