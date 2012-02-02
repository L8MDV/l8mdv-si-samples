package com.l8mdv.sample.service;

import com.l8mdv.sa.BrokerQuoteRequestMessage;
import com.l8mdv.sa.BrokerRequest;
import com.l8mdv.sa.BrokerRequestMessage;
import com.l8mdv.sa.QuoteRequestSortPolicy;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 17/01/2012
 */
public class BrokerQuoteRequestSplitter {

    public List<BrokerQuoteRequestMessage> split(BrokerRequestMessage message) {

        Assert.notNull(message, "Mandatory argument missing.");
        List requests = new ArrayList();

        for (BrokerRequest brokerRequest:
                message.getBrokerRequest()) {
            BrokerQuoteRequestMessage brokerQuoteRequestMessage
                    = new BrokerQuoteRequestMessage();
            brokerQuoteRequestMessage
                    .setBrokerName(brokerRequest.getBrokerName());
            brokerQuoteRequestMessage
                    .setQuoteRequestSortPolicy(QuoteRequestSortPolicy.BUY_LOWEST);
            requests.add(brokerQuoteRequestMessage);
        }

        return requests;
    }
}
