package com.l8mdv.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Copyright Matt Vickery 2012
 *
 * @author matt.d.vickery@gmail.com
 * @since 02/02/2012
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"classpath:META-INF/spring/async-gateway-null-downstream.xml"}
)
public class AsyncGatewayNullDownstreamIntegrationTest {

    @Autowired
    private EnrollmentServiceGateway enrollmentServiceGateway;

    @Test
    public void requestTimeGreaterThanTimeout() throws Exception {
        String sleepPeriod = "5";
//        String response = enrollmentServiceGateway.send(sleepPeriod);
//        org.junit.Assert.assertTrue(response == null);
    }
}