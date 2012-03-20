package com.l8mdv.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"classpath:META-INF/spring/async-gateway-sa-wrapper.xml"}
)
public class AsyncDoubleGatewayWrapperIntegrationTest {

    Logger logger = LoggerFactory.getLogger(AsyncDoubleGatewayWrapperIntegrationTest.class);
    @Autowired GatewayTestingGateway gatewayTestingGateway;

    @Test
    public void requestTimeGreaterThanTimeout() throws Exception {
        String knapPeriod = "6";
        String response = gatewayTestingGateway.send(knapPeriod);
        org.junit.Assert.assertTrue(response.equals(TimeoutAndExceptionHandlingGatewayWrapper.GATEWAY_TIMEOUT_HANDLED));
    }

    @Test
    public void requestTimeLessThanTimeout() throws Exception {
        String knapPeriod = "1";
        String response = gatewayTestingGateway.send(knapPeriod);
        org.junit.Assert.assertTrue(response.equals(knapPeriod));
    }
}