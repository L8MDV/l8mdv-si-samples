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
    locations = {"classpath:META-INF/spring/async-gateway.xml"}
)
public class AsyncGatewayIntegrationTest {

    @Autowired
    EnrollmentServiceGateway enrollmentServiceGateway;

    @Test
    public void requestTimeGreaterThanTimeout() throws Exception {
        String knapPeriod = "5";
        String response = enrollmentServiceGateway.send(knapPeriod);
        org.junit.Assert.assertTrue(response == null);
    }

    @Test
    public void requestTimeLessThanTimeout() throws Exception {
        String knapPeriod = "1";
        String response = enrollmentServiceGateway.send(knapPeriod);
        org.junit.Assert.assertTrue(response.equals(knapPeriod));
    }
}