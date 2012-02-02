package com.l8mdv.sample;

import com.l8mdv.sa.BrokerQuoteResponseMessage;
import com.l8mdv.sa.BrokerRequest;
import com.l8mdv.sa.BrokerRequestMessage;
import com.l8mdv.sa.BrokerRequestType;
import com.l8mdv.sample.gateway.BrokerRequestGateway;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 30/01/2012
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"classpath:META-INF/spring/simple-splitter-aggregator.xml"}
)
public class SimpleSplitterAggregatorIntegrationTest {

    @Autowired
    public BrokerRequestGateway brokerRequestGateway;

    @Test
    public void run() throws Exception {
        BrokerRequestMessage requestMessage = new BrokerRequestMessage();

        BrokerRequest yahooRequest = new BrokerRequest();
        yahooRequest.setBrokerName("yahoo");
        yahooRequest.setBrokerRequestType(BrokerRequestType.QUOTE);
        requestMessage.getBrokerRequest().add(yahooRequest);

        BrokerRequest oxRequest = new BrokerRequest();
        oxRequest.setBrokerName("openex");
        oxRequest.setBrokerRequestType(BrokerRequestType.QUOTE);
        requestMessage.getBrokerRequest().add(oxRequest);

        BrokerQuoteResponseMessage response = brokerRequestGateway.send(requestMessage);
        Assert.assertTrue(true);
    }

}
