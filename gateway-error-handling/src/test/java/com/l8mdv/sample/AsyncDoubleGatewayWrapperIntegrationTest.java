package com.l8mdv.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"classpath:META-INF/spring/async-double-gateway-wrapper.xml"}
)
public class AsyncDoubleGatewayWrapperIntegrationTest {

    private Logger logger = LoggerFactory.getLogger(AsyncDoubleGatewayWrapperIntegrationTest.class);
    @Resource
    @Qualifier(value = "enrollmentServiceGateway")
    private EnrollmentServiceGateway enrollmentServiceGateway;

    @Test
    public void requestTimeGreaterThanTimeout() throws Exception {
        String sleepPeriod = "6";
        String response = enrollmentServiceGateway.send(sleepPeriod);
        org.junit.Assert.assertTrue(response.equals(EnrollmentServiceGatewayHandler.GATEWAY_TIMEOUT_HANDLED));
    }

    @Test
    public void requestTimeLessThanTimeout() throws Exception {
        String sleepPeriod = "1";
        String response = enrollmentServiceGateway.send(sleepPeriod);
        org.junit.Assert.assertTrue(response.equals(sleepPeriod));
    }
}