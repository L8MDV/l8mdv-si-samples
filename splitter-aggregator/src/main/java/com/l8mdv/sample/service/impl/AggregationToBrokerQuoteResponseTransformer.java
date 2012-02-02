package com.l8mdv.sample.service.impl;

import com.l8mdv.sa.BrokerQuoteResponseMessage;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 30/01/2012
 */
public class AggregationToBrokerQuoteResponseTransformer {

    public BrokerQuoteResponseMessage
    transform(List<BrokerQuoteResponseMessage> serviceResponses) {

        Assert.notNull(serviceResponses, "Mandatory argument missing.");

        BrokerQuoteResponseMessage bestQuote = null;
        for (BrokerQuoteResponseMessage
                brokerQuoteResponseMessage: serviceResponses) {
            if (bestQuote == null)
                bestQuote = brokerQuoteResponseMessage;
            else {
                if (brokerQuoteResponseMessage.getSellPrice()
                        .compareTo(bestQuote.getSellPrice()) > 0)
                    bestQuote = brokerQuoteResponseMessage;
            }
        }

        return bestQuote;
    }
}
